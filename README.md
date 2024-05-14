> ## Tools und Anwendungen

In diesem Projekt wird mit Playwright verwendet um die Seite "https://www.saucedemo.com/" zu testen. \
Als Package Verwaltung verwende ich Maven. \
Zum ausführen der Test wird TestNG verwendet. \
Um die Ergebnisse aufbereitet anzuzeigen wird Allure verwendet. \


## Tests ausführen

In der "testng.xml" müssen zwei Parameter angegeben werden:
- headless -> true, wenn der Browser im Hintergrund gestartet werden soll oder false, wenn der Browser angezeigt werden soll
- betriebssystem -> Mac oder Windows (für das erstellen des Reporting für die Befehle)
- browser -> welcher Browser verwendet werden soll

Um den Test zu starten musst du erst in den Ordner navigieren in der Kommandozeile. 
Danach muss der Befehl "mvn clean test" eingegeben werden. Jetzt sollte der Test Starten.


## Reporting

Das Reporting findet ihr im "allure-report"-Ordner um das Reporting zu öffnen muss die "index.html" aufgerufen werden.
