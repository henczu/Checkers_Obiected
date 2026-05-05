# Checkers_Obiected

Gra w warcaby (checkers) napisana w języku **Java** z wykorzystaniem biblioteki **Swing**. Projekt został zrealizowany w paradygmacie obiektowym i prezentuje praktyczne zastosowanie dziedziczenia, polimorfizmu oraz klas abstrakcyjnych.

## Spis treści

- [Opis projektu](#opis-projektu)
- [Funkcjonalności](#funkcjonalności)
- [Struktura projektu](#struktura-projektu)
- [Architektura klas](#architektura-klas)
- [Wymagania](#wymagania)
- [Uruchomienie](#uruchomienie)
- [Zasady gry](#zasady-gry)
- [Sterowanie](#sterowanie)

## Opis projektu

Aplikacja umożliwia rozgrywkę w klasyczne warcaby dla dwóch graczy (hot-seat) na planszy 8x8. Interfejs graficzny zbudowany jest na bazie `JFrame`, `JPanel` oraz siatki `JButton`, gdzie każde pole planszy reprezentowane jest przez osobny przycisk reagujący na kliknięcia myszki.

Gracze (biały i czarny) wykonują ruchy na przemian — białe pionki rozpoczynają grę. Logika gry obsługuje zwykłe pionki (Man), promocję na damkę (King) oraz mechanikę bicia, w tym bicia wielokrotne.

## Funkcjonalności

- Plansza 8x8 wygenerowana dynamicznie z `JButton`
- Dwa rodzaje figur: zwykły pionek (`Man`) i damka (`King`)
- Naprzemienne tury graczy (białe / czarne)
- Standardowe ruchy po przekątnej
- Bicie pionka przeciwnika (skok przez figurę) z aktualizacją punktów
- Bicia wielokrotne (kontynuacja tury, jeśli kolejne bicie jest możliwe)
- Damka — ruch i bicie na dowolną odległość po przekątnej (`longBeat`)
- Automatyczna promocja pionka na damkę po dotarciu do ostatniego rzędu
- Wyróżnienie wybranej figury kolorem
- Pasek tytułowy z aktualnym wynikiem (białe / czarne punkty)
- Wykrywanie zwycięstwa, gdy jeden z graczy nie ma już figur na planszy

## Struktura projektu

```
Checkers_Obiected/
├── Checkers_Obiected.iml
├── .gitignore
└── src/
    ├── Main.java                  # Punkt startowy aplikacji
    ├── Checkers.java              # Kontroler gry, obsługa myszki, logika tur
    ├── Board.java                 # Plansza, GUI, inicjalizacja figur
    ├── Field.java                 # Pojedyncze pole planszy (przycisk + figura)
    ├── Figures.java               # Klasa abstrakcyjna — wspólna logika figur
    ├── Man.java                   # Zwykły pionek
    ├── King.java                  # Damka (królowa)
    ├── white_figure.png           # Grafika białego pionka
    ├── black_figure.png           # Grafika czarnego pionka
    ├── white_figure_queen.png     # Grafika białej damki
    └── black_figure_queen.png     # Grafika czarnej damki
```

## Architektura klas

- **`Main`** — uruchamia aplikację, tworząc instancję `Checkers`.
- **`Checkers`** — implementuje `MouseListener`, zarządza stanem gry (czyja tura, pole źródłowe, pole zbicia), obsługuje kliknięcia i sprawdza warunek zwycięstwa.
- **`Board`** — tworzy `JFrame`, panel tytułowy z wynikiem oraz panel z planszą 8x8. Ładuje grafiki figur i rozstawia pionki w pozycji startowej.
- **`Field`** — reprezentuje pojedyncze pole planszy. Zawiera referencję do `JButton` oraz do figury (`Figures`) stojącej na polu.
- **`Figures`** *(abstract)* — definiuje wspólną logikę: pierwszy krok ruchu (`firstStepOfMove`), wykonanie ruchu (`move`), bicie (`beat`), wykrywanie możliwości kolejnego bicia (`possibleBeat`) oraz aktualizację punktacji.
- **`Man`** — zwykły pionek; porusza się o jedno pole po przekątnej do przodu, bije w dowolną stronę. Promocja na damkę po dotarciu do ostatniego rzędu (`makingKing`).
- **`King`** — damka; porusza się i bije na dowolną odległość po przekątnej (`longBeat`), pod warunkiem że pola pomiędzy są wolne.

## Wymagania

- **JDK 8+** (projekt korzysta wyłącznie ze standardowej biblioteki Java + Swing — bez zewnętrznych zależności)
- IDE typu IntelliJ IDEA lub Eclipse (opcjonalnie — projekt zawiera plik `.iml` dla IntelliJ)

## Uruchomienie

### IntelliJ IDEA

1. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/henczu/Checkers_Obiected.git
   ```
2. Otwórz projekt w IntelliJ IDEA (`File → Open` → wybierz katalog projektu).
3. Uruchom klasę `Main` (prawy klik na `src/Main.java` → `Run 'Main.main()'`).

### Z linii komend

```bash
cd Checkers_Obiected/src
javac *.java
java Main
```

> Uwaga: pliki graficzne (`.png`) muszą znajdować się w tej samej lokalizacji co skompilowane klasy, ponieważ ładowane są przez `getClass().getResource(...)`.

## Zasady gry

1. Białe rozpoczynają grę.
2. Pionki (`Man`) poruszają się o jedno pole po przekątnej:
   - białe — w stronę rosnących wierszy,
   - czarne — w stronę malejących wierszy.
3. Bicie polega na przeskoczeniu pionka przeciwnika na puste pole bezpośrednio za nim. Bicie pionkiem (`Man`) jest możliwe w każdym z czterech kierunków po przekątnej.
4. Po wykonaniu bicia, jeśli kolejne bicie z nowego pola jest możliwe, ten sam gracz kontynuuje turę.
5. Pionek dotarły do ostatniego rzędu (czarne — wiersz `0`, białe — wiersz `7`) zostaje awansowany na damkę.
6. Damka (`King`) porusza się i bije na dowolną odległość po przekątnej, pod warunkiem że pola pomiędzy są puste.
7. Gra kończy się, gdy jeden z graczy traci wszystkie figury — wyświetlany jest komunikat o zwycięstwie.

## Sterowanie

- **Pierwsze kliknięcie** — wybór własnej figury (pole zostanie podświetlone).
- **Drugie kliknięcie** — wskazanie pola docelowego (ruch lub bicie).
- **Kliknięcie tej samej figury ponownie** — anulowanie wyboru.

---

Projekt edukacyjny demonstrujący zastosowanie programowania obiektowego (dziedziczenie, klasy abstrakcyjne, polimorfizm) oraz biblioteki Swing do budowy prostych aplikacji okienkowych z grafiką.
