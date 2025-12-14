// BookController.java
package controller;

import java.util.List;
import model.Book;
import model.BookModel;
import view.LibraryView;

public class BookController {
    private final BookModel model;
    private final LibraryView view;
    
    public BookController(BookModel model, LibraryView view) {
        this.model = model;
        this.view = view;
        
        // Connect view buttons to controller actions
        this.view.addAddBookListener(e -> addBook());
        this.view.addDeleteBookListener(e -> deleteBook());
        this.view.addIssueBookListener(e -> issueBook());
        this.view.addReturnBookListener(e -> returnBook());
        this.view.addSearchListener(e -> searchBooks());
        this.view.addRefreshListener(e -> refreshBookList());
        
        // Initial load
        refreshBookList();
    }
    
    private void addBook() {
        String title = view.getTitleInput();
        String author = view.getAuthorInput();
        String isbn = view.getIsbnInput();
        
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            view.showMessage("Please fill all fields!");
            return;
        }
        
        Book book = new Book(title, author, isbn);
        model.addBook(book);
        view.clearInputs();
        refreshBookList();
        view.showMessage("Book added successfully!");
    }
    
    private void deleteBook() {
        int selectedIndex = view.getSelectedBookIndex();
        if (selectedIndex == -1) {
            view.showMessage("Please select a book to delete!");
            return;
        }
        
        model.deleteBook(selectedIndex);
        refreshBookList();
        view.showMessage("Book deleted successfully!");
    }
    
    private void issueBook() {
        int selectedIndex = view.getSelectedBookIndex();
        if (selectedIndex == -1) {
            view.showMessage("Please select a book to issue!");
            return;
        }
        
        Book book = model.getBook(selectedIndex);
        if (book.isIssued()) {
            view.showMessage("Book is already issued!");
            return;
        }
        
        model.issueBook(selectedIndex);
        refreshBookList();
        view.showMessage("Book issued successfully!");
    }
    
    private void returnBook() {
        int selectedIndex = view.getSelectedBookIndex();
        if (selectedIndex == -1) {
            view.showMessage("Please select a book to return!");
            return;
        }
        
        Book book = model.getBook(selectedIndex);
        if (!book.isIssued()) {
            view.showMessage("Book is not issued!");
            return;
        }
        
        model.returnBook(selectedIndex);
        refreshBookList();
        view.showMessage("Book returned successfully!");
    }
    
    private void searchBooks() {
        String keyword = view.getSearchInput();
        if (keyword.isEmpty()) {
            refreshBookList();
            return;
        }
        
        List<Book> results = model.searchBooks(keyword);
        view.updateBookList(results);
    }
    
    private void refreshBookList() {
        view.updateBookList(model.getAllBooks());
    }
}
