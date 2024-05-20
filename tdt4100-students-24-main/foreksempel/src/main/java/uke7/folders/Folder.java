package uke7.folders;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Folder {
    private String name;
    private List<Folder> subfolders; // Alternativt ha en Set med HashSet
    private Folder parent;
    private List<OurFile> files;

    // private void setParent(Folder parent) { //todo: remove?
    //     this.parent = parent;
    // }
    
    public Folder(String name) {
        this.name = name;
        this.subfolders = new ArrayList<>(); //Tom liste
        this.files = new ArrayList<>();
    }

    public Folder addFolder(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Folder name cannot be null");
        }
        if (hasSubFolder(name)) {
            throw new IllegalStateException("Folder with name " + name + " already exists");
        } 
        
        Folder child = new Folder(name);
        child.parent = this;
        subfolders.add(child);
        return child;
    }

    private void addFolder(Folder folder) {
        if (folder == null) {
            throw new IllegalArgumentException("Folder cannot be null");
        }
        if (findSubFolder(folder.name) != null) {
            throw new IllegalStateException("Folder with name " + folder.name + " already exists");
        }
        subfolders.add(folder);
    }

    public boolean hasSubFolder(String name) {
        for (Folder f : subfolders) {
            if (name.equals(f.name)) {
                return true;
            }
        }
        return false;
    }

    public Folder findSubFolder(String name) {

        for (Folder f : subfolders) {
            if (name.equals(f.name)) {
                return f;
            }
        }
        throw new IllegalArgumentException("Folder " + name + " not found");
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    public OurFile getFile(String name) {
        if (name == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }
        for (OurFile f : files) {
            if (name.equals(f.toString())) {
                return f;
            }
        }
        // Denne oppførselen med å opprette en fil hvis den ikke finnes,
        // er vanlig i programmeringsspråk hvis en vil skrive til filen.
        //todo: Lag kode for å differensiere mellom skriving og lesing fra fil
        // subklasser?
        OurFile newFile = new OurFile(name);
        files.add(newFile);
        return newFile;
    }

    public boolean contains(Folder folder) {
        Folder f = folder;
        while (f != null) {
            if (f.equals(this)) {
                return true;
            }
            f = f.getParent();
        }
        return false;
    }

    public void move(Folder toOther) {
        // Skulle en heller ha bedt parent om å flytte et av sine barn?
        if (contains(toOther)) {
            throw new IllegalStateException("Cannot move folder to itself");
        }
        if (toOther.equals(parent)) {
            return;
        }
        // Selve flyttingen. Først prøv å legge til i ny mappe, så fjern fra gammel mappe
        toOther.addFolder(this); // Uløser unntak hvis toOther har subfolder med samme navn.
    
        //NB! Vi håndterer ikke dette unntaket her, men lar det "piple" opp i kall-stakken
        parent.subfolders.remove(this);
    }

    public String path() {
        if (parent == null) {
            return name;
        }
        return parent.path() + "/" + name;
    }

    public void printContents() {
        printContents(0);
    }

    public void printContents(int level) {
        
        System.out.print("  ".repeat(level));
        System.out.println(this);
        for (OurFile f : files) {
            System.out.print("  ".repeat(level + 1));
            System.out.println(f);
        }
        for (Folder f : subfolders) {
            f.printContents(level + 1);
        }
    }

    @Override
    public String toString() {
        return name;
    }
    
    public List<OurFile> findAllFiles(Predicate<OurFile> predicate) {
        ArrayList<OurFile> result = new ArrayList<>();
        findAllFiles(predicate, result);
        return result;
    }

    private void findAllFiles(Predicate<OurFile> predicate, List<OurFile> result) {
        result.addAll(this.files.stream().filter(predicate).toList());
        for (Folder f : subfolders) {
            f.findAllFiles(predicate, result);
        }
    }

    public static void main(String[] args) {
        Folder root = new Folder("/");

        Folder users = root.addFolder("Users");
        Folder local = root.addFolder("local");
        System.out.println(root.subfolders);

        users.addFolder("hei").addFolder("hå");
        local =  root.findSubFolder("local");
        System.out.println(local);

        Folder p = local.getParent();
        System.out.println(p.getName());
        
        //System.out.println(p.getParent().getName()); // NB! Problem med null

        root.addFolder("local");
        System.out.println(root.subfolders);

        System.out.println(root.contains(local));

        users = root.findSubFolder("Users");
        local.move(users);
        System.out.println(users.subfolders);

    }
}
