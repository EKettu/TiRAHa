***Suorituskykytestausta 1.9.16***
A*-algoritmi

Testi1
astar.astar(100, 0, 0, 99, 99); 
Eli verkossa 100 solmua, alkusolmun koordinaatit (0,0) ja maalisolmun koordinaatit (99,99)
Javan omat tietorakenteet, ei mitään omia, ei painoja verkon solmuissa, ei esteitä
Polun pituus on 198
showPath()-tulostus mukana
solmuluettelon tulostus mukana
Suorituskerta 1. Aikaa kului 266 ms
Suorituskerta 2. Aikaa kului 315 ms
Suorituskerta 3. Aikaa kului 235 ms


Testi2
astar.astar(100, 0, 0, 99, 99);
Javan omat tietorakenteet, ei mitään omia, ei painoja verkon solmuissa, ei esteitä
Polun pituus on 198
showPath()-tulostus ei mukana
solmuluettelon tulostus mukana
Suorituskerta 1. Aikaa kului 77 ms
Suorituskerta 2. Aikaa kului 104 ms
Suorituskerta 3. Aikaa kului 61 ms


Testi3
astar.astar(1000, 0, 0, 999, 999);
Eli verkossa 1000 solmua, alkusolmun koordinaatit (0,0) ja maalisolmun koordinaatit (999,999)
Javan omat tietorakenteet, ei mitään omia, ei painoja verkon solmuissa, ei esteitä
Polun pituus on 1998
showPath()-tulostus mukana
solmuluettelon tulostus mukana
Suorituskerta 1. Aikaa kului 16378 ms
Suorituskerta 2. Aikaa kului 13168 ms
Suorituskerta 3. Aikaa kului 15479 ms


Testi4
astar.astar(1000, 0, 0, 999, 999);
Javan omat tietorakenteet, ei mitään omia, ei painoja verkon solmuissa, ei esteitä
Polun pituus on 1998
showPath()-tulostus ei mukana
solmuluettelon tulostus mukana
Suorituskerta 1. Aikaa kului 6753 ms
Suorituskerta 2. Aikaa kului 6064 ms
Suorituskerta 3. Aikaa kului 6885 ms
Suorituskerta 4. Aikaa kului 7132 ms


Testi5
astar.astar(1000, 0, 0, 999, 999);
Javan omat tietorakenteet, ei mitään omia, ei painoja verkon solmuissa, ei esteitä
Polun pituus on 1998
showPath()-tulostus ei mukana
solmuluettelon tulostus ei mukana
Suorituskerta 1. Aikaa kului 7525 ms
Suorituskerta 2. Aikaa kului 6934 ms
Suorituskerta 3. Aikaa kului 7177 ms



***Suorituskykytestausta 16.10.16***

A*-algoritmi

Tein kasan erilaisia tekstitiedostoja, joissa on erilaisia verkkoja. Osassa näistä verkoista on pelkkiä yhden painoisia solmuja, mutta joissain verkoissa on mukana noin 20% seiniä ja painavampia solmuja. Testit ovat helposti toistettavissa samalle verkkotiedostolle. 

Testi 1. 
verkkotiedosto: map500_1.txt (500x500, verkossa seiniä ja painavampia solmuja)
Suorituskerta 1. Aikaa kului 1175813 ms (=19,6 min)!
Eli A* on liian hidas. Tässä testissä noin puolet ajasta näytti kuluvan vieruslistan tekoon. 

Kokeilin vielä ajaa A*:ia tiedostolla map1000_1.txt (1000x1000 verkko), mutta pelkästään vieruslistan tekoon näytti silloin kuluvan yli 2h...

Toisin kuin edellä mainituissa testeissä, seuraavissa vieruslistan teko tapahtui ennen algoritmin ajamista, mikä nopeuttaa testejä.  

Testi 2.
verkkotiedosto: map100_1.txt (100x100, verkossa seiniä ja painavampia solmuja)
Suorituskerta 1. Aikaa kului 404 ms
Suorituskerta 2. Aikaa kului 342 ms
Suorituskerta 3. Aikaa kului 309 ms

Testi 3.
verkkotiedosto: map200_1.txt (200x200, verkossa ei seiniä tai painavampia solmuja)
Suorituskerta 1. Aikaa kului 5485 ms
Suorituskerta 2. Aikaa kului 5452 ms
Suorituskerta 3. Aikaa kului 5322 ms



***Suorituskykytestausta 27.10.16***
A* ja Dijkstra 
(Nyt vieruslistojen tekotapaa muutettu, nyt se huomattavasti nopeampaa kuin edellisellä kerralla, joten testaukset hieman suuremmillakin syötteillä onnistuvat ainakin A*:in kohdalla.) 

Testi 1.
verkkotiedosto: map500_1.txt (500x500, verkossa seiniä ja painavampia solmuja)
(lyhimmän polun pituus 660)

