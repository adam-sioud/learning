package uke7.folders;

import java.util.function.Predicate;

public class FilesInFolders implements Predicate<OurFile> {
    private final String fileExtension;
    private final String nameFragment;

    public FilesInFolders(String fileExtension, String nameFragment) {
        this.fileExtension = fileExtension;
        this.nameFragment = nameFragment;
    }
    @Override
    public boolean test(OurFile file) {
        return file.getExtension().equals(fileExtension) && 
            file.getName().contains(nameFragment);
    }
}
