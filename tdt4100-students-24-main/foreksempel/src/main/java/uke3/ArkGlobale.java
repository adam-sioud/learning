package uke3;

class ArkGlobale {
    public static int sum = 0, kvadratSum = 0;

    public static void summer(String[] args) { 
        for (int i = 0; i < args.length; i++) {
            int n = Integer.valueOf(args[i]);      
            sum += n;
            kvadratSum += n * n;
        }
    }

    /* For å be VSCode om input-parametre, så gå til Run -> Add Configuration,
     * og finn frem til følgende seksjon, og legg til nederste linje med "args".
     * Da skriver du inn tallene med mellomrom mellom, f.eks. 1 2 3 (ingen anførselstegn)
     * {
            "type": "java",
            "name": "ArkGlobale",
            "request": "launch",
            "mainClass": "foreksempel/uke3.ArkGlobale",
            "projectName": "foreksempel",
            "args": "${command:SpecifyProgramArgs}"
        },
     */

    public static void main(String[] args) {
        summer(args);
        System.out.println("Sum: " + sum);
        System.out.println("Kvadratsum: " + kvadratSum);
        summer(args);
        System.out.println("Sum: " + sum);
        System.out.println("Kvadratsum: " + kvadratSum);
    }

}