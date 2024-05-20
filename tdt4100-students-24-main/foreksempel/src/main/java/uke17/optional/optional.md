# Optional

Se forelesning og slides fra mandag uke 14 

## Hensikten med Optional<T>
Legg merke til at Optional er *parametrisert* med en type T. Så det finnes en Optional-type for hver type T.
- Et objekt av type Optional<T> representerer enten et objekt av type T, eller *frævær av en slik*, dvs. **null**.
- Optional *kommuniserer at fravær av en verdi er en mulighet*, som vi ikke må hvis vi i stedet potensielt kan ha **null**. 
- Å glemme eller å tro at en ikke trenger å sjekke for **null** er en vanlig årsak til at et program feiler med **NullPointerException**.

Se UseOptional.java for eksempler


## Pensum
La ```opt``` være et Optional objekt av type Optional<T>, og t et objekt av type T

Håndtere Optional-objekter som resultat:
- ```opt.isPresent()```
- ```opt.isEmpty()```
- Hente ut verdi med ```opt.get()```. **Ikke gjør uten først å sjekke at vi har verdi**
- ```opt.orElse(t)```, som get(), men med alternativ hvis opt er tom.
- ```opt.orElseGet(x -> noe som gir t)``` mer generell enn den over.

Kjenne til følgende situasjoner hvor Optional kan returneres i standard-biblioteker i Java:
- streams-metoder som max, findFirst etc. Sjekk javadoc'en når for returverdi

Konsturere Optional-objekter via metodene:
- ```Optional.of(t)``` la Optional med t som innhold, utløser unntak hvis t == null
- ```Optional.ofNullable(t)```: som over, men tillater t == null, som da gir tom optional (opt.isEmpty() == true)


Optinal har likheter med Stream, bare at det er enten ingen eller ett objekt.
streams har "lat evaluering", og immuterbare. Følgende vil returnere Optionals, og utføre operasjonen
på opt sin verdi, hvis ikke empty:
- ```opt.map( functional )```  
- ```opt.flatmap( functional )``` som over, men hvor funksjonen produserer Optional-objekt.
- ```opt.filter( predicate )``` 
