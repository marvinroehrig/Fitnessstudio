package fitnessstudio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Klasse zur Repräsentation eines Fitnessstudio-Mitglieds.
 * Ein Mitglied kann maximal {@value #MAX_AKTIVE_PLAENE} aktive Fitnesspläne gleichzeitig besitzen.
 * Gesperrte Mitglieder dürfen keine neuen Pläne erhalten.
 *
 * @author Evelyn Bukaev, Marvin Röhrig, Marvin Oberthür, Sören Hirschfeld & Simon Hanke
 * @version 1.0
 */
public class Mitglied {
    /** Maximale Anzahl aktiver Fitnesspläne pro Mitglied. */
    public static final int MAX_AKTIVE_PLAENE = 3;

    private String mitgliedsnummer;
    private String name;
    private String adresse;
    private boolean gesperrt;
    private final List<Fitnessplan> aktivePlaene;

    /**
     * Konstruktor für ein Mitglied.
     *
     * @param mitgliedsnummer Eindeutige Mitgliedsnummer (darf nicht null oder leer sein)
     * @param name            Name des Mitglieds (darf nicht null oder leer sein)
     * @param adresse         Adresse des Mitglieds (darf nicht null sein)
     * @throws IllegalArgumentException falls ein Parameter ungültig ist
     */
    public Mitglied(String mitgliedsnummer, String name, String adresse) {
        if (mitgliedsnummer == null || mitgliedsnummer.trim().isEmpty()) {
            throw new IllegalArgumentException("Die Mitgliedsnummer darf nicht null oder leer sein.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Name darf nicht null oder leer sein.");
        }
        if (adresse == null) {
            throw new IllegalArgumentException("Die Adresse darf nicht null sein.");
        }
        this.mitgliedsnummer = mitgliedsnummer.trim();
        this.name = name.trim();
        this.adresse = adresse;
        this.gesperrt = false;
        this.aktivePlaene = new ArrayList<>();
    }

    /**
     * Gibt die Mitgliedsnummer zurück.
     * 
     * @return Die Mitgliedsnummer
     */
    public String getMitgliedsnummer() {
        return mitgliedsnummer;
    }

    /**
     * Setzt die Mitgliedsnummer.
     * 
     * @param mitgliedsnummer Die neue Mitgliedsnummer
     */
    public void setMitgliedsnummer(String mitgliedsnummer) {
        this.mitgliedsnummer = mitgliedsnummer;
    }

    /**
     * Gibt den Namen zurück.
     * 
     * @return Der Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen.
     * 
     * @param name Der neue Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Adresse zurück.
     * 
     * @return Die Adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setzt die Adresse.
     * 
     * @param adresse Die neue Adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gibt zurück, ob das Mitglied gesperrt ist.
     * 
     * @return true, wenn gesperrt, sonst false
     */
    public boolean isGesperrt() {
        return gesperrt;
    }

    /**
     * Setzt den Sperrstatus des Mitglieds.
     * 
     * @param gesperrt Der neue Sperrstatus
     */
    public void setGesperrt(boolean gesperrt) {
        this.gesperrt = gesperrt;
    }

    /**
     * Gibt eine unveränderliche Liste der aktiven Fitnesspläne zurück.
     *
     * @return unveränderliche Liste der aktiven Pläne
     */
    public List<Fitnessplan> getAktivePlaene() {
        return Collections.unmodifiableList(new ArrayList<>(aktivePlaene));
    }

    /**
     * Fügt einen Fitnessplan zu den aktiven Plänen hinzu.
     * Validiert dabei:
     * - Das Mitglied darf nicht gesperrt sein
     * - Maximal 3 aktive Pläne sind erlaubt
     * 
     * @param plan Der hinzuzufügende Fitnessplan
     * @return true, wenn erfolgreich hinzugefügt, sonst false
     * @throws IllegalStateException wenn das Mitglied gesperrt ist oder bereits 3 aktive Pläne hat
     */
    public boolean addFitnessplan(Fitnessplan plan) throws IllegalStateException {
        if (plan == null) {
            return false;
        }

        // Prüfe, ob Mitglied gesperrt ist
        if (gesperrt) {
            throw new IllegalStateException("Fehler: Das Mitglied " + name + " (Nr. " + mitgliedsnummer + 
                    ") ist gesperrt und kann keine neuen Fitnesspläne erhalten.");
        }

        // Prüfe, ob bereits die maximale Anzahl aktiver Pläne vorhanden ist
        if (aktivePlaene.size() >= MAX_AKTIVE_PLAENE) {
            throw new IllegalStateException("Fehler: Das Mitglied " + name + " (Nr. " + mitgliedsnummer +
                    ") hat bereits " + MAX_AKTIVE_PLAENE + " aktive Fitnesspläne. Ein weiterer Plan kann nicht zugewiesen werden.");
        }

        aktivePlaene.add(plan);

        return true;
    }

    /**
     * Gibt eine String-Repräsentation des Mitglieds zurück.
     * 
     * @return String mit Mitgliedsinformationen
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mitglied other = (Mitglied) obj;
        return Objects.equals(mitgliedsnummer, other.mitgliedsnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mitgliedsnummer);
    }

    @Override
    public String toString() {
        return "Mitglied [Nr: " + mitgliedsnummer + ", Name: " + name + ", Adresse: " + adresse +
                ", Gesperrt: " + gesperrt + ", Aktive Pläne: " + aktivePlaene.size() + "]";
    }
}
