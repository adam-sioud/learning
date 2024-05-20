package uke7.folders;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FilesInFoldersTest {
    @Test
    void testTest() {
        // Arrange
        String fileExtension = "txt";
        String folderName = "folder";
        OurFile file = new OurFile("folder/file.txt", "Hello World!");
        FilesInFolders predicate = new FilesInFolders(fileExtension, folderName);

        // Act
        boolean result = predicate.test(file);

        // Assert
        assertTrue(result);
    }
}
