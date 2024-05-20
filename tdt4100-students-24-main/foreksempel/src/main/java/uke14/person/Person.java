package uke14.person;

public class Person {
    private String name;
    private Person partner;
    
    public Person(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person newPartner) {
        if (newPartner == null) {
            Person oldPartner = this.partner;
            this.partner = null;
            if (oldPartner != null) {
                oldPartner.setPartner(null);
            }
            return;
        } 
        
        if (newPartner == this) {
            throw new IllegalArgumentException("Cannot be partner with oneself");
        }

        if (this.partner != newPartner) {
            if (this.partner != null) {
                this.partner.setPartner(null);
                //this will set this.partner to null!
            }
            this.partner = newPartner;
            newPartner.setPartner(this);
        }
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", partner=" + partner + "]";
    }
}
