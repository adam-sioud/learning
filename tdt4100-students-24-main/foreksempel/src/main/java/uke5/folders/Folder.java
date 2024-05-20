package uke5.folders;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Folder> subfolders; // Alternativt ha en Set med HashSet
    private Folder parent;
    
    public Folder(String name) {
        this.name = name;
        this.subfolders = new ArrayList<>(); //Tom liste
    }

    public void addFolder(String name) {
        if (findSubFolder(name) == null) {
            Folder child = new Folder(name);
            child.parent = this;
            subfolders.add(child);
        }
    }

    public void addFolder(Folder folder) {
        subfolders.add(folder); //todo: legge til sjekk på navn
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Folder other = (Folder) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        return true;
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
    
    public static void main(String[] args) {
        Folder root = new Folder("/");

        root.addFolder("Users");
        root.addFolder("local");
        System.out.println(root.subfolders);

        Folder local =  root.findSubFolder("local");
        System.out.println(local);

        Folder p = local.getParent();
        System.out.println(p.getName());
        
        //System.out.println(p.getParent().getName()); // NB! Problem med null

        root.addFolder("local");
        System.out.println(root.subfolders);

        System.out.println(root.contains(local));

        Folder users = root.findSubFolder("Users");
        local.move(users);
        System.out.println(users.subfolders);






    }
}
