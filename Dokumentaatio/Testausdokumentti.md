*Suorituskykytestausta 1.9.16 A*-algoritmi

Testi1
astar.astar(100, 0, 0, 99, 99);
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


*Suorituskykytestausta 16.10.16 A*-algoritmi

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



