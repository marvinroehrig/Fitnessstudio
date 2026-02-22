package fitnessstudio;

/**
 * Klasse zur Repräsentation eines Fitnessgeräts im System.
 * 
 * @author Fitnessstudio-System
 * @version 1.0
 */
public class Geraet {
    private String geraeteId;
    private String geraeteName;
    private GeraeteKategorie kategorie;

    /**
     * Konstruktor für ein Geraet-Objekt.
     * 
     * @param geraeteId Eindeutige ID des Geräts
     * @param geraeteName Name des Geräts
     * @param kategorie Kategorie des Geräts
     */
    public Geraet(String geraeteId, String geraeteName, GeraeteKategorie kategorie) {
        this.geraeteId = geraeteId;
        this.geraeteName = geraeteName;
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
    public String toString() {
        return "Geraet [ID: " + geraeteId + ", Name: " + geraeteName + ", Kategorie: " + kategorie + "]";
    }
}
