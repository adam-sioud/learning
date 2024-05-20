# Repetisjon og eksamenstrening

## Litt praktisk
- VSCode ting
- Klone fra gitlab
- Bytte mellom grener (f.eks. oppgavesett og LF)
- Søke etter TODO og bruke resultatlisten
- Javadoc

### VSCode-ting
- Hold mus over og det kommer opp info. 
- Høyreklikk

### Debugging
Se ...


### Records
- Definerer klasser som er ment å holde data
- "Boilerplate" genereres automatisk, 

- NB! Alle felt er final

### Nedlasting fra gitlab, visning av grener.

### TODO-liste 
En kan lett vise todo-liste som viser hvor en skal skrive kode, og bruke den til å navigere. En kan enten søke, eller se under **Problems**

Man kan fjerne todo-kommentaren eller lekke til f.eks. done, for å se hva en ikke har gjort/har gjort. 

### HUSK:
- Det kan være greit å venne seg til å lagre kode (Ctrl-S eller Ctr-K S for save all). Vi skal prøve å skru på autolagring på eksamensmaskinene, men uansett greit å venne seg til det.

## Hvordan en jobbe med typisk eksamensoppgave (bruker ord-2023 som eksempel)
I mange oppgaver dreier det seg om å forstå hvordan interne tilstand i objektet skal representeres, for å sikre at metodene virker. Har kan de være forskjellige måter å løse en oppgave på. Se på den beskrevne oppførlselen, og forsøk å velge noe som gir relativt lette oppgaver (Eksempler, liste, map, et object av en gitt klasse?)

NB! I år vil oppgaveteksten i hovedsak være gitt som javadoc, og ikke i markdown-filer.  

Deres egne kommentarer som kandidatene skulle skrive i egen markdown-fil, skal nå skrives i selve koden. 

## Besvarelsene skal i utgangspunktet ikke ha kompileringsfeil
Sjekke at dere ikke har igjen noen røde streker - ikke bare kan vi ende med å trekke for det, men man mister også viktig hjelp fra verktøyet. 

**MEN:** Hvis du ikke får til en metode, men mener de har noe som er på vei, så er det bedre å la ting stå og sikre null røde streker enn å fjerne alt og bare returnere noe som fjerner streken - det er manuell sensur så smarte delpoeng kan man sanke.  Men man får ikke mye poeng for rein pseudokode. De ender ofte opp som bare en gjenfortelling av kravene til metoden... 

Vi lager oppgaver som i stor grad kan løses uanvhengig av hverandre (løs kobling).
**Men det betyr ikke at en ikke må håndtere flere objekter i sammenheng(objektstrukturer og interaksjon mellom objekter)**.

Det gjør at en i hver oppgave kan måtte forholde seg til noen (nye) gitte klasser, som man ikke skal endre på, men bare bruke. (Eksempel: Luggage i ord2023).


## Bruk debugger
- Sett breakpunkter, 
- Se på verdier i call stack
- En kan klikke i call-stacken

## 