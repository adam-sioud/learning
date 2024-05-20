package uke7.folders;

import java.util.function.Predicate;

public class FileNamePredicate implements Predicate<OurFile> {
    
    private final String fileName;

    public FileNamePredicate(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean test(OurFile f) {
        return f.getName().equals(fileName);
    }
}
