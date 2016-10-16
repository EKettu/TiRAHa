*Ohjelman yleisrakenne

Ohjelma koostuu algoritmeista (luokat Astar, IDAstar), joiden avulla pyritään ratkaisemaan lyhyin reitti verkossa, jonka muodostaa Netbuilder FileReader-luokan lukemasta tekstitiedostosta. Verkko rakentuu Node-olioista, jotka ovat solmuja verkossa, niillä on mm. tieto etäisyydestään loppusolmuun, sekä yksilöivä "sarjanumero". Algoritmien ja verkon rakentamisessa käytetään hyväksi omia versioita keosta (Heap) ja pinosta (MyStack), sekä Javan valmiit vastaavat tietorakenteet korvaavia luokkia MyArrayList, MyHashMap ja MyHashSet. 

Käyttöliittymän (vielä tekemättä) ideana on, että ohjelma kysyy käyttäjältä tiedoston, jonka pohjalta verkko rakennetaan, sekä algoritmin, jolla käyttäjä haluaa ratkaista lyhyimmän polun verkossa. Ohjelma piirtää aluksi alkuperäisen verkon, jossa näkyvät tavalliset ei-painotetu solmut '.', painotetut solmut 'o' sekä seinät '#'. Seuraavaksi se ratkaisee halutulla algoritmilla verkon, piirtää verkon uudelleen niin, että lyhyin reitti on näkyvissä (Path-luokka) sekä kertoo kauanko aikaa polun laskemiseen kului. Solmut, joissa algoritmi on vieraillut, näkyvät uudessa kartassa merkeillä 'x' ja itse lyhyin reitti on merkitty merkeillä '@'.

*Aika- ja tilavaativuudet
A*: aikavaativuus O((|E|  + |V|)log |V|), tilavaativuus O(|V|).
IDA*: aikavaativuus O(|E|+|V|), pahimmassa tapauksessa voi käydä kaikki solmut läpi kahteen kertaan jolloin tilavaativuus on O(|V|^2)

*Työn mahdolliset puutteet ym (Tilanne 15.10.16)
Tällä hetkellä tosiaan on vaikea sanoa suorituskyvystä mitään, koska vaikka A* näyttää toimivan (se ei jää ikuiseen silmukkaan tms), niin se on todella hidas jo 200x200 verkoilla (ks. Testausdokumentti). IDA* taas ei toimi kunnolla. 

*Lähteet
https://cse.sc.edu/~mgv/csce580f09/gradPres/SmithFlowers091012.ppt
https://en.wikipedia.org/wiki/Iterative_deepening_A*
https://algorithmsinsight.wordpress.com/graph-theory-2/ida-star-algorithm-in-general/
Tietorakenteet ja algoritmit kevät 2016 kurssimoniste


