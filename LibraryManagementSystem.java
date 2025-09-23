import java.io.*;
import java.util.*;
class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private boolean available;
    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Author: %s | Available: %s",
                id, title, author, available ? "Yes" : "No");
    }
}

class Library {
    private List<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }
    public void deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) ||
                    book.getAuthor().equalsIgnoreCase(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching book found.");
        }
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
            System.out.println("Books saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            books = (List<Book>) ois.readObject();
            System.out.println("Books loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved file found. Starting fresh.");
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        String filename = "library.txt";
        library.loadFromFile(filename);
        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author, true));
                    break;
                case 2:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    library.deleteBook(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Title/Author to search: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    library.saveToFile(filename);
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

