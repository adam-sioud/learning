package uke5;

public class Person {
    private String name;
    private Email email;

    public Person(String name, Email email) {
        this.name = name;
        this.email = email;
    }
    
    public Person(String name, String email) {
        this.name = name;
        this.email = new Email(email);
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.toString();
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", email=" + email + "]";
    }

    public static void main(String[] args) {
    
    }
}
