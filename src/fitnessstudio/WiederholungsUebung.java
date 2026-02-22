package fitnessstudio;

/**
 * Klasse für Übungen, die durch Wiederholungen charakterisiert werden.
 * 
 * @author Evelyn Bukaev
 * @author Marvin Röhrig
 * @author Marvin Oberthür
 * @author Sören Hirschfeld
 * @author Simon Hanke
 * @version 1.0
 */
public class WiederholungsUebung extends Uebung {
    private int wiederholungen;

    /**
     * Konstruktor für eine WiederholungsUebung.
     * 
     * @param name Name der Übung
     * @param beschreibung Kurze Beschreibung der Übung
     * @param saetze Anzahl der Sätze
     * @param geraet Das benötigte Gerät
     * @param wiederholungen Anzahl der Wiederholungen pro Satz
     */
    public WiederholungsUebung(String name, String beschreibung, int saetze, Geraet geraet, int wiederholungen) {
        super(name, beschreibung, saetze, geraet);
        if (wiederholungen < 1) {
            throw new IllegalArgumentException("Die Anzahl der Wiederholungen muss mindestens 1 sein.");
        }
        this.wiederholungen = wiederholungen;
    }

    /**
     * Gibt die Anzahl der Wiederholungen zurück.
     * 
     * @return Die Anzahl der Wiederholungen
     */
    public int getWiederholungen() {
        return wiederholungen;
    }

    /**
     * Setzt die Anzahl der Wiederholungen.
     * 
     * @param wiederholungen Die neue Anzahl der Wiederholungen
     */
    public void setWiederholungen(int wiederholungen) {
        this.wiederholungen = wiederholungen;
    }

    /**
     * Gibt die spezifischen Details der Wiederholungsübung zurück.
     * 
     * @return String mit Wiederholungsinformationen
     */
    @Override
    public String getUebungsDetails() {
        return wiederholungen + " Wiederholungen";
    }
}
