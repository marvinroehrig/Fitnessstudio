package fitnessstudio;

import java.util.ArrayList;
import java.util.List;

/**
 * Hauptverwaltungsklasse für das Fitnessstudio-System.
 * Verwaltet Geräte, Mitglieder und Fitnesspläne.
 * 
 * @author Fitnessstudio-System
 * @version 1.0
 */
public class Fitnessstudio {
    private List<Geraet> geraete;
    private List<Mitglied> mitglieder;
    private List<Fitnessplan> plaene;

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
     * @param geraet Das hinzuzufügende Gerät
     */
    public void addGeraet(Geraet geraet) {
        if (geraet != null) {
            geraete.add(geraet);
        }
    }

    /**
     * Fügt ein Mitglied zum System hinzu.
     * 
     * @param mitglied Das hinzuzufügende Mitglied
     */
    public void addMitglied(Mitglied mitglied) {
        if (mitglied != null) {
            mitglieder.add(mitglied);
        }
    }

    /**
     * Erstellt einen neuen Fitnessplan und validiert, ob alle verwendeten
     * Geräte im System vorhanden sind.
     * 
     * @param name Name des Fitnessplans
     * @param uebungen Liste der Übungen für den Plan
     * @return Der erstellte Fitnessplan, oder null bei Fehler
     * @throws IllegalArgumentException wenn nicht alle Geräte vorhanden sind
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
     * Validiert dabei alle relevanten Constraints.
     * 
     * @param mitglied Das Mitglied, dem der Plan zugewiesen werden soll
     * @param plan Der zuzuweisende Fitnessplan
     * @return true, wenn erfolgreich zugewiesen, sonst false
     */
    public boolean weisePlanZu(Mitglied mitglied, Fitnessplan plan) {
        if (mitglied == null || plan == null) {
            return false;
        }

        try {
            // Die Validierung erfolgt in der addFitnessplan-Methode des Mitglieds
            mitglied.addFitnessplan(plan);
            return true;
        } catch (IllegalStateException e) {
            // Fehler wird bereits in addFitnessplan geworfen
            throw e;
        }
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
     * Gibt alle Geräte zurück.
     * 
     * @return Liste aller Geräte (defensive Kopie)
     */
    public List<Geraet> getGeraete() {
        return new ArrayList<>(geraete);
    }

    /**
     * Gibt alle Mitglieder zurück.
     * 
     * @return Liste aller Mitglieder (defensive Kopie)
     */
    public List<Mitglied> getMitglieder() {
        return new ArrayList<>(mitglieder);
    }

    /**
     * Gibt alle Fitnesspläne zurück.
     * 
     * @return Liste aller Pläne (defensive Kopie)
     */
    public List<Fitnessplan> getPlaene() {
        return new ArrayList<>(plaene);
    }
}
