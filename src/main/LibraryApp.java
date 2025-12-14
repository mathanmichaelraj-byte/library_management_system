// LibraryApp.java
package main;

import controller.BookController;
import javax.swing.SwingUtilities;
import model.BookModel;
import view.LibraryView;

public class LibraryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create MVC components
            BookModel model = new BookModel();
            LibraryView view = new LibraryView();
            BookController controller = new BookController(model, view);
            
            // Show the application
            view.setVisible(true);
        });
    }
}