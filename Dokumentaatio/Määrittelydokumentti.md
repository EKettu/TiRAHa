Määrittelydokumentti

* Ajattelin alustavasti toteuttaa A*- ja IDA*-algoritmit ja vertailla niiden suorituskykyä erilaisilla verkoilla. Mahdollisesti aikataulun salliessa otan mukaan jonkin kolmannen algoritmin. Tietorakenteista tarvitaan ainakin taulukoiden lisäksi keko ja pino, jotka pitää toteuttaa. 

* Algoritmien tarkoitus on ratkaista lyhimmän polun ongelma, eli löytää lyhin reitti verkon kahden eri solmun välillä. Valitsin A*:n, koska se mainittiin lyhyesti Tietorakenteet ja algoritmit -kurssin loppupuolella, ja tuntuu luontevalta jatkaa aiheeseen syventymistä. Lisäksi A* vaikuttaa varsin monikäyttöiseltä, joten siihen perehtyminen voi olla hyödyllistä.

* Ohjelma saa syötteinään verkkoja, en ole vielä varma missä muodossa, luultavasti matriiseina. Pyrin saamaan ohjelman toimimaan niin, että erikokoisten verkkojen syöttäminen ja käsittely on helppoa. 

* A*-algoritmin pahimman tapauksen aikavaativuus on O((kaari lkm  + solmu lkm)log solmu lkm), eli sama kuin Dijkstran algoritmilla, mutta yleensä A* toimii nopeammin. Tilavaativuus on yleensä sama kuin leveyssuuntaisella läpikäynnillä, eli O(solmu lkm). IDA* on variaatio syvyyssuuntaisesta läpikäynnistä, joten se tarvitsee A*:ia vähemmän muistitilaa, mutta se käy usein samoja solmuja läpi useamman kerran. 

* Lähteet:
http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html
https://en.wikipedia.org/wiki/A*_search_algorithm
https://en.wikipedia.org/wiki/Iterative_deepening_A*   



