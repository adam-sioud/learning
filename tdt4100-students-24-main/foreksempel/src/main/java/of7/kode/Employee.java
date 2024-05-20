package of7.kode;

public class Employee {
    private String name;
    protected String role;

    public Employee(String name, String role){
        this.name = name;
        this.role = role;

    }

    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    public void preformTask(String task){
        System.out.println(name + " [" + role + "] performed task: " + task);
        
    }
    
}
