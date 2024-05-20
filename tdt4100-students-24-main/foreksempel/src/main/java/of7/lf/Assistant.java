package of7.lf;

public class Assistant extends Employee {

    public Assistant(String name) {
        super(name, "Assistant");

        
    }

    @Override
    public boolean canPerformTask(String task) {
        return task.equals("Arrange meeting") || task.equals("Send email");
    }

    public static void main(String[] args) {
        Employee assistant = new Assistant("Mathea");
        assistant.performTask("Arrange meeting");
        assistant.performTask("Important decision");

    }
    
}
