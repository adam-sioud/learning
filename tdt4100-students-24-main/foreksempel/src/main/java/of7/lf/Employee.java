package of7.lf;

public abstract class Employee {
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

    public void performTask(String task){
        if(!canPerformTask(task)){
            throw new IllegalArgumentException("Cant perform task");
        }
        System.out.println(name + " [" + role + "] performed task: " + task);
        
    }

    public abstract boolean canPerformTask(String task);
    
}
