package uke7.folders;

public class OurFile {
    private String name;
    private String extension;
    private String contents;
    
    //Folder parent;

    // Hvis vi har referanse til forelder-mappen, så får vi en ekstra avhengighet
    // Det betyr at klassen kan kun brukes i denne sammenhengen.
    // En må vurdere ulemper opp mot fordelene med å kunne navigere rett fra
    // filen til mappen den ligger i. Vanligvis så vil en jo ikke navigere fra en fil
    // til dens mappe. Klient-koden må holde på referansen til mappen selv. No problem!!
    
    public OurFile(String nameWithPossibleExtension) {
        if (nameWithPossibleExtension == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        int dotIndex = nameWithPossibleExtension.lastIndexOf('.');
        if (dotIndex == -1) {
            this.name = nameWithPossibleExtension;
        }
        else {
            this.name = nameWithPossibleExtension.substring(0, dotIndex);
            this.extension = nameWithPossibleExtension.substring(dotIndex + 1);
        }
    }

    public OurFile(String name, String extensionString) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        if (extensionString == null) {
            this.extension = "";
        }
        else {
            this.extension = extensionString;
        }
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public String getContents() {
        return contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }

    public void appendContents(String contents) {
        this.contents += contents;
    }
    
    public void deleteContents() {
        this.contents = "";
    }

    @Override
    public String toString() {
        return name + "." + extension;
    }

}


