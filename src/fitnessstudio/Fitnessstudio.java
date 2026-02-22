package fitnessstudio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hauptverwaltungsklasse für das Fitnessstudio-System.
 * Verwaltet Geräte, Mitglieder und Fitnesspläne. Nur hier registrierte
 * Mitglieder und Pläne können in Zuweisungen verwendet werden.
 *
 * @author Evelyn Bukaev
 * @author Marvin Röhrig
 * @author Marvin Oberthür
 * @author Sören Hirschfeld
 * @author Simon Hanke
 * @version 1.0
 */
public class Fitnessstudio {
    private final List<Geraet> geraete;
    private final List<Mitglied> mitglieder;
    private final List<Fitnessplan> plaene;

    /**
     * Konstruktor für das Fitnessstudio.
     * Initialisiert alle Listen.
     */
    public Fitnessstudio() {
        this.geraete = new ArrayList<>();
        this.mitglieder = new ArrayList<>();
        this.plaene = new ArrayList<>();
    }

    /**
     * Fügt ein Gerät zum System hinzu.
     *
     * @param geraet Das hinzuzufügende Gerät (darf nicht null sein)
     * @throws IllegalArgumentException falls geraet null ist oder eine Geräte-ID bereits existiert
     */
    public void legeGeraetAn(Geraet geraet) {
        if (geraet == null) {
            throw new IllegalArgumentException("Das Gerät darf nicht null sein.");
        }
        if (getGeraetById(geraet.getGeraeteId()) != null) {
            throw new IllegalArgumentException("Ein Gerät mit der ID " + geraet.getGeraeteId() + " existiert bereits.");
        }
        geraete.add(geraet);
    }

    /**
     * Fügt ein Mitglied zum System hinzu.
     *
     * @param mitglied Das hinzuzufügende Mitglied (darf nicht null sein)
     * @throws IllegalArgumentException falls mitglied null ist oder die Mitgliedsnummer bereits existiert
     */
    public void legeMitgliedAn(Mitglied mitglied) {
        if (mitglied == null) {
            throw new IllegalArgumentException("Das Mitglied darf nicht null sein.");
        }
        if (getMitgliedByNummer(mitglied.getMitgliedsnummer()) != null) {
            throw new IllegalArgumentException("Ein Mitglied mit der Nr. " + mitglied.getMitgliedsnummer() + " existiert bereits.");
        }
        mitglieder.add(mitglied);
    }

