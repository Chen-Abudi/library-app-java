package libapp;

import java.util.ArrayList;

public class LibraryApp {
    private final BookRepository bookRepo = new BookRepository();

    public void searchByIsbn(String isbn) {
        System.out.printf("Searching for books with ISBN %s.\n", isbn);
        Book book = bookRepo.findByIsbn(isbn);

        if (book != null) {
            System.out.printf("1 book found:\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s",
                    book.getTitle(), book.getGenre(), book.getAuthor());
        }
        else {
            System.out.println("0 books found.");
        }

        System.out.print("\n\n");
    }

    public void searchByTitle(String keyword) {
        System.out.printf("Searching for books with '%s' in the title...\n", keyword);

        ArrayList<Book> books = bookRepo.findByTitle(keyword);
        System.out.printf("%s books found%s\n", books.size(), !books.isEmpty() ? ":" : ".");

        for (Book book : books) {
            System.out.printf("\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n\t---\n",
                    book.getTitle(), book.getGenre(), book.getAuthor());
        }
        System.out.println();
    }

    public void checkOutBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);

        if (book != null) {
            if (book.checkOut()) {
                System.out.println("Check out SUCCESSFUL: ");
                System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n",
                        book.getIsbn(), book.getTitle(), book.getAuthor());
            }
            else {
                System.out.println("Check out FAILED: ");
                System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n",
                        book.getIsbn(), book.getTitle(), book.getAuthor());
                System.out.println("Reason: More books checked out than recorded quantity.");
            }
        }
        else {
            System.out.println("Failed to check out book.\n");
            System.out.printf("Reason: There is no book with ISBN %s on record.\n", isbn);
        }
        System.out.println();
    }

    public void checkInBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);

        if (book != null) {
            book.checkOut();
            System.out.println("Book checked in successfully:");
            System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n",
                    book.getIsbn(), book.getTitle(), book.getAuthor());
        }
        else {
            System.out.println("Failed to check out book.\n");
            System.out.printf("Reason: There is no book with ISBN %s on record.\n", isbn);
        }
        System.out.println();
    }
}
