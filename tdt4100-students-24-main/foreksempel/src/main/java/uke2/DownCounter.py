def isFinished():
    return counter == 0;

def countDown():
    if not isFinished():
        global counter
        counter -= 1
        print('Teller ned med 1, nå er det',counter)
        
counter = 4
countDown()
print(isFinished())
countDown()
print(isFinished())
countDown()
print(isFinished())
countDown()
print(isFinished())
countDown()
print(isFinished())

# Når vi kjører dette scriptet er vi faktisk inni 'dette scriptet' sin main-metode!
# Hvis du vil lære mer om dette: 
# https://stackoverflow.com/questions/419163/what-does-if-name-main-do
# Dette virker litt merkelig, men vi pleier ofte å skrive slikt som dette:

if __name__ == "__main__":
    print("Hello, World!")
    # Her kan en gjerne lage kall til metodene en har laget, for å teste dem.
    # __name__ er ikke __main__ når man importerer denne koden via import.
# 