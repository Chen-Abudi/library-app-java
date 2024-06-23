package libapp;

public class Book {
    private final String isbn;
    private final String title;
    private final String genre;
    private final String description;
    private final String author;
    private final int quantity;
    private int numCheckedOut;

    public Book(String isbn, String title, String genre, String description, String author,
                int quantity, int numCheckedOut) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.author = author;
        this.quantity = quantity;
        this.numCheckedOut = numCheckedOut;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNumCheckedOut() {
        return numCheckedOut;
    }

    public boolean checkOut() {
        if (numCheckedOut >= quantity) {
            return false;
        }

        numCheckedOut++;
        return true;
    }

    public boolean checkIn() {
        if (numCheckedOut <= 0) {
            return false;
        }

        numCheckedOut--;
        return true;
    }
}
