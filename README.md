Installationsinstruktioner:
Öppna "Uppgift1RestAPI" i IntelliJ IDEA och kör "Uppgift1RestAPIApplication". 
Öppna sedan Postman och MongoDB för att lägga till, ta bort, updatera eller filtrera collections samt kunna se alla collections och dess dokumentation

Länk till publicerad Postman-dokumentation:
https://documenter.getpostman.com/view/40894421/2sAYX5M3oc

Beskrivning av affärsregler:
Affärsregler som skulle implementeras var En användare kan inte ha mer än 10 aktiva annonser samtidigt, 
Växter markerade för byte kan endast bytas mot andra växter, inte säljas
Vid byte måste båda parter godkänna bytet innan det genomförs
Prissatta växter måste ha ett fast pris mellan 50-1000 kr

Här hade jag problem med alla affärsregler utom den som gäller prissättning.

Lista över kända begränsningar:
Affärsregler, API för att kunna se "plants available", "plants by user" och "transactions by user". Samt lägga till valideringsannotationer för vissa variabler och Service klasser

Förslag på förbättringar:
Implementera ALLA affärsregler,
Fixa API för "plants available", "plants by user" och "transactions by user"
Skapa Service klasser,
Lägg till valideringsannotationer för variabler i klasserna "plant", "user" och "transaction"

