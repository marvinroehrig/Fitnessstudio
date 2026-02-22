import fitnessstudio.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hauptklasse für das Fitnessstudio-System.
 * Implementiert alle Test-Szenarien aus der Aufgabenstellung.
 * 
 * @author Evelyn Bukaev
 * @author Marvin Röhrig
 * @author Marvin Oberthür
 * @author Sören Hirschfeld
 * @author Simon Hanke
 * @version 1.0
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Fitnessstudio-System Test ===\n");

        // Erstelle Fitnessstudio-Instanz
        Fitnessstudio fitnessstudio = new Fitnessstudio();

        // ============================================
        // Test 1: 10 Geräte anlegen
        // ============================================
        System.out.println("--- Test 1: 10 Geräte anlegen ---");

        Geraet geraet1 = new Geraet("G001", "Laufband", GeraeteKategorie.AUSDAUER);
        Geraet geraet2 = new Geraet("G002", "Beinpresse", GeraeteKategorie.KRAFT);
        Geraet geraet3 = new Geraet("G003", "Rudergerät", GeraeteKategorie.AUSDAUER);
        Geraet geraet4 = new Geraet("G004", "Bankdrückmaschine", GeraeteKategorie.KRAFT);
        Geraet geraet5 = new Geraet("G005", "Kurzhanteln", GeraeteKategorie.KRAFT);
        Geraet geraet6 = new Geraet("G006", "Langhantel", GeraeteKategorie.KRAFT);
        Geraet geraet7 = new Geraet("G007", "Fahrradergometer", GeraeteKategorie.AUSDAUER);
        Geraet geraet8 = new Geraet("G008", "Kabelzug", GeraeteKategorie.KRAFT);
        Geraet geraet9 = new Geraet("G009", "Kettlebell", GeraeteKategorie.AUSDAUER);
        Geraet geraet10 = new Geraet("G010", "Faszienrolle", GeraeteKategorie.AUSDAUER);

        fitnessstudio.legeGeraetAn(geraet1);
        fitnessstudio.legeGeraetAn(geraet2);
        fitnessstudio.legeGeraetAn(geraet3);
        fitnessstudio.legeGeraetAn(geraet4);
        fitnessstudio.legeGeraetAn(geraet5);
        fitnessstudio.legeGeraetAn(geraet6);
        fitnessstudio.legeGeraetAn(geraet7);
        fitnessstudio.legeGeraetAn(geraet8);
        fitnessstudio.legeGeraetAn(geraet9);
        fitnessstudio.legeGeraetAn(geraet10);

        System.out.println("10 Geräte erfolgreich angelegt.\n");

        // ============================================
        // Test 2: 4 Mitglieder anlegen
        // ============================================
        System.out.println("--- Test 2: 4 Mitglieder anlegen ---");

        Mitglied mitglied1 = new Mitglied("M001", "Max Mustermann", "Musterstraße 1, 12345 Musterstadt");
        Mitglied mitglied2 = new Mitglied("M002", "Anna Schmidt", "Beispielweg 5, 54321 Beispielstadt");
        Mitglied mitglied3 = new Mitglied("M003", "Peter Müller", "Teststraße 10, 67890 Teststadt");
        Mitglied mitglied4 = new Mitglied("M004", "Lisa Weber", "Demosplatz 3, 11111 Demostadt");

        fitnessstudio.legeMitgliedAn(mitglied1);
        fitnessstudio.legeMitgliedAn(mitglied2);
        fitnessstudio.legeMitgliedAn(mitglied3);
        fitnessstudio.legeMitgliedAn(mitglied4);

        System.out.println("4 Mitglieder erfolgreich angelegt.\n");

        // ============================================
        // Test 3: Mehrere Fitnesspläne mit Übungen erstellen
        // ============================================
        System.out.println("--- Test 3: Fitnesspläne mit Übungen erstellen ---");

        // Ganzkörperplan
        List<Uebung> ganzkoerperUebungen = new ArrayList<>();
        ganzkoerperUebungen.add(new WiederholungsUebung("Bankdrücken", "Brustmuskulatur trainieren", 3, geraet4, 12));
        ganzkoerperUebungen.add(new WiederholungsUebung("Kniebeugen", "Beinmuskulatur trainieren", 4, geraet2, 15));
        ganzkoerperUebungen.add(new DauerUebung("Laufen", "Ausdauer trainieren", 1, geraet1, 20));

        Fitnessplan ganzkoerperPlan = null;
        
        try {
            ganzkoerperPlan = fitnessstudio.erstelleFitnessplan("Ganzkörperplan", ganzkoerperUebungen);
            System.out.println("Ganzkörperplan erfolgreich erstellt.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Erstellen des Ganzkörperplans: " + e.getMessage());
        }

        // Beintraining
        List<Uebung> beinUebungen = new ArrayList<>();
        beinUebungen.add(new WiederholungsUebung("Beinpresse", "Beinmuskulatur kräftigen", 4, geraet2, 12));
        beinUebungen.add(new WiederholungsUebung("Kniebeugen mit Langhantel", "Beine und Gesäß trainieren", 3, geraet6, 10));

        Fitnessplan beinPlan = null;

        try {
            beinPlan = fitnessstudio.erstelleFitnessplan("Beintraining", beinUebungen);
            System.out.println("Beintraining erfolgreich erstellt.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Erstellen des Beintrainings: " + e.getMessage());
        }

        // Rückenplan
        List<Uebung> rueckenUebungen = new ArrayList<>();
        rueckenUebungen.add(new WiederholungsUebung("Rudern", "Rückenmuskulatur trainieren", 3, geraet3, 15));
        rueckenUebungen.add(new WiederholungsUebung("Latziehen", "Oberer Rücken", 3, geraet8, 12));

        Fitnessplan rueckenPlan = null;

        try {
            rueckenPlan = fitnessstudio.erstelleFitnessplan("Rückenplan", rueckenUebungen);
            System.out.println("Rückenplan erfolgreich erstellt.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Erstellen des Rückenplans: " + e.getMessage());
        }

        // Ausdauerplan
        List<Uebung> ausdauerUebungen = new ArrayList<>();
        ausdauerUebungen.add(new DauerUebung("Laufen", "Ausdauer trainieren", 1, geraet1, 30));
        ausdauerUebungen.add(new DauerUebung("Radfahren", "Beinausdauer trainieren", 1, geraet7, 25));

        Fitnessplan ausdauerPlan = null;

        try {
            ausdauerPlan = fitnessstudio.erstelleFitnessplan("Ausdauerplan", ausdauerUebungen);
            System.out.println("Ausdauerplan erfolgreich erstellt.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Erstellen des Ausdauerplans: " + e.getMessage());
        }

        System.out.println();

        // ============================================
        // Test 4: Gültigen Plan erfolgreich zuweisen
        // ============================================
        System.out.println("--- Test 4: Gültigen Plan erfolgreich zuweisen ---");

        try {
            fitnessstudio.weisePlanZu(mitglied1, ganzkoerperPlan);
            System.out.println("Ganzkörperplan wurde " + mitglied1.getName() + " erfolgreich zugewiesen.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println();

        // ============================================
        // Test 5: Plan mit nicht vorhandenem Gerät ablehnen
        // ============================================
        System.out.println("--- Test 5: Plan mit nicht vorhandenem Gerät ablehnen ---");
        
        // Erstelle ein Gerät, das nicht im System ist
        Geraet nichtVorhandenesGeraet = new Geraet("G999", "Nicht vorhandenes Gerät", GeraeteKategorie.KRAFT);
        
        List<Uebung> ungueltigeUebungen = new ArrayList<>();
        ungueltigeUebungen.add(new WiederholungsUebung("Testübung", "Test", 3, nichtVorhandenesGeraet, 10));

        try {
            fitnessstudio.erstelleFitnessplan("Ungültiger Plan", ungueltigeUebungen);
            System.out.println("FEHLER: Ungültiger Plan wurde fälschlicherweise erstellt!");
        } catch (IllegalArgumentException e) {
            System.out.println("Korrekt abgelehnt: " + e.getMessage());
        }

        System.out.println();

        // ============================================
        // Test 6: Plan gesperrtem Mitglied zuweisen (ablehnen)
        // ============================================
        System.out.println("--- Test 6: Plan gesperrtem Mitglied zuweisen (ablehnen) ---");
        
        // Sperre Mitglied 2
        mitglied2.setGesperrt(true);
        System.out.println("Mitglied " + mitglied2.getName() + " wurde gesperrt.");

        try {
            fitnessstudio.weisePlanZu(mitglied2, beinPlan);
            System.out.println("FEHLER: Plan wurde fälschlicherweise zugewiesen!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Korrekt abgelehnt: " + e.getMessage());
        }
        
        System.out.println();

        // ============================================
        // Test 7: 3 Pläne zuweisen, 4. Versuch ablehnen
        // ============================================
        System.out.println("--- Test 7: 3 Pläne zuweisen, 4. Versuch ablehnen ---");
        
        // Weise Mitglied 3 drei Pläne zu
        try {
            fitnessstudio.weisePlanZu(mitglied3, ganzkoerperPlan);
            System.out.println("Plan 1 zugewiesen: Ganzkörperplan");
            
            fitnessstudio.weisePlanZu(mitglied3, beinPlan);
            System.out.println("Plan 2 zugewiesen: Beintraining");
            
            fitnessstudio.weisePlanZu(mitglied3, rueckenPlan);
            System.out.println("Plan 3 zugewiesen: Rückenplan");
            
            // Versuch, einen 4. Plan zuzuweisen
            fitnessstudio.weisePlanZu(mitglied3, ausdauerPlan);
            System.out.println("FEHLER: 4. Plan wurde fälschlicherweise zugewiesen!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Korrekt abgelehnt: " + e.getMessage());
        }

        System.out.println();

        // ============================================
        // Test 8: Aktive Pläne eines Mitglieds ausgeben
        // ============================================
        System.out.println("--- Test 8: Aktive Pläne eines Mitglieds ausgeben ---");
        
        System.out.println("Aktive Fitnesspläne von " + mitglied3.getName() + " (Nr. " + mitglied3.getMitgliedsnummer() + "):");
        System.out.println("Anzahl aktiver Pläne: " + mitglied3.getAktivePlaene().size());
        
        List<Fitnessplan> aktivePlaene = mitglied3.getAktivePlaene();
        for (int i = 0; i < aktivePlaene.size(); i++) {
            System.out.println("\nPlan " + (i + 1) + ":");
            System.out.println(aktivePlaene.get(i));
        }

        System.out.println("\n=== Alle Tests abgeschlossen ===");
    }
}
