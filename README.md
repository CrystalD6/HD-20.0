# Hardend Diamond Set Mod — Fabric 1.21.1

## Wat doet de mod?
- Je krijgt automatisch een **Grimoire of Powers** in je inventory als je de wereld inkomt
- Rechtsklik op het item om het menu te openen
- Zoek op naam, item (bijv. "Angel Sword"), type (passive/active/ultimate) of trefwoord
- Navigeer met ↑↓ of klik op een power om de keybind en uitleg te zien
- 62 powers in totaal voor alle wapens en armor

---

## Hoe maak je de .jar via GitHub (gratis, geen installatie nodig)

### Stap 1 — GitHub account aanmaken
Ga naar https://github.com en maak een gratis account als je die nog niet hebt.

### Stap 2 — Nieuwe repository aanmaken
1. Klik rechtsboven op het **+** icoontje → "New repository"
2. Geef het een naam, bijv. `hardend-diamond-mod`
3. Zet hem op **Public** (zodat GitHub Actions gratis werkt)
4. Klik op "Create repository"

### Stap 3 — Bestanden uploaden
1. Klik op "uploading an existing file" (of de "Add file" knop)
2. Sleep de hele map `hardend-diamond-set` hierin (of zip uitpakken en alle bestanden uploaden)
3. **Let op:** zorg dat de mapstructuur klopt:
   ```
   build.gradle
   settings.gradle
   gradlew
   gradle/wrapper/gradle-wrapper.properties
   .github/workflows/build.yml
   src/main/java/...
   src/main/resources/...
   ```
4. Klik op "Commit changes"

### Stap 4 — GitHub bouwt automatisch de JAR
1. Ga naar het tabblad **"Actions"** in je repository
2. Je ziet een workflow draaien genaamd "Build Mod JAR"
3. Wacht ~2-3 minuten tot het groene vinkje verschijnt
4. Klik op de workflow → scroll naar beneden → klik op **"hardend-diamond-set"** onder Artifacts
5. Download de ZIP → daarin zit je `hardend-diamond-set-1.0.0.jar`

### Stap 5 — Mod installeren
1. Zorg dat **Fabric Loader** geïnstalleerd is voor Minecraft 1.21.1
   → Download via https://fabricmc.net/use/installer/
2. Zorg dat **Fabric API** in je mods-map zit
   → Download via https://modrinth.com/mod/fabric-api (kies versie voor 1.21.1)
3. Zet `hardend-diamond-set-1.0.0.jar` in je `.minecraft/mods/` map
4. Start Minecraft met het Fabric-profiel → klaar!

---

## Grimoire gebruiken
- De Grimoire verschijnt automatisch in je hotbar bij het inloggen
- **Rechtsklik** om het zoekscherm te openen
- Typ een naam of woord om te filteren
- Klik op een power of gebruik ↑↓ pijltjes om te navigeren
- Rechts zie je de volledige uitleg en keybind

## Icoontjes
| Icoon | Betekenis |
|-------|-----------|
| ◈     | Passive – altijd actief |
| ⚡    | Active – eigen keybind |
| ★     | Ultimate – krachtige combo |