    /**
     * Erstellt einen neuen Fitnessplan und validiert, ob alle verwendeten
     * Geräte im System vorhanden sind.
     *
     * @param name     Name des Fitnessplans (nicht null/leer)
     * @param uebungen Liste der Übungen für den Plan (nicht null/leer)
     * @return der erstellte Fitnessplan
     * @throws IllegalArgumentException wenn Name/Übungen ungültig sind oder nicht alle Geräte vorhanden sind
     */
    public Fitnessplan erstelleFitnessplan(String name, List<Uebung> uebungen) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Fehler: Der Planname darf nicht leer sein.");
        }

        if (uebungen == null || uebungen.isEmpty()) {
            throw new IllegalArgumentException("Fehler: Ein Fitnessplan muss mindestens eine Übung enthalten.");
        }

        // Erstelle neuen Plan
        Fitnessplan plan = new Fitnessplan(name);

        for (Uebung uebung : uebungen) {
            plan.addUebung(uebung);
        }

        // Validiere, ob alle Geräte vorhanden sind
        if (!plan.istGueltig(geraete)) {

            // Finde fehlende Geräte für Fehlermeldung
            List<String> fehlendeGeraete = new ArrayList<>();

            for (Uebung uebung : uebungen) {
                if (uebung.getGeraet() != null) {
                    boolean gefunden = false;

                    for (Geraet geraet : geraete) {
                        if (geraet.getGeraeteId().equals(uebung.getGeraet().getGeraeteId())) {
                            gefunden = true;
                            break;
                        }
                    }

                    if (!gefunden) {
                        fehlendeGeraete.add(uebung.getGeraet().getGeraeteName() + " (ID: " + 
                                uebung.getGeraet().getGeraeteId() + ")");
                    }
                }
            }

            throw new IllegalArgumentException("Fehler: Der Fitnessplan kann nicht angelegt werden, " +
                    "da folgende Geräte nicht im System vorhanden sind: " + String.join(", ", fehlendeGeraete));
        }

        // Plan ist gültig, füge zur Liste hinzu
        plaene.add(plan);

        return plan;
    }

    /**
     * Weist einem Mitglied einen Fitnessplan zu.
     * Das Mitglied muss im Studio registriert sein, der Plan muss vom Studio erstellt worden sein.
     * Zusätzlich gelten die Regeln in {@link Mitglied#addFitnessplan(Fitnessplan)} (nicht gesperrt, max. 3 Pläne).
     *
     * @param mitglied Das Mitglied, dem der Plan zugewiesen werden soll (muss im Studio registriert sein)
     * @param plan     Der zuzuweisende Fitnessplan (muss vom Studio erstellt sein)
     * @throws IllegalArgumentException falls mitglied oder plan null ist oder nicht zu diesem Studio gehören
     * @throws IllegalStateException   falls das Mitglied gesperrt ist oder bereits 3 aktive Pläne hat
     */
    public void weisePlanZu(Mitglied mitglied, Fitnessplan plan) {
        if (mitglied == null) {
            throw new IllegalArgumentException("Das Mitglied darf nicht null sein.");
        }
        if (plan == null) {
            throw new IllegalArgumentException("Der Fitnessplan darf nicht null sein.");
        }
        if (!mitglieder.contains(mitglied)) {
            throw new IllegalArgumentException("Das Mitglied " + mitglied.getName() + " (Nr. " + mitglied.getMitgliedsnummer() +
                    ") ist nicht in diesem Fitnessstudio registriert.");
        }
        if (!plaene.contains(plan)) {
            throw new IllegalArgumentException("Der Fitnessplan \"" + plan.getName() + "\" gehört nicht zu diesem Fitnessstudio.");
        }

        mitglied.addFitnessplan(plan);
    }

    /**
     * Sucht ein Gerät anhand seiner ID.
     * 
     * @param id Die Geräte-ID
     * @return Das gefundene Gerät oder null
     */
    public Geraet getGeraetById(String id) {
        if (id == null) {
            return null;
        }

        for (Geraet geraet : geraete) {
            if (geraet.getGeraeteId().equals(id)) {
                return geraet;
            }
        }

        return null;
    }

    /**
     * Sucht ein Mitglied anhand seiner Mitgliedsnummer.
     * 
     * @param nummer Die Mitgliedsnummer
     * @return Das gefundene Mitglied oder null
     */
    public Mitglied getMitgliedByNummer(String nummer) {
        if (nummer == null) {
            return null;
        }

        for (Mitglied mitglied : mitglieder) {
            if (mitglied.getMitgliedsnummer().equals(nummer)) {
                return mitglied;
            }
        }

        return null;
    }

    /**
     * Gibt eine unveränderliche Liste aller Geräte zurück.
     *
     * @return unveränderliche Liste aller Geräte
     */
    public List<Geraet> getGeraete() {
        return Collections.unmodifiableList(new ArrayList<>(geraete));
    }

    /**
     * Gibt eine unveränderliche Liste aller Mitglieder zurück.
     *
     * @return unveränderliche Liste aller Mitglieder
     */
    public List<Mitglied> getMitglieder() {
        return Collections.unmodifiableList(new ArrayList<>(mitglieder));
    }

    /**
     * Gibt eine unveränderliche Liste aller Fitnesspläne zurück.
     *
     * @return unveränderliche Liste aller Pläne
     */
    public List<Fitnessplan> getPlaene() {
        return Collections.unmodifiableList(new ArrayList<>(plaene));
    }
}
