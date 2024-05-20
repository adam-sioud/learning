
package uke10.personbean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/*
 * PersonBean-klassen definerer objekter som både er observatører og observerte.
 * Dette gjør at objekter av denne klassen kan lytte etter endringer i andre objekt,
 * og samtidig sende ut meldinger om endringer i seg selv.
 * 
 * NB! For å bruke beans-pakken må vi si ifra i module-info.java filen:
 *  requires java.beans;
 */

public class PersonBean implements Serializable, PropertyChangeListener {
    private final String name;
    private String favouriteColor;
    private PropertyChangeSupport support;  // delegat-objekt

    public PersonBean(String name) {
        this.name = name;
        this.favouriteColor = "neutral";
        this.support = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setFavouriteColor(String property) {
        String oldProperty = this.favouriteColor;
        this.favouriteColor = property;       // NB! Setter ny verdi før varsling

        // firePropertyChange sender ikke varlser hvis verdi ikke er endret.
        support.firePropertyChange("favouriteColor", oldProperty, property);
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.print(this + " notified from " + evt.getSource() + ": ");
        System.out.println("Changed " + evt.getPropertyName() + " from " +
        evt.getOldValue() + " to " + evt.getNewValue());
    }

    public static void main(String[] args) {
        PersonBean alice = new PersonBean("Alice");
        PersonBean bob = new PersonBean("Bob");

        // Bob lytter på endringer hos alice
        alice.addPropertyChangeListener(bob);

        // Change the name property of person1
        System.out.println("Alice sets favourite color to red");
        alice.setFavouriteColor("red");

        // Setter samme egenskap på nytt, gir ingen varsling om endring
        System.out.println("\nAlice sets favourite color to red");
        alice.setFavouriteColor("red");  

        PersonBean ada = new PersonBean("Ada");
        ada.addPropertyChangeListener(bob); // person2 lytter på både 
        System.out.println("\nAda sets favourite color to blue");
        ada.setFavouriteColor("blue");

        ada.addPropertyChangeListener(ada);  // Ada lytter på seg selv
        System.out.println("\nAda sets favourite color to yellow");
        ada.setFavouriteColor("yellow");

        ada.removePropertyChangeListener(ada);  // Ada lytter ikke lenger på seg selv
        System.out.println("\nAda sets favourite color to red");
        ada.setFavouriteColor("red");
        
    }
}