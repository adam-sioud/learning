package uke7.folders;

public class FindTextFilesInDataFolders implements FindCriterion {

    @Override
    public boolean keepFolder(Folder folder) {
        return folder.getName().contains("data");
    }

    @Override
    public boolean keepFile(OurFile file) {
        return file.getExtension().equals("txt");
    }
    
}
