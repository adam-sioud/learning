package of4.lf;

import java.util.ArrayList;
import java.util.Collection;

public class Department {

    private Department parentDepartment;
    private Collection<Department> subDepartments = new ArrayList<Department>();
    private Collection<Employee> employees = new ArrayList<Employee>();


    public Department(){
    }

    public Department(Department parentDepartment){
        this.parentDepartment = parentDepartment;
        this.parentDepartment.addSubDepartment(this);
    }

    public Department getParentDepartment(){
        return this.parentDepartment;
    }

    private void addSubDepartment(Department subDepartment){
        if (this.subDepartments.contains(subDepartment)) {
            throw new IllegalArgumentException("Underavdeling allerede registrert");
            
        }
        this.subDepartments.add(subDepartment);
    }

    public boolean containsDep(Department dep){
        if(this.subDepartments.contains(dep)){
            return true;
        }

        for (Department subdep : this.subDepartments){
            if (subdep.subDepartments.contains(dep)) {
                return true;
            }
        }

        return false;
    }

    public boolean depIsSub(Department dep){
        if(this.subDepartments.contains(dep)){
            return true;
        }

        if(this.subDepartments.isEmpty()){
            return false;
        }
    
        for (Department subdep : this.subDepartments){
            if (subdep.depIsSub(dep)){
                return true;
            }
        }

        return false;
    }

    public void addEmployee(Employee employee){
        if (this.employees.contains(employee)) {
            throw new IllegalArgumentException("Allerede ansatt");
            
        }
        this.employees.add(employee);
    } 

    public void removeEmployee(Employee employee){
        if (!this.employees.contains(employee)) {
            throw new IllegalArgumentException();
        }
    }








    
}
