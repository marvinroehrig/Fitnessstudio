package fitnessstudio;

/**
 * Klasse für Übungen, die durch eine Trainingsdauer charakterisiert werden.
 * 
 * @author Evelyn Bukaev
 * @author Marvin Röhrig
 * @author Marvin Oberthür
 * @author Sören Hirschfeld
 * @author Simon Hanke
 * @version 1.0
 */
public class DauerUebung extends Uebung {
    private int trainingsdauerMin;

    /**
     * Konstruktor für eine DauerUebung.
     * 
     * @param name Name der Übung
     * @param beschreibung Kurze Beschreibung der Übung
     * @param saetze Anzahl der Sätze
     * @param geraet Das benötigte Gerät
     * @param trainingsdauerMin Trainingsdauer in Minuten
     */
    public DauerUebung(String name, String beschreibung, int saetze, Geraet geraet, int trainingsdauerMin) {
        super(name, beschreibung, saetze, geraet);
        if (trainingsdauerMin < 1) {
            throw new IllegalArgumentException("Die Trainingsdauer muss mindestens 1 Minute betragen.");
        }
        this.trainingsdauerMin = trainingsdauerMin;
    }

    /**
     * Gibt die Trainingsdauer in Minuten zurück.
     * 
     * @return Die Trainingsdauer in Minuten
     */
    public int getTrainingsdauerMin() {
        return trainingsdauerMin;
    }

    /**
     * Setzt die Trainingsdauer in Minuten.
     * 
     * @param trainingsdauerMin Die neue Trainingsdauer in Minuten
     */
    public void setTrainingsdauerMin(int trainingsdauerMin) {
        this.trainingsdauerMin = trainingsdauerMin;
    }

    /**
     * Gibt die spezifischen Details der Dauerübung zurück.
     * 
     * @return String mit Dauerinformationen
     */
    @Override
    public String getUebungsDetails() {
        return trainingsdauerMin + " Minuten";
    }
}
