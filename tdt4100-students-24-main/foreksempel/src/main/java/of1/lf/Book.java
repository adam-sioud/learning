package of1.lf;

public class Book {

    String title;
    int numPages;

    Book(int numPages, String title) {
        this.numPages = numPages;
        this.title = title;
    }

    String getTitle() {
        return this.title;
    }

    void setTitle(String newTitle) {
        this.title = newTitle;
    }
 
    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String toString() {
        return this.getTitle() + " (" + this.getNumPages() + " pages)";
    }

    public static void main(String[] args) {
        Book book = new Book(100, "Big Java");
        Book book2 = new Book(1234, "Introduction to OOP");
        
        System.out.println("The book 1 \"" + book.getTitle() + "\" has " +
        book.getNumPages() + " pages.");

        System.out.println("The book 2 \"" + book2.getTitle() + "\" has " +
        book2.getNumPages() + " pages.");
        
        book.setNumPages(718);
        book.setTitle("Introduction to Algorithms");
        System.out.println("The book \"" + book.getTitle() + "\" has " +
        book.getNumPages() + " pages.");
        
        System.out.println(book);
        System.out.println(book2);
    }
}
