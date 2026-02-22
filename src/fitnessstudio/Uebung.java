package fitnessstudio;

/**
 * Abstrakte Basisklasse für Übungen im Fitnessstudio.
 * Jede Übung benötigt genau ein Gerät.
 * 
 * @author Fitnessstudio-System
 * @version 1.0
 */
public abstract class Uebung {
    private String name;
    private String beschreibung;
    private int saetze;
    private Geraet geraet;

    /**
     * Konstruktor für eine Uebung.
     * 
     * @param name Name der Übung
     * @param beschreibung Kurze Beschreibung der Übung
     * @param saetze Anzahl der Sätze
     * @param geraet Das benötigte Gerät
     */
    public Uebung(String name, String beschreibung, int saetze, Geraet geraet) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.saetze = saetze;
        this.geraet = geraet;
    }

    /**
     * Gibt den Namen der Übung zurück.
     * 
     * @return Der Name der Übung
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen der Übung.
     * 
     * @param name Der neue Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Beschreibung der Übung zurück.
     * 
     * @return Die Beschreibung
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Setzt die Beschreibung der Übung.
     * 
     * @param beschreibung Die neue Beschreibung
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     * Gibt die Anzahl der Sätze zurück.
     * 
     * @return Die Anzahl der Sätze
     */
    public int getSaetze() {
        return saetze;
    }

    /**
     * Setzt die Anzahl der Sätze.
     * 
     * @param saetze Die neue Anzahl der Sätze
     */
    public void setSaetze(int saetze) {
        this.saetze = saetze;
    }

    /**
     * Gibt das benötigte Gerät zurück.
     * 
     * @return Das Gerät
     */
    public Geraet getGeraet() {
        return geraet;
    }

    /**
     * Setzt das benötigte Gerät.
     * 
     * @param geraet Das neue Gerät
     */
    public void setGeraet(Geraet geraet) {
        this.geraet = geraet;
    }

    /**
     * Abstrakte Methode zur Ausgabe der spezifischen Übungsdetails.
     * Wird von den Unterklassen implementiert.
     * 
     * @return String mit den Übungsdetails
     */
    public abstract String getUebungsDetails();

    /**
     * Gibt eine String-Repräsentation der Übung zurück.
     * 
     * @return String mit Übungsinformationen
     */
    @Override
    public String toString() {
        return name + " - " + beschreibung + " (" + saetze + " Sätze, " + getUebungsDetails() + ")";
    }
}
