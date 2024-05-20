package of6.lf;

public class Employee implements CallRecipient {
    private String name;
    private String role;
    private int numberOfCalls = 0;

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

    public int getNumberOfCalls(){
        return this.numberOfCalls;
    }

    @Override
    public void answerCall(String call) {
        this.numberOfCalls ++;
        System.out.println(call);
    }


}
