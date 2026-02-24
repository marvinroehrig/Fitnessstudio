## Fitnessstudio – Beispielprojekt (Java)

Dieses Projekt modelliert ein kleines **Fitnessstudio-Verwaltungssystem** in Java. Es demonstriert objektorientierte Konzepte wie Vererbung, Kapselung, Collections sowie Geschäftsregeln (z. B. maximale Anzahl aktiver Pläne pro Mitglied).

Die Anwendung wird über die Klasse `App` gestartet und führt verschiedene Testszenarien aus (Geräte anlegen, Mitglieder anlegen, Fitnesspläne erstellen, Pläne zuweisen und Validierungen prüfen).

### Funktionen

- **Geräteverwaltung**
  - Geräte mit ID, Name und Kategorie (`AUSDAUER`, `KRAFT`)
  - Validierung auf eindeutige Geräte-IDs
- **Mitgliederverwaltung**
  - Mitglieder mit Nummer, Name, Adresse
  - Sperrstatus für Mitglieder
  - Maximal 3 aktive Fitnesspläne pro Mitglied
- **Fitnesspläne**
  - Pläne mit beliebig vielen Übungen
  - Ein Plan ist nur gültig, wenn alle benötigten Geräte im System vorhanden sind
- **Übungen**
  - Abstrakte Basisklasse `Uebung`
  - `WiederholungsUebung` (Sätze × Wiederholungen)
  - `DauerUebung` (Sätze × Dauer in Minuten)

### Projektstruktur

- `src/App.java` – Einstiegspunkt (`main`) mit Testszenarien
- `src/fitnessstudio/Fitnessstudio.java` – zentrale Verwaltung von Geräten, Mitgliedern und Plänen
- `src/fitnessstudio/Mitglied.java` – Repräsentation eines Mitglieds inkl. Regeln für aktive Pläne
- `src/fitnessstudio/Fitnessplan.java` – Fitnessplan mit Liste von Übungen und Geräte-Validierung
- `src/fitnessstudio/Uebung.java` – abstrakte Basisklasse für Übungen
- `src/fitnessstudio/WiederholungsUebung.java` – Übung mit Wiederholungen
- `src/fitnessstudio/DauerUebung.java` – Übung mit Trainingsdauer in Minuten
- `src/fitnessstudio/Geraet.java` – Fitnessgerät mit ID, Name und Kategorie
- `src/fitnessstudio/GeraeteKategorie.java` – Enum für Gerätekategorien

### Voraussetzungen

- Java Development Kit (**JDK 21** oder höher)
- Beliebige Java-IDE (z. B. IntelliJ IDEA, VS Code, Eclipse) **oder** die Kommandozeile

### Build & Ausführung (Kommandozeile)

Im Projektverzeichnis:

```bash
# (Optional) Ausgabeordner anlegen
mkdir -p out

# Kompilieren
javac -d out -cp src src/App.java

# Starten
java -cp out App
```

### JavaDoc erzeugen

Die JavaDoc für das gesamte Projekt kann (bzw. wurde bereits) in den Ordner `docs/javadoc` generiert:

```bash
javadoc -d docs/javadoc -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 \
  -author -version \
  src/App.java \
  src/fitnessstudio/*.java
```

Die Startseite der Dokumentation ist:

- `docs/javadoc/index.html`

### Lizenz

Dies ist ein Beispiel- bzw. Übungsprojekt und steht, sofern nicht anders angegeben, zur freien Verwendung im Rahmen von Ausbildung und Lehre zur Verfügung.

