package uke6.folders;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Folder> subfolders; // Alternativt ha en Set med HashSet
    private Folder parent;
    private List<OurFile> files;

    private void setParent(Folder parent) {
        this.parent = parent;
    }
    
    public Folder(String name) {
        this.name = name;
        this.subfolders = new ArrayList<>(); //Tom liste
    }

    public Folder addFolder(String name) {
        if (findSubFolder(name) == null) {
            Folder child = new Folder(name);
            child.parent = this;
            subfolders.add(child);
            return child;
        }
        return null;
    }

    private void addFolder(Folder folder) {
        if (folder != null && findSubFolder(folder.name) == null) {
        subfolders.add(folder); //todo: unntak?
        }
    }

    public Folder findSubFolder(String name) {
        for (Folder f : subfolders) {
            if (name.equals(f.name)) {
                return f;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
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

    public boolean move(Folder toOther) {
        if (contains(toOther) || toOther.equals(parent)) {
            return false;
        }
        // Selve flyttingen:
        parent.subfolders.remove(this); //potensielt problem: todo: Undersøk
        toOther.addFolder(this); //todo: Sjekk at ikke allerede har subfolder med samme navn.
        return true;
    }

    public String path() {
        if (parent == null) {
            return name;
        }
        return parent.path() + "/" + name;
    }

    @Override
    public String toString() {
        return path();
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
