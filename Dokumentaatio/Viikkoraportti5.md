*Viikko 5

3.10.16
-1h polun tulostuksen selvittelyä, hieman lisätestejä MyStackille. 

4.10.16
-3h ohjelman parissa työskentelyä. Kävin pikaisesti ihmettelemässä ohjaajalle A*:rin outoa toimintaa (käy läpi "liikaa" solmuja), mutta ilmeni, että tämä johtuu vain siitä, missä järjestyksessä solmut lisätään vieruslistaan. Algoritmi toimii ok. IDA*:rin ongelmaa en saanut ratkaistua. Tein luokan tiedoston käsittelyyn ja tein MyArrayListista geneerisemmän (tosin toteutuksessa on hieman häikkää, ei varmaan paras tapa). 

Verkon kokoaminen tiedostosta näyttää onnistuvan läpipääsemättömien seinien kohdalla (#), mutta painoltaan suuremmat, mutta muuten läpikuljettavat solmut (o) aiheuttavat ongelmia- Heap ei jotenkin pysty käsittelemään niitä niin, että algoritmi voisi jatkaa kulkuaan näiden painavien solmujen läpi, jossei muuta reittiä ole. En keksinyt järkevää tapaa solmujen endDist-arvon asettamiseksi ennen kuin koko verkko on käyty läpi ja loppusolmu löydetty, joten verkko käydään nyt kaksi kertaa läpi, mikä ei ole tietenkään optimaalista. 

Testejä puuttuu useammalta luokalta, tuli niin paljon muutoksia. 

5.10.16
-0,5h A*:rin toiminnan ihmettelyä. Eilen raportoimani ongelma läpikuljettavien painavien solmujen kanssa johtui NetBuilderissa verkon luonnissa olleesta yhden numeron bugista, korjasin asian ja A* näyttää nyt toimivan ongelmitta. Pitää siivota koodia vielä huomattavasti, nyt Main-luokkaan kuuluvia operaatioita on turhaan Astar-luokassa. Ja tietenkin IDA* pitää korjata sekä korvata HashMap omalla rakenteella.

8.10.16
-2h koodin siivousta ym. A* toimii nyt myös tilanteissa, joissa polkua ei löydy. IDA* ei toimi oikein, algoritmi käy läpi aivan liikaa solmuja (kaikki), lisäksi algoritmi ei toimi oikein A*:rin kanssa samaan aikaan käytettynä. HashMap on vielä korvaamatta, mutta muuten Javan tietorakenteet on korvattu omilla. Testejä pitää kirjoittaa lisää. 

9.10.16
-1,5h MyHashMapin koodailua, sekä sen sisällyttämistä muuhun koodiin. Näyttää toimivan. IDA*:rin ongelmiin en ehtinyt paneutua.  