A* 
Suorituskerta 1. Aikaa kului 3414 ms
Suorituskerta 2. Aikaa kului 3073 ms
Suorituskerta 3. Aikaa kului 3108 ms

Dijkstra
Suorituskerta 1. Aikaa kului 93054 ms
Suorituskerta 2. Aikaa kului 84391 ms
Suorituskerta 3. Aikaa kului 84641 ms

IDA* ei toimi järkevässä ajassa näin isolla seiniä ja painavia solmuja sisältävällä verkolla.


Testi 2. 
verkkotiedosto: map100_1.txt (100x100, verkossa seiniä ja painavampia solmuja)
(lyhimmän polun pituus 140)

A*
Suorituskerta 1. Aikaa kului 307 ms
Suorituskerta 2. Aikaa kului 106 ms
Suorituskerta 3. Aikaa kului 148 ms

Dijkstra
Suorituskerta 1. Aikaa kului 236 ms
Suorituskerta 2. Aikaa kului 133 ms
Suorituskerta 3. Aikaa kului 120 ms

IDA*
Suorituskerta 1. Aikaa kului 64 ms
Suorituskerta 2. Aikaa kului 69 ms
Suorituskerta 3. Aikaa kului 58 ms


Testi 3.
verkkotiedosto: map100_4.txt (100x100, verkossa seiniä ja painavampia solmuja
(lyhimmän polun pituus 198)

A*
Suorituskerta 1. Aikaa kului 275 ms
Suorituskerta 2. Aikaa kului 245 ms
Suorituskerta 3. Aikaa kului 147 ms

Dijkstra
Suorituskerta 1. Aikaa kului 218 ms
Suorituskerta 2. Aikaa kului 127 ms
Suorituskerta 3. Aikaa kului 111 ms


IDA*
Ei löydä polkua alle 3 minuutissa.

A* ja Dijkstra suorituvat suurin piirtein yhtä nopeasti 100x100 verkosta, mutta IDA* ei selviä kaikista 100x100 verkoista, jos niissä on sekä seiniä että painavampia solmuja. 


***Suorituskykytestausta 29.10.16***

Testi 1.
verkkotiedosto: maze50_1.txt (50x50 labyrintti, jossa ei ole painavampia solmuja)
(lyhimmän polun pituus 116)

A*
Suorituskerta 1. Aikaa kului 83 ms
Suorituskerta 2. Aikaa kului 54 ms
Suorituskerta 3. Aikaa kului 80 ms
Suorituskerta 4. Aikaa kului 100 ms
Suorituskerta 5. Aikaa kului 70 ms


Dijkstra
Suorituskerta 1. Aikaa kului 59 ms
Suorituskerta 2. Aikaa kului 87 ms
Suorituskerta 3. Aikaa kului 56 ms
Suorituskerta 4. Aikaa kului 135 ms
Suorituskerta 5. Aikaa kului 55 ms

IDA*
Suorituskerta 1. Aikaa kului 5311 ms
Suorituskerta 2. Aikaa kului 5494 ms
Suoritukserta 3. Aikaa kului 4315 ms
Suorituskerta 4. Aikaa kului 4503 ms
Suorituskerta 5. Aikaa kului 4316 ms

Eli IDA* on kaikkein hitain, A*:in ja Dijkstran suoritusajassa ei juurikaan eroa näin pienellä syötteellä. 


Testi 2. 
verkkotiedosto map500_2.txt (500x500, ei seiniä tai painavampia solmuja)
(lyhimmän polun pituus on 998)

A*
Suorituskerta 1. Aikaa kului 5538 ms
Suorituskerta 2. Aikaa kului 5880 ms
Suorituskerta 3. Aikaa kului 7255 ms
Suorituskerta 4. Aikaa kului 9123 ms
Suorituskerta 5. Aikaa kului 9895 ms

Dijkstra
Suorituskerta 1. Aikaa kului 278682 ms
Suorituskerta 2. Aikaa kului 284697 ms
Suorituskerta 3. Aikaa kului 291072 ms
Suorituskerta 4. Aikaa kului 283052 ms
Suorituskerta 5. Aikaa kului 285277 ms

IDA*
Suorituskerta 1. Aikaa kului 4055 ms
Suorituskerta 2. Aikaa kului 3820 ms
Suorituskerta 3. Aikaa kului 4076 ms
Suorituskerta 4. Aikaa kului 4094 ms
Suorituskerta 5. Aikaa kului 3288 ms

Testistä näkee, että IDA* on yleensä A*:ia nopeampi suurilla verkoilla, joissa ei ole seiniä tai painoltaan vaihtelevia solmuja. Dijkstra käy läpi koko verkon, hitaasti. 

Testi 3. 
verkkotiedosto: map100_6.txt (100x100, vain tavallisia ja painavampia solmuja, ei seiniä)
(lyhimmän polun pituus 196)

A* 
Suorituskerta 1. Aikaa kului 224 ms
Suorituskerta 2. Aikaa kului 265 ms
Suorituskerta 3. Aikaa kului 209 ms

Dijkstra
Suorituskerta 1. Aikaa kului 146 ms
Suorituskerta 2. Aikaa kului 198 ms
Suorituskerta 3. Aikaa kului 131 ms

IDA*
Suorituskerta 1. Aikaa kului 48616 ms
Suorituskerta 2. Aikaa kului 48108 ms
Suorituskerta 3. Aikaa kului 44119 ms

Testistä käy ilmi, että IDA* on huomattavasti kahta muuta hitaampi verkoilla, joissa on painavampia solmuja.

Testi 4.
verkkotiedosto: map500_1.txt (500x500, verkossa seiniä ja painavampia solmuja)
(lyhimmän polun pituus 660)

A*
Suorituskerta 1. Aikaa kului 2345 ms
Suorituskerta 2. Aikaa kului 2103 ms
Suorituskerta 3. Aikaa kului 2214 ms

Dijkstra
Suorituskerta 1. Aikaa kului 75693 ms
Suorituskerta 2. Aikaa kului 78647 ms
Suorituskerta 3. Aikaa kului 78912 ms

IDA* ei kokeiltu

Kokeilin vielä samaa karttaa toistamiseen (ks. Suorituskykytestausta 27.10.16), koska on kiinnostavaa, miten paljon nopeampi etenkin Dijkstra on 500x500 verkossa, jossa on seiniä ja painavampia solmuja verrattuna tämän päivän testin 2. tuloksiin (map500_2.txt). 


***Suorituskykytestausta 30.10.16***

(Seuraavat testit tehtiin eri tietokoneella kuin aiemmat testit, nyt käytetty tietokone huomattavasti edellistä tehokkaampi.)

Testi 1. 
verkkotiedosto: map1000_1.txt (1000x1000, verkossa seiniä ja painavampia solmuja)
(lyhimmän polun pituus 1294)

A*
Suorituskerta 1. Aikaa kului 20735 ms
Suorituskerta 2. Aikaa kului 20000 ms
Suorituskerta 2. Aikaa kului 21424 ms

Dijkstra ei löytänyt polkua alle 3 minuutissa

IDA* ei kokeiltu


Testi 2.
verkkotiedosto: map1000_2.txt (1000x1000, verkossa vain tavallisia solmuja)
(lyhimmän polun pituus 1698)

A* väittää lyhyimmän polun pituudeksi 1700, vaikka se on oikeasti 1698. Syytä selvitellessäni huomasin, että solmun nro 113110 kohdalla polku siirtyy solmuun 113109 vaikka sen pitäisi mennä solmuun 114110. A* kyllä lisää solmun 113110 vierussolmuja läpikäydessään kekoon molemmat solmut, ja solmun 113109 startDistance on 223 ja endDistance 1477, kun taas solmulla 114110 startDistance on 223 ja endDistance 1475. Eli solmun 114110 prioriteetti keossa on 1698 ja solmun 113109 prioriteetti on 1700, eli keon pitäisi valita näistä kahdesta solmu 114110, mutta jostain syystä se valitsee seuraavaksi käsittelyyn solmun 113109 eikä algoritmi siten varsinaisesti vieraile ikinä solmussa 114110. En onnistunut selvittämään syytä tälle, toistaiseksi olen havainnut testaamistani kartoista tämän ongelman vain tässä kartassa. 

A*
Suorituskerta 1. Aikaa kului 12526 ms
Suorituskerta 2. Aikaa kului 12462 ms
Suorituskerta 3. Aikaa kului 12593 ms


Dijkstra ei löytänyt polkua alle 3 minuutissa

IDA*
Suorituskerta 1. Aikaa kului 1499 ms
Suorituskerta 2. Aikaa kului 1635 ms
Suorituskerta 3. Aikaa kului 1550 ms

Tällä kartalla näkee, miten paljon A*:ia nopeampi IDA* on verkoissa, joissa ei ole seiniä tai painavia solmuja. 


***Huom!*** Lisäys 31.10.16
Yritin vielä selvitellä eilen viime tipassa havaitsemaani ongelmaa, ja tulin tulokseen, että se liittyy jotenkin keon toteutukseen. Onnistuin korjaamaan ongelman A*:in kohdalla muuttamalla Heap-luokan riviä 43 siten, että poistin yhtäsuuruusmerkin, eli  "if (right <= heapsize) {" -rivi muuttui muotoon  "if (right < heapsize) {". Nyt A* toimii oikein kartalla map1000_2.txt ja näyttää toimivan myös niillä kartoilla, joita ehdin testata. Sen sijaan Dijkstran algoritmi näyttää polun liian pitkäksi kartalla map500_1.txt (666 vs 660). Keossani on siis joku ongelma, mutta en valitettavasti ehtinyt enää selvittää tarkkaan mikä se on.

