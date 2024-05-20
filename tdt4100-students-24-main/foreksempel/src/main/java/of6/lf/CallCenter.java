package of6.lf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class CallCenter implements CallRecipient{

    private Collection<Employee> employees = new ArrayList<>();


    public void addEmployee(Employee employee){
        if(!this.employees.contains(employee)){
            this.employees.add(employee);
        }
    }

    public void removeEmployee(Employee employee){
        if(this.employees.contains(employee)){
            this.employees.remove(employee);
        }
    }

    @Override
    public void answerCall(String call) {
        String role;
        if(call.equals("Klage")){
            role = "Junior";
        }
        else if(call.equals("Internt")){
            role = "HR";
        }
        else if(call.equals("Advanced")){
            role = "Team-Manager";
        }
        else{
            role = "Junior";
        }
        
        this.getEmployeeForTask(role).answerCall(call);
    }

    private Employee getEmployeeForTask(String role){
        Comparator<Employee> comparator = new NumberOfTasksComparator();
        return this.employees.stream()
            .filter(employee -> employee.getRole().equals(role))
            .min((employee1, employee2) -> employee1.getNumberOfCalls() - employee2.getNumberOfCalls())
            .get();
    }






    
}
