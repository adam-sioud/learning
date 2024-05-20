package uke10.delegering;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

interface Observer {
    void update(String event);
}
  
class EventSource {
    List<Observer> observers = new ArrayList<>();
  
    void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }
  
    void addObserver(Observer observer) {
        observers.add(observer);
    }
  
    void scanSystemIn() {
        var scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
        }
        scanner.close();
    }
}

public class ObserverScanner {
    public static void main(String[] args) {
        System.out.println("Skriv inn tekst : ");
        var eventSource = new EventSource();
        
        eventSource.addObserver(event -> {
            System.out.println("Tok imot streng: " + event);
        });
        eventSource.addObserver(event -> {
            System.out.println("Antall bokstaver: " + event.length());
        });
        eventSource.addObserver(event -> {
            System.out.println("Ordene: " + String.join(", ", event.split(" ")));
        });

        eventSource.scanSystemIn();
    }
}