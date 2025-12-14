// Book.java
package model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isIssued;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isIssued = false;
    }
    
    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }
    
    @Override
    public String toString() {
        return title + " by " + author + " [" + (isIssued ? "ISSUED" : "AVAILABLE") + "]";
    }
}
