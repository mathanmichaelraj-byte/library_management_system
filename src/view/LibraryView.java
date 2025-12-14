package view;

import model.Book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class LibraryView extends JFrame {
    // Input fields
    private JTextField titleField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField searchField;
    
    // Buttons
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton issueBtn;
    private JButton returnBtn;
    private JButton searchBtn;
    private JButton refreshBtn;
    
    // Book list
    private DefaultListModel<Book> listModel;
    private JList<Book> bookList;
    
    // Status label
    private JLabel statusLabel;
    
    public LibraryView() {
        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        
        // Top Panel - Add Book
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        topPanel.setBorder(BorderFactory.createTitledBorder("Add New Book"));
        
        topPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        topPanel.add(titleField);
        
        topPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        topPanel.add(authorField);
        
        topPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        topPanel.add(isbnField);
        
        addBtn = new JButton("Add Book");
        addBtn.setBackground(new Color(46, 204, 113));
        addBtn.setForeground(Color.WHITE);
        topPanel.add(new JLabel());
        topPanel.add(addBtn);
        
        add(topPanel, BorderLayout.NORTH);
        
        // Center Panel - Book List
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Books"));
        
        listModel = new DefaultListModel<>();
        bookList = new JList<>(listModel);
        bookList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookList);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(centerPanel, BorderLayout.CENTER);
        
        // Top Search Panel
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Search Books"),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        JPanel searchInputPanel = new JPanel(new BorderLayout(10, 10));
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        
        JPanel searchButtonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(241, 196, 15));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        refreshBtn = new JButton("Refresh List");
        refreshBtn.setBackground(new Color(149, 165, 166));
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        searchButtonPanel.add(searchBtn);
        searchButtonPanel.add(refreshBtn);
        
        searchInputPanel.add(new JLabel("Search by Title or Author:"), BorderLayout.NORTH);
        searchInputPanel.add(searchField, BorderLayout.CENTER);
        searchInputPanel.add(searchButtonPanel, BorderLayout.SOUTH);
        
        searchPanel.add(searchInputPanel);
        
        // Insert search panel between top and center
        JPanel middlePanel = new JPanel(new BorderLayout(10, 10));
        middlePanel.add(searchPanel, BorderLayout.NORTH);
        middlePanel.add(centerPanel, BorderLayout.CENTER);
        
        add(middlePanel, BorderLayout.CENTER);
        
        // Right Panel - Actions
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 5, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        deleteBtn = new JButton("Delete Book");
        deleteBtn.setBackground(new Color(231, 76, 60));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        issueBtn = new JButton("Issue Book");
        issueBtn.setBackground(new Color(52, 152, 219));
        issueBtn.setForeground(Color.WHITE);
        issueBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        returnBtn = new JButton("Return Book");
        returnBtn.setBackground(new Color(155, 89, 182));
        returnBtn.setForeground(Color.WHITE);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        rightPanel.add(deleteBtn);
        rightPanel.add(issueBtn);
        rightPanel.add(returnBtn);
        
        add(rightPanel, BorderLayout.EAST);
        
        // Bottom Panel - Status
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel("Ready");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(statusLabel);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    // Methods to get input values
    public String getTitleInput() { return titleField.getText().trim(); }
    public String getAuthorInput() { return authorField.getText().trim(); }
    public String getIsbnInput() { return isbnField.getText().trim(); }
    public String getSearchInput() { return searchField.getText().trim(); }
    
    public void clearInputs() {
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
    }
    
    public int getSelectedBookIndex() {
        return bookList.getSelectedIndex();
    }
    
    public void updateBookList(List<Book> books) {
        listModel.clear();
        for (Book book : books) {
            listModel.addElement(book);
        }
    }
    
    public void showMessage(String message) {
        statusLabel.setText(message);
        JOptionPane.showMessageDialog(this, message);
    }
    
    // Add listeners
    public void addAddBookListener(ActionListener listener) {
        addBtn.addActionListener(listener);
    }
    
    public void addDeleteBookListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
    
    public void addIssueBookListener(ActionListener listener) {
        issueBtn.addActionListener(listener);
    }
    
    public void addReturnBookListener(ActionListener listener) {
        returnBtn.addActionListener(listener);
    }
    
    public void addSearchListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }
    
    public void addRefreshListener(ActionListener listener) {
        refreshBtn.addActionListener(listener);
    }
}
