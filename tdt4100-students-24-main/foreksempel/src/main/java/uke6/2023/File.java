package uke6;

import java.nio.file.Files;

public class File {
    
    String name;
    Folder parent;

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    public File(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
        this.parent.addFile(this);
    }

    
    @Override
    public String toString() {
        return parent+"/"+getName();
    }

    public void move(Folder destination) {
        parent.removeFile(this);
        this.parent = destination;
        parent.addFile(this);
    }


    public static void main(String[] args) {
        Folder home = new Folder("home",null);
        Folder andreas = new Folder("andreas",home);
        Folder borgeh = new Folder("borgeh",home);
        Folder carsten = new Folder("carsten",home);
        Folder adiv = new Folder("adiv",andreas);
        Folder bdiv = new Folder("bdiv",borgeh);
        Folder btmp = new Folder("btmp",borgeh);
        Folder cdiv = new Folder("cdiv",carsten);
        File fil1 = new File("a.txt", andreas);
        // home.printTree();

        fil1.move(borgeh);
        home.printTree();
        System.out.println(home.findFirst("a.txt"));
    }
}
