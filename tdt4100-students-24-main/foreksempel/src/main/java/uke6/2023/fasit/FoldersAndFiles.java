package uke6.fasit;

import java.util.ArrayList;
import java.util.Collection;


public class FoldersAndFiles {
    Collection<Object> ff = new ArrayList<>();


    public void addFile(File file) {
        ff.add(file);
    }

    public void addFolder(Folder folder) {
        ff.add(folder);
    }

    public Object findFirstHit(String pattern) {
        for (Object object : ff) {
            System.out.println("Sjekker "+object);
            if (object.toString().contains(pattern)) {

                // To måter å vite originalklassen som laget objektet:
                if (object instanceof Folder) {
                    System.out.println("First hit was a Folder!");
                }
                else if (object.getClass() == File.class) {
                    System.out.println("First hit was a File!");
                }
                // Hva er best? Tja. https://stackoverflow.com/questions/4989818/instanceof-vs-getclass
                // Og: The main difference is that instanceof will return true if o has inheritance of the 
                // object whereas getClass comparation will check if both objects are strictly the same
                // class. Mao: det kommer an på hva en forsøker å gjøre.

        
                return object;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FoldersAndFiles faf = new FoldersAndFiles();
        Folder home = new Folder("home", null);
        faf.addFolder(new Folder("borgeh", home));
        faf.addFile(new File("fil.txt", home));
        faf.addFile(new File("fil2.txt", home));
        faf.addFile(new File("fil3.txt", home));
        System.out.println(faf.findFirstHit("3"));
        Object hit = faf.findFirstHit("bor");
        Folder myFolder = (Folder) hit;
    }
}
