public class awsomeprogram {
    
    // Main method
    public static void main(String[] args) {
        
        // primitives, spec the lowercase
        int myInt = 7;
        double myDouble = 9.2;
        char myInitial = 'n'; // you must use single quotes for a single char

        String firstSentence = "Hi there"; // This is a non-primtive

        System.out.println(firstSentence);
        printNameAge("john", 24);

       awsomeprogram2.dingDong();
    }

    public static void printNameAge(String name, int age){
        System.out.println(name +" "+ age);
    }

}
