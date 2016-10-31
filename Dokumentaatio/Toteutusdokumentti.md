*Ohjelman yleisrakenne

Ohjelma koostuu algoritmeista (luokat Astar, Dijkstra, IDAstar), joiden avulla pyritään ratkaisemaan lyhyin reitti verkossa, jonka muodostaa Netbuilder FileReader-luokan lukemasta tekstitiedostosta. Verkko rakentuu Node-olioista, jotka ovat solmuja verkossa, niillä on mm. tieto etäisyydestään loppusolmuun, sekä yksilöivä "sarjanumero". Algoritmien ja verkon rakentamisessa käytetään hyväksi omia versioita keosta (Heap) ja pinosta (MyStack), sekä Javan valmiit vastaavat tietorakenteet korvaavia luokkia MyArrayList, MyHashMap ja MyHashSet. 

Käyttöliittymän ideana on, että ohjelma kysyy käyttäjältä tiedoston, jonka pohjalta verkko rakennetaan, sekä algoritmin, jolla käyttäjä haluaa ratkaista lyhyimmän polun verkossa. Ohjelma piirtää aluksi alkuperäisen verkon, jossa näkyvät tavalliset ei-painotetu solmut '.', painotetut solmut 'o' sekä seinät '#'. Seuraavaksi se ratkaisee halutulla algoritmilla verkon, piirtää verkon uudelleen niin, että lyhyin reitti on näkyvissä (Path-luokka) sekä kertoo kauanko aikaa polun laskemiseen kului. Solmut, joissa algoritmi on vieraillut, näkyvät uudessa kartassa merkeillä 'x' ja itse lyhyin reitti on merkitty merkeillä '@'.


*Aika- ja tilavaativuudet

A*: aikavaativuus pahimmassa tapauksessa O((|E|  + |V|)log |V|), mutta yleensä nopeampi, tilavaativuus O(|V|).
Dijkstra: aikavaativuus O((|E|  + |V|)log |V|), tilavaativuus O(|V|).
IDA*: pahimmassa tapauksessa voi käydä kaikki solmut läpi useampaan kertaan jolloin aikavaativuus on O(|V|^2) (yleensä ei kuitenkaan näin hidas). Tässä harjoitustyössä toteuttamani IDA*:in tilavaativuus on O(|V|), koska haluan algoritmini muistavan ne solmut, joissa se on vieraillut, jotta voin lopuksi piirtää kuvan algoritmin liikkeistä verkossa. Normaalisti IDA*:in ei tarvitsisi tallettaa muistiin kaikkia vierailtuja solmuja.


*Suorituskykyvertailua

Kuten Testausdokumentista ilmenee, A* toimii nopeimmin isoissa verkoissa, joissa on tavallisten solmujen lisäksi painavampia solmuja sekä läpipääsemättömiä seiniä. Dijkstran algoritmi on pienemmillä (100x100 ja sitä pienemmät) verkoilla yhtä nopea kuin A*, välillä jopa hieman nopeampi, mutta sen toiminta on hyvin hidasta jo 500x500 verkoilla. IDA* taas on nopein verkoilla, joissa ei ole painavia solmuja tai seiniä, mutta jos niitä löytyy, on algoritmi (jopa toivottoman) hidas jo joillain 100x100 verkoilla.


*Työn mahdolliset puutteet ym 

Algoritmini ovat varsin hitaita verrattuna esim. TiRA-kurssilla käytettyihin verkkoalgoritmeihin, mutta tähän vaikuttavat käytössä olevat omat tietorakenteet. Testauksessa en tehnyt kovin monia toistoja per kartta, osittain sen takia, että joidenkin testien suorittamiseen kului niin kauan aikaa. Kuitenkin tehdyistä testeistä voi tehdä havaintoja nopeuksistakin, mutta olisin voinut myös tehdä enemmän vertailevia nopeustestejä. 

Havaitsin A*:issa bugin 30.10.16 (ks. Testausdokumentti), joka liittyy keon toimintaan. Sain korjattua bugin A*:in kohdalla, mutta se siirtyi tietyllä kartalla Dijkstraan. Bugi liittyy jotenkin minimikekoni heapify()-metodiin, mutta valitettavasti en ehtinyt selvittää sen syytä tarkkaan. 

IDA* ei tällä hetkellä toimi kunnolla mikäli polkua ei löydy, koska ehdon (temp == Integer.MAX_VALUE) täyttymisessä menee aivan liian kauan. Näin ollen en testannut tätä ominaisuutta JUnit-testeissä. Muutenkin JUnit-testejä olisi varmasti voinut olla enemmänkin.

Omat tietorakenteeni ovat varsin suppeita ja esim. Heap toimii vain Node-olioilla. 

Käyttöliittymä on kaikkiaan varsin kömpelö, eikä reagoi kunnolla virhesyötteisiin (esim. jos käyttäjä vahingossa kirjoittaa tiedoston nimen väärin, ei tästä kerrota ennen kuin verkkoa on jo yritetty rakentaa).

*Lähteet
https://cse.sc.edu/~mgv/csce580f09/gradPres/SmithFlowers091012.ppt
https://en.wikipedia.org/wiki/Iterative_deepening_A*
https://algorithmsinsight.wordpress.com/graph-theory-2/ida-star-algorithm-in-general/
Tietorakenteet ja algoritmit kevät 2016 kurssimoniste
http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html
http://www.redblobgames.com/pathfinding/a-star/introduction.html


