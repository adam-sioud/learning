# IO Streams - ikke det samme som Java 8 strems ("lambda-streams")
- Vi skiller mellom **byte-data** og **char-data** (tegn). Et tegn kan bestå av flere bytes. 
- Noen IO-klasser opererer med bytes (binære data), andre med chars (tekst-data).

## Ascii-koder, samme som starten på Unicode-koder

| ASCII Value | Name/Representation | ASCII Value | Name/Representation | ASCII Value | Name/Representation | ASCII Value | Name/Representation | ASCII Value | Name/Representation | ASCII Value | Name/Representation | ASCII Value | Name/Representation | ASCII Value | Name/Representation |
|-------------|---------------------|-------------|---------------------|-------------|---------------------|-------------|---------------------|-------------|---------------------|-------------|---------------------|-------------|---------------------|-------------|---------------------|
| 0           | NUL (Null char)     | 1           | SOH (Start of Heading)| 2           | STX (Start of Text) | 3           | ETX (End of Text)   | 4           | EOT (End of Transmission) | 5           | ENQ (Enquiry)       | 6           | ACK (Acknowledge)   | 7           | BEL (Bell)          |
| 8           | BS (Backspace)      | 9           | TAB (Horizontal Tab)| 10          | LF (Line Feed)      | 11          | VT (Vertical Tab)   | 12          | FF (Form Feed)      | 13          | CR (Carriage Return)| 14          | SO (Shift Out)      | 15          | SI (Shift In)       |
| 16          | DLE (Data Link Escape) | 17        | DC1 (Device Control 1) | 18          | DC2 (Device Control 2) | 19          | DC3 (Device Control 3) | 20          | DC4 (Device Control 4) | 21          | NAK (Negative Acknowledge) | 22          | SYN (Synchronous Idle) | 23          | ETB (End of Trans. Block) |
| 24          | CAN (Cancel)        | 25          | EM (End of Medium)  | 26          | SUB (Substitute)    | 27          | ESC (Escape)        | 28          | FS (File Separator) | 29          | GS (Group Separator)| 30          | RS (Record Separator)| 31          | US (Unit Separator) |

| ASCII Value | Symbol | ASCII Value | Symbol | ASCII Value | Symbol | ASCII Value | Symbol | ASCII Value | Symbol | ASCII Value | Symbol | ASCII Value | Symbol | ASCII Value | Symbol |
|-------------|--------|-------------|--------|-------------|--------|-------------|--------|-------------|--------|-------------|--------|-------------|--------|-------------|--------|
| 32          | (Space)| 33          | !      | 34          | "      | 35          | #      | 36          | $      | 37          | %      | 38          | &      | 39          | '      |
| 40          | (      | 41          | )      | 42          | *      | 43          | +      | 44          | ,      | 45          | -      | 46          | .      | 47          | /      |
| 48          | 0      | 49          | 1      | 50          | 2      | 51          | 3      | 52          | 4      | 53          | 5      | 54          | 6      | 55          | 7      |
| 56          | 8      | 57          | 9      | 58          | :      | 59          | ;      | 60          | <      | 61          | =      | 62          | >      | 63          | ?      |
| 64          | @      | 65          | A      | 66          | B      | 67          | C      | 68          | D      | 69          | E      | 70          | F      | 71          | G      |
| 72          | H      | 73          | I      | 74          | J      | 75          | K      | 76          | L      | 77          | M      | 78          | N      | 79          | O      |
| 80          | P      | 81          | Q      | 82          | R      | 83          | S      | 84          | T      | 85          | U      | 86          | V      | 87          | W      |
| 88          | X      | 89          | Y      | 90          | Z      | 91          | [      | 92          | \      | 93          | ]      | 94          | ^      | 95          | _      |
| 96          | `      | 97          | a      | 98          | b      | 99          | c      | 100         | d      | 101         | e      | 102         | f      | 103         | g      |
| 104         | h      | 105         | i      | 106         | j      | 107         | k      | 108         | l      | 109         | m      | 110         | n      | 111         | o      |
| 112         | p      | 113         | q      | 114         | r      | 115         | s      | 116         | t      | 117         | u      | 118         | v      | 119         | w      |
| 120         | x      | 121         | y      | 122         | z      | 123         | {      | 124         | \|     | 125         | }      | 126         | ~      |             |        |

## InputStream
Vi kjenner allerede et eksempel: System.in. InputStream leser bytes, ikke chars.

## InputStreamReader
Denne legger til mekanisme for å tolke byte-strømmen som chars:
[BrukInputStreamReader](iostrems/BrukInputStreamReader.java)

## FileReader
Lager en input-stream av chars fra fil:
[BrukFileReader](iostreams/BrukFileReader.java)

## BufferedReader
For ytelse, så er det ofte å foretrekke IO med *buffere*, dvs. som leser/skriver større pakker data om gangen.
BufferedReader tar inn en Reader, og "dekorerer" den med buffer.

[BrukBufferedReader](iostreams/BrukBufferedReader.java)


## Oversikt over CharacterStream klasser
- BufferedReader
- FileReader
- InputStreamReader
- OutputStreamReader
- Reader
- PrintWriter
- Writer
- BufferedWriter
- FileWriter
  
## Scanner




