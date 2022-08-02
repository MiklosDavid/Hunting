***2. Beadandó***  

***Programozási Technológia I.***  

**3.Feldat**  

Feladat leírása:  

Készítsünk programot, amellyel a következő két személyes játékot lehet játszani. Adott egy n × n mezőből álló tábla, ahol egy menekülő és egy támadó játékos helyezkedik el.   

Kezdetben a menekülő játékos figurája középen van, míg a támadó figurái a négy sarokban helyezkednek el. A játékosok felváltva lépnek. A figurák vízszintesen, illetve függőlegesen mozoghatnak 1-1 mezőt, de egymásra nem léphetnek.   

A támadó játékos célja, hogy adott lépésszámon (4n) belül bekerítse a menekülő figurát, azaz a menekülő ne tudjon lépni.   

A program biztosítson lehetőséget új játék kezdésére a táblaméret (3×3, 5×5, 7×7) és így a lépésszám (12, 20, 28) megadásával, folyamatosan jelenítse meg a lépések számát, és ismerje fel, ha vége a játéknak. Ekkor jelenítse meg, melyik játékos győzött, majd kezdjen automatikusan új játékot.  

*UML osztálydiagram:* 

![image1](https://user-images.githubusercontent.com/48122593/182323767-8e01f12b-c1f0-4324-b646-ee60f2f1ebe7.png)

*Osztályok leírása:*

**Game:**  

Elindít egy új játékot úgy, hogy példányosítja a GameGUI osztályt.  

**GameGUI:**  

Gondoskodik az alkalmazás grafikai megjelenítéséről, új játék esetén a táblaméret beállításáról, illetve létrehozza a menüt.  

**Board:**  

Tartalmazza a játéktábla adatait, logikáját. Létrehozza a táblán a játékmezőket  

**BoardGUI:**  

A játéktábla grafikus interfészét valósítja meg, a játék állapotának játékmezőkre vonatkozórészét jeleníti meg. A játékmezőkhöz kattintható gombokat rendel.  

**Field:**  

A játékmezőt megvalósító osztály.

**ButtonListener:**  

Az osztály célja annak álltalános leirása, hogy mi történjen, ha egy játémezőre kattintunk. 
