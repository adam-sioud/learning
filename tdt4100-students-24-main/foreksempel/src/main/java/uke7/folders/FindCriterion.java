package uke7.folders;

public interface FindCriterion {

    boolean keepFolder(Folder folder);
    boolean keepFile(OurFile file);
    
}
