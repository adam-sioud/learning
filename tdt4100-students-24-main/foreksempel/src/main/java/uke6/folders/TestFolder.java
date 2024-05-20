package uke6.folders;

public class TestFolder {
    
    public static void main(String[] args) {
        
        // Kan vi lage inkonsistent Folder-struktur?
        try {
        Folder root = new Folder("/");
        Folder sf1 = new Folder("sf1");
        sf1.addFolder(root);

        //Dette burde vi ikke få lov til, siden root er barn av sf1
        root.addFolder(sf1); 
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Folder root = new Folder("");
        root.addFolder("subfolder1");
        root.addFolder("subfolder2");
        

    }
}
