package fitnessstudio;

import java.util.Objects;

/**
 * Klasse zur Repräsentation eines Fitnessgeräts im System.
 * Geräte werden über ihre eindeutige {@code geraeteId} identifiziert.
 *
 * @author Evelyn Bukaev, Marvin Röhrig, Marvin Oberthür, Sören Hirschfeld & Simon Hanke
 * @version 1.0
 */
public class Geraet {
    private String geraeteId;
    private String geraeteName;
    private GeraeteKategorie kategorie;

    /**
     * Konstruktor für ein Geraet-Objekt.
     *
     * @param geraeteId   Eindeutige ID des Geräts (darf nicht null oder leer sein)
     * @param geraeteName Name des Geräts (darf nicht null oder leer sein)
     * @param kategorie   Kategorie des Geräts (darf nicht null sein)
     * @throws IllegalArgumentException falls ein Parameter ungültig ist
     */
    public Geraet(String geraeteId, String geraeteName, GeraeteKategorie kategorie) {
        if (geraeteId == null || geraeteId.trim().isEmpty()) {
            throw new IllegalArgumentException("Die Geräte-ID darf nicht null oder leer sein.");
        }
        if (geraeteName == null || geraeteName.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Gerätename darf nicht null oder leer sein.");
        }
        if (kategorie == null) {
            throw new IllegalArgumentException("Die Kategorie darf nicht null sein.");
        }
        this.geraeteId = geraeteId.trim();
        this.geraeteName = geraeteName.trim();
        this.kategorie = kategorie;
    }

    /**
     * Gibt die Geräte-ID zurück.
     * 
     * @return Die Geräte-ID
     */
    public String getGeraeteId() {
        return geraeteId;
    }

    /**
     * Setzt die Geräte-ID.
     * 
     * @param geraeteId Die neue Geräte-ID
     */
    public void setGeraeteId(String geraeteId) {
        this.geraeteId = geraeteId;
    }

    /**
     * Gibt den Gerätenamen zurück.
     * 
     * @return Der Gerätename
     */
    public String getGeraeteName() {
        return geraeteName;
    }

    /**
     * Setzt den Gerätenamen.
     * 
     * @param geraeteName Der neue Gerätename
     */
    public void setGeraeteName(String geraeteName) {
        this.geraeteName = geraeteName;
    }

    /**
     * Gibt die Kategorie des Geräts zurück.
     * 
     * @return Die Gerätekategorie
     */
    public GeraeteKategorie getKategorie() {
        return kategorie;
    }

    /**
     * Setzt die Kategorie des Geräts.
     * 
     * @param kategorie Die neue Kategorie
     */
    public void setKategorie(GeraeteKategorie kategorie) {
        this.kategorie = kategorie;
    }

    /**
     * Gibt eine String-Repräsentation des Geräts zurück.
     * 
     * @return String mit Geräteinformationen
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Geraet other = (Geraet) obj;
        return Objects.equals(geraeteId, other.geraeteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geraeteId);
    }

    @Override
    public String toString() {
        return "Geraet [ID: " + geraeteId + ", Name: " + geraeteName + ", Kategorie: " + kategorie + "]";
    }
}
