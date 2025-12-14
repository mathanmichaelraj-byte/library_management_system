// BookModel.java
package model;

import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private final List<Book> books;
    
    public BookModel() {
        books = new ArrayList<>();
        // Add some sample books
        books.add(new Book("Java Programming", "Herbert Schildt", "978-0071808552"));
        books.add(new Book("Clean Code", "Robert Martin", "978-0132350884"));
        books.add(new Book("Design Patterns", "Gang of Four", "978-0201633610"));
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void deleteBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }
    
    public Book getBook(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }
    
    public List<Book> getAllBooks() {
        return books;
    }
    
    public void issueBook(int index) {
        Book book = getBook(index);
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
        }
    }
    
    public void returnBook(int index) {
        Book book = getBook(index);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
        }
    }
    
    public List<Book> searchBooks(String keyword) {
        List<Book> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(lowerKeyword) ||
                book.getAuthor().toLowerCase().contains(lowerKeyword)) {
                results.add(book);
            }
        }
        return results;
    }
}
