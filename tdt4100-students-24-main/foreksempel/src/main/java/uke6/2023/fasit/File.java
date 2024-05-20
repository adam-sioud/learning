package uke6.fasit;

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
        if (parent == null)
            throw new IllegalStateException("En fil må ha en parent.");
        this.parent = parent;
        this.name = name;
        parent.addFile(this);
    }

    
	@Override
	public String toString() {
		return parent+"/"+getName();
	}



    public void move(Folder destination) {
        parent.removeFile(this);
        destination.addFile(this);
        this.parent = destination;
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
        File cfil = new File("CarstenFil.txt", carsten);
        // System.out.println(cfil);
        home.printTree();

        cfil.move(borgeh);
        home.printTree();
        home.findFirst("hei");
        Object o = home.findFirst("CarstenFil.txt");
        System.out.println("Funnet: "+o);
        }
}
