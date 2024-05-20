package of6.lf;

import java.util.Comparator;

public class NumberOfTasksComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getNumberOfCalls() - o2.getNumberOfCalls();
    }
    
}
