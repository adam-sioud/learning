package of7.lf;

public class Consultant extends Employee {

    private int numberOfRemainingTasks;

    public Consultant(String name, String role, int numberOfRemainingTasks) {
        super(name, role);
        this.numberOfRemainingTasks = numberOfRemainingTasks;
    }

    @Override
    public boolean canPerformTask(String task) {
        return numberOfRemainingTasks > 0;
    }

    @Override
    public void performTask(String task){
        super.performTask(task);
        numberOfRemainingTasks -= 1;
    }

    public static void main(String[] args) {
        Consultant employee = new Consultant("Mathea", "Intern", 2);
        employee.performTask("plz fix");
        employee.performTask("aligne");
        employee.performTask("make better");

    }
    
}
