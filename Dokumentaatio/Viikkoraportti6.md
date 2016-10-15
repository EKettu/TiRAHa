*Viikko 6

11.10.16
-1,5h ohjelman parissa työskentelyä, kävin kysymässä ohjaajalta testauksesta ja yritin ratkoa IDA*:in ongelmia. Tein algoritmin aika tavalla uusiksi, mutta ei toimi edelleenkään, algoritmi jää pyörimään tiettyihin solmuihin, eikä pääse niistä enää eteenpäin.

12.10.16
-1,65h IDA*:in säätöä, homma ei edelleenkään toimi, heuristiikka pielessä tms?

13.10.16
-2h ohjelman parissa työskentelyä. IDA* ei tosiaan toimi, mutta korjasin Path-luokassa olleen bugin polun muodostuksessa ottamalla käyttöön (hyvin karsitun) version HashSetistä. Kirjoitin hieman joitain JUnit-testejä sekä loin uusia karttoja, joiden avulla A*:ia voi testata. IDA*:in toteutuksessa on jotain pahasti pielessä… Joidenkin luokkien kohdalla vanhojen testien korvaaminen uusilla on vielä kesken, ja itse algoritmeilla ei ole ollenkaan JUnit-testejä. 

15.10.16
-4h ohjelman parissa työskentelyä. Verkot sisältävien tekstitiedostojen kanssa oli ongelmia, ja huomasin, että A* toimii aivan liian hitaasti jo 200x200 solmua sisältävien verkkojen kohdalla, 500x500 homma on jo aivan mahdotonta. En osaa sanoa mistä tämä johtuu. IDA* ei ole juurikaan edennyt, se on tuhottoman hidas ja käy läpi liian monta solmua. En myöskään tiedä miten oikean polun saisi IDA*:rin kohdalla talletettua järkevästi niin, että Path voisi käsitellä sen. 



