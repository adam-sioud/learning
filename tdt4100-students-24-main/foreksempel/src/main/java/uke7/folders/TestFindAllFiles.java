package uke7.folders;

import java.util.List;

public class TestFindAllFiles {
    public static void main(String[] args) {
        Folder root = new Folder("/");

        Folder sf1 = root.addFolder("sf1");
        Folder data1 = root.addFolder("data");
        data1.getFile("data.txt").appendContents("null"); 

        Folder sf2 = root.addFolder("sf2");
        sf2.getFile("hello.txt").appendContents("Hello World!");
        
        Folder data = sf2.addFolder("data");
        data.getFile("data1.txt").appendContents("x");
        data.getFile("data2.txt").appendContents("y");
        data.getFile("data.png");

        root.printContents();

        List<OurFile> found = root.findAllFiles(new FilesInFolders("txt", "data"));
        System.out.println(found);
    }
}
