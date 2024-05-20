package uke6.fasit;

import java.util.ArrayList;
import java.util.Collection;


public class Folder {
    String name;
    Folder parent;
    Collection<Folder> folders;

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
        folders = new ArrayList<>();
    }


    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }
    
    public void removeFolder(Folder folder) {
        this.folders.remove(folder);
    }

    public Folder getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
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
        System.out.println(home);
    }

}
