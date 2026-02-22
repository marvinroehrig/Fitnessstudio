package fitnessstudio;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zur Repräsentation eines Fitnessstudio-Mitglieds.
 * Ein Mitglied kann maximal 3 aktive Fitnesspläne gleichzeitig besitzen.
 * Gesperrte Mitglieder dürfen keine neuen Pläne erhalten.
 * 
 * @author Fitnessstudio-System
 * @version 1.0
 */
public class Mitglied {
    private String mitgliedsnummer;
    private String name;
    private String adresse;
    private boolean gesperrt;
    private List<Fitnessplan> aktivePlaene;

    /**
     * Konstruktor für ein Mitglied.
     * 
     * @param mitgliedsnummer Eindeutige Mitgliedsnummer
     * @param name Name des Mitglieds
     * @param adresse Adresse des Mitglieds
     */
    public Mitglied(String mitgliedsnummer, String name, String adresse) {
        this.mitgliedsnummer = mitgliedsnummer;
        this.name = name;
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
     * Gibt die Liste der aktiven Fitnesspläne zurück.
     * 
     * @return Liste der aktiven Pläne (defensive Kopie)
     */
    public List<Fitnessplan> getAktivePlaene() {
        return new ArrayList<>(aktivePlaene); // Defensive Kopie
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

        // Prüfe, ob bereits 3 aktive Pläne vorhanden sind
        if (aktivePlaene.size() >= 3) {
            throw new IllegalStateException("Fehler: Das Mitglied " + name + " (Nr. " + mitgliedsnummer + 
                    ") hat bereits 3 aktive Fitnesspläne. Ein weiterer Plan kann nicht zugewiesen werden.");
        }

        // Füge Plan hinzu und setze ihn auf aktiv
        plan.setAktiv(true);
        aktivePlaene.add(plan);
        return true;
    }

    /**
     * Gibt eine String-Repräsentation des Mitglieds zurück.
     * 
     * @return String mit Mitgliedsinformationen
     */
    @Override
    public String toString() {
        return "Mitglied [Nr: " + mitgliedsnummer + ", Name: " + name + ", Adresse: " + adresse + 
                ", Gesperrt: " + gesperrt + ", Aktive Pläne: " + aktivePlaene.size() + "]";
    }
}
