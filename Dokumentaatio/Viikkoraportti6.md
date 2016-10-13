*Viikko 6

11.10.16
-1,5h ohjelman parissa työskentelyä, kävin kysymässä ohjaajalta testauksesta ja yritin ratkoa IDA*:in ongelmia. Tein algoritmin aika tavalla uusiksi, mutta ei toimi edelleenkään, algoritmi jää pyörimään tiettyihin solmuihin, eikä pääse niistä enää eteenpäin.

12.10.16
-1,65h IDA*:in säätöä, homma ei edelleenkään toimi, heuristiikka pielessä tms?

13.10.16
-2h ohjelman parissa työskentelyä. IDA* ei tosiaan toimi, mutta korjasin Path-luokassa olleen bugin polun muodostuksessa ottamalla käyttöön (hyvin karsitun) version HashSetistä. Kirjoitin hieman joitain JUnit-testejä sekä loin uusia karttoja, joiden avulla A*:ia voi testata. IDA*:in toteutuksessa on jotain pahasti pielessä… Joidenkin luokkien kohdalla vanhojen testien korvaaminen uusilla on vielä kesken, ja itse algoritmeilla ei ole ollenkaan JUnit-testejä. 

