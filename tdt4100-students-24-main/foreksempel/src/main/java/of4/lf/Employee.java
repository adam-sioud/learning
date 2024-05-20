package of4.lf;


public class Employee {

    private Department employer;

    public Employee(Department employer){
        this.employer = employer;
        this.employer.addEmployee(this);
    }

    public void promote(){
        if(this.employer.getParentDepartment() == null){
            throw new IllegalStateException("Kan ikke blir forremmet");
        }

        this.employer.removeEmployee(this);
        this.employer = this.employer.getParentDepartment();
        this.employer.addEmployee(this);
    }

    public void quit(){
        if (this.employer == null) {
            throw new IllegalStateException("Ikke ansatt"); 
        }
        this.employer.removeEmployee(this);
        this.employer = null; 
    }


    public static void main(String[] args) {
        Department A = new Department();
        Employee mathea = new Employee(A);
        Employee oskar = new Employee(A);
        System.out.println("Hei");
    }
    
}
