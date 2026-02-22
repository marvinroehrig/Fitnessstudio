package fitnessstudio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klasse zur Repräsentation eines Fitnessplans.
 * Ein Fitnessplan besteht aus mehreren Übungen und kann nur gespeichert werden,
 * wenn alle verwendeten Geräte im System vorhanden sind.
 *
 * @author Evelyn Bukaev
 * @author Marvin Röhrig
 * @author Marvin Oberthür
 * @author Sören Hirschfeld
 * @author Simon Hanke
 * @version 1.0
 */
public class Fitnessplan {
    private String name;
    private final List<Uebung> uebungen;

    /**
     * Konstruktor für einen Fitnessplan.
     *
     * @param name Name des Fitnessplans (darf nicht null oder leer sein)
     * @throws IllegalArgumentException falls der Name ungültig ist
     */
    public Fitnessplan(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Planname darf nicht null oder leer sein.");
        }
        
        this.name = name.trim();
        this.uebungen = new ArrayList<>();
    }

    /**
     * Gibt den Namen des Fitnessplans zurück.
     * 
     * @return Der Name des Plans
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Fitnessplans.
     * 
     * @param name Der neue Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt eine unveränderliche Liste der Übungen zurück.
     *
     * @return unveränderliche Liste der Übungen
     */
    public List<Uebung> getUebungen() {
        return Collections.unmodifiableList(new ArrayList<>(uebungen));
    }

    /**
     * Fügt eine Übung zum Plan hinzu.
     * 
     * @param uebung Die hinzuzufügende Übung
     */
    public void addUebung(Uebung uebung) {
        if (uebung != null) {
            this.uebungen.add(uebung);
        }
    }

    /**
     * Prüft, ob alle in diesem Plan verwendeten Geräte in der übergebenen
     * Liste vorhanden sind. Ein Fitnessplan kann nur gespeichert werden,
     * wenn alle verwendeten Geräte im System existieren.
     * 
     * @param verfuegbareGeraete Liste der verfügbaren Geräte im System
     * @return true, wenn alle Geräte vorhanden sind, sonst false
     */
    public boolean istGueltig(List<Geraet> verfuegbareGeraete) {
        if (verfuegbareGeraete == null || uebungen.isEmpty()) {
            return false;
        }

        // Prüfe für jede Übung, ob das benötigte Gerät vorhanden ist
        for (Uebung uebung : uebungen) {
            if (uebung.getGeraet() == null) {
                return false;
            }

            boolean geraetGefunden = false;

            for (Geraet geraet : verfuegbareGeraete) {
                if (geraet.getGeraeteId().equals(uebung.getGeraet().getGeraeteId())) {
                    geraetGefunden = true;
                    break;
                }
            }

            if (!geraetGefunden) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gibt eine String-Repräsentation des Fitnessplans zurück.
     * 
     * @return String mit Planinformationen
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Fitnessplan: ").append(name).append("\n");
        sb.append("Übungen:\n");

        for (int i = 0; i < uebungen.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(uebungen.get(i)).append("\n");
        }

        return sb.toString();
    }
}
