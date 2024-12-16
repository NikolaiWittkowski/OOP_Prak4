1. Aufgabe (java,5,8,generics)
Ändern sie die anwendung aus dem dritten praktikumstermin 
ab. Die Dienstleistungen eines Bürgeramtes(Hier Cafe) sollen nicht vom 
typ string[] sein, sonder vom typ ArrayList. Tauschen sie das 
entsprechende Attribut in der klasse aus: private ArrayList 
Kaffeprodukte
Nehmen sie alle weitere anpassungen vor, um die bisherige funktionalität
 wieder herzustellen. Die bisherige signatur des konstrukturs der klasse
 soll aber unverändert bleiben. Sie brauchen nur die klasse Cafe 
anzupassen. Eine methode welche aus einem string array
eine arraylist erstellt und dann das attribut belegt ist dafür 
hilfreich.


Es sollen weiterhin mehrere Bürgerämter 
zwischengespeichert werden können. Tauschen sie daher das attribut cafe 
vom Typ Cafe inCafe der Klasse Cafemodel aus gegen ein attribut cafes 
vom typ ArrayList. Dieses kann sofort mit ArrayList<> 
initialisiert werden
Die get methode muss angepast werden.
Die set methode soll ausgetauscht werden geegen eine methode public void
 addCafe(Cafe cafe). Es soll zu den bereits vorhandenen cafes ein 
weiteres hinzugef+gt werden. Es sollen in den views alle im arraylist 
vorhandnene cafes
angezeigt werden. Benutzen sie dafür for each schleifen



2. Aufgabe (JUnitTest)
   
Cafe:
Variante B, Gastronomie,
Control ist observer


Testfall:Wops,Duisburg,Bäckerei,ja,Tasse Kaffee, Kännchen Kafee


Erstellen sie einen test welcher den konstruktur der klasse cafe mit dem testfall testet der vorgegeben wird.
Der test soll erfolgreich durchlaufene. Benutzen sie asserttrue und einen booleansupllier,welcher prüft, ob der
name im konstruktor auf auf Wops Duisburg


Erstellen sie einen weitere Test, welcher den konstruktor der Klasse Cafe testet. Nehmen sie den bisherigen testfall bis auf
die dienstleistungen. Diese geben sie mit null vor. Aufgrund der fehlenden Dienstleistung soll eine
IllegalArgumentException geworfen werden. Benutzen sie assertthrows und einen lambda ausdruck. Der test wird
nicht erfolgreich durchlaufen, da die falsche Exception geworfen wird, eine nullpointerexception. Korrigieren sie den
Sourcecode, damit auch dieser Test erfolgreich läuft
