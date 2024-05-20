# Delegering brukt i et settings-hiarki

Instillinger er her et sett med nøkkelord og tilhørende verdier (key-value pairs), som håndteres godt av Map-interfacet i Java (tilsvarende Dictionary i Python).

I en applikasjon, så vil det typisk være standard-instillinger (default settings), som
en bruker kan endre. 

Innstillingene (både default og de bruker-definerte) kan videre være **lagdelt**. I VSCode f.eks. så vil en ha instillinger som gjelder brukeren generelt, og instillinger som gjelder et konkret prosjekt. (En kan også skifte mellom flere sett med instillinger på hvert nivå, men det tar vi ikke høyde for i dette eksempelet).

I koden har vi et interface ISettings som definerer et felles grensesnitt for de to klassene
MapSettings og DafaultingSettings.

MapSettings-klassen svarer til bruker-settings: Den delegerer til et Map-objekt for å finne instllinger. 

DefaultingSettings-klassen svarer til ett lag i beskrivelsen over, f.eks. prosjekt-settings. Den har to sett med settings-objekter. Et som typisk håndterer bruker-instillinger, og et som håndterer **verdier som ikke er satt av bruker på dette nivået**.

Hvis det ikke er flere nivåer, så vil det kun være default-verdier, som da er et MapSettings-objekt. Hvis det er flere nivåer, så er det et nytt DefaultingSettings-objekt, f.eks. **brukerinstillinger**. De som brukeren har satt, ligger da dettes objektets userSettings-objekt, mens default i defaultSettings. 

Hvis det er flere nivåer, så forsetter dette rekursivt, med ny DefaultingSettings-objekt etc.



