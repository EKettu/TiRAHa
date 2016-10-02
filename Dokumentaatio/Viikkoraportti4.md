*Viikko 4

27.9.16
-2h keon koodausta, kävin myös keskustelemassa hieman ohjaajan kanssa. En saanut kekoa (Heap-luokka) vielä toimimaan halutulla tavalla.

29.9.16
-1h tiedon etsimistä eri tietorakenteista, lisäksi hieman Heap-luokan toiminnan selvittelyä ilman suurempaa menestystä. NullPointerExceptionin syy ei löytynyt.

1.9.16
-4h ohjelman parissa työskentelyä. Järjestelin luokat omiin pakkauksiinsa, mikä selkeytti rakennetta. Tein myös hieman suorituskykytestausta Javan omien tietorakenteiden kanssa, sekä lisäsin uusia JUnit-testejä mm. Heap-luokalle. JUnit-testien laatiminen auttoi saamaan keon virheellisestä toiminnasta kiinni ja nyt Heap näyttäisi toimivan kuten pitääkin.  

2.9.16
-3h ohjelman parissa työskentelyä. Loin MyArrayList-luokan (aion tehdä siitä vielä geneerisemmän) ja sille pari testiä, sekä sisällytin sen A*-algoritmiin. Ohjelma ei ole varautunut vielä minkään sortin virhetilanteisiin lukuun ottamatta verkkomatriisin ulkopuolella olevia liian isoja aloitus- ja loppusolmun koordinaattiarvoja. Tajusin myös, että A* käyttäytyy vähän turhan hassusti, sillä tulosteesta näkee, että se käy läpi aivan liian monta solmua (visited-set). Polun pituus on kyllä oikein, mutta muuten jotain häikkää on, en onnistunut selvittämään syytä. Ongelma on sama sekä omalla kekorakenteella että Javan PriorityQueue:lla. 

Aloitin IDA*:rin väkerrystä, mutta toistaiseksi algoritmini käy iloisesti läpi koko verkon, eli ei toimi ollenkaan halutulla tavalla. DFS-haussa on ilmeisesti jotain pahasti pielessä, mutta en ehdi tänään enää selvitellä asiaa enempää. En kirjoittanut IDAstarille vielä testejä. 

Seuraavaksi aion muokata molempia algoritmeja niin, että HashSet visited korvataan visited[][]-taulukolla, sekä Javan HashMap pitää korvata omalla tietorakenteella. Ja luonnollisesti molemmat algoritmit, etenkin IDA* pitää saada toimimaan kunnolla. Nyt molemmilla algoritmeilla on käytössään identtinen metodi vieruslistojen rakennukseen, mikä ei ole varmaankaan optimaalista. Testejä pitää myös kirjoittaa lisää, lisäksi pitää alkaa kokeilla algoritmien toimintaa verkoilla, joissa on esteitä. Start-luokkaa pitää muokata hieman järkevämmäksi. Ja tulostukseen pitää saada polku näkymään. 