package of7.lf;

import java.util.Collection;
import java.util.List;

public class Boss extends Employee {

    private Collection<Employee> subordinates;

    public Boss(String name, Collection<Employee> subordinates) {
        super(name, "Boss");
        if(subordinates.isEmpty()){
            throw new IllegalArgumentException("A boss must have at least one subordinate");
        }
        this.subordinates = subordinates;
    }

    @Override
    public boolean canPerformTask(String task) {
        return subordinates.stream().anyMatch(sub -> sub.canPerformTask(task));
    }

    @Override
    public void performTask(String task){
        subordinates.stream().filter(sub -> sub.canPerformTask(task))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("No subordinate that can perform task"))
                    .performTask(task);

    }

    public static void main(String[] args) {
        Assistant assistant = new Assistant("Mathea");
        Consultant temp = new Consultant("Trine", "IT", 1);

        Boss boss = new Boss("Børge", List.of(assistant, temp));

        boss.performTask("Arrange meeting");
        boss.performTask("order stock");
        boss.performTask("pay salaries");
    }
    
}
