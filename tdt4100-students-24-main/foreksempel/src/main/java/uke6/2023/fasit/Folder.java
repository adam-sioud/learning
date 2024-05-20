package uke6.fasit;

import java.util.ArrayList;
import java.util.Collection;


public class Folder {
    String name;
    Folder parent;
    Collection<Folder> folders = new ArrayList<>();
    Collection<File> files = new ArrayList<>();


    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
        if (parent != null) 
            parent.addFolder(this);

    }


    public void addFile(File file) {
        this.files.add(file);
    }

    public void removeFile(File file) {
        this.files.remove(file);
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


    private Collection<Folder> getFolders() {
        return this.folders;
    }

	@Override
	public String toString() {
		String tmp = "/" + name;
		if (parent != null)
			tmp = parent.toString() + tmp;
		return tmp;
	}


    public void printTree() {
        System.out.println(this);
        for (File file : files) {
            System.out.println(file);
        }
        for (Folder folder : folders) {
            folder.printTree();
        }
    }


    private boolean contains(Folder destination) {
        System.out.println(this+ " contains "+destination);
        if (this.equals(destination)) return true;
        for (Folder folder : folders) {
            if (folder.contains(destination)) return true;
        }
        return false;
    }

    private boolean contains2(Folder destination) {
        if (destination != null)
            System.out.println(this+ " contains2 "+destination);
        if (destination == null) return false;
        if (destination == this) return true;
        return this.contains2(destination.getParent()); 
    }


    public void move(Folder destination) {

        if (this.contains(destination))
            throw new IllegalStateException("Loop de loop");
        parent.removeFolder(this);
        this.parent = destination;
        parent.addFolder(this);
    }

    Object findFirst(String pattern) {
		for (File file : files) {
			if (file.name.equals(pattern))
				return file;
		}
		
		for (Folder folder : folders) {
            if (folder.name.equals(pattern))
            return folder;
		}
		
		for (Folder folder : folders) {
			Object found = folder.findFirst(pattern);
			if (found != null)
				return found;
		}
		
		return null;
		
	}

    private void findAll(String pattern, Collection<File> hits) {
        for (File file : files) {
            if (file.getName().equals(pattern))
                hits.add(file);
        }

        for (Folder folder : folders) {
            folder.findAll(pattern, hits);
        }
    }


    public Collection<File> findAll(String pattern) {
        Collection<File> tmp = new ArrayList<>();
        findAll(pattern, tmp);
        return tmp;
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

        // home.printTree();
        // System.out.println("Flytter cdiv til borgeh");
        // cdiv.move(borgeh);
        // home.printTree();
        // System.out.println("Flytter borgeh til cdiv");
        // borgeh.move(cdiv);
        // home.printTree();   

        // for (int i = 0; i < 30; i++) {
        //     Folder tmp = new Folder("folder"+i, home);
        // }
        // for (Folder folder : home.getFolders()) {
        //     for (int i = 0; i < 30; i++) {
        //         Folder tmp = new Folder("folder"+i, folder);
        //     }    
        // }
        // System.out.println(home.contains(cdiv));
        // System.out.println(home.contains2(cdiv));

        System.out.println("findFirst: "+home.findFirst("borgeh"));
        File bfil = new File("Børge.txt", borgeh);
        System.out.println("findFirst fil: "+home.findFirst("Børge.txt"));
        
        File hfil = new File("fil.txt", home);
        File afil = new File("fil.txt", adiv);
        afil.move(borgeh);

        home.printTree();

        System.out.println(home.findAll("fil.txt"));

    }





}
