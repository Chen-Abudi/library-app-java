package libapp;

public class LibraryApp {
    private BookRepository bookRepo = new BookRepository();

    public void searchByIsbn(String isbn) {
        System.out.printf("Searching for books with ISBN %s.\n", isbn);
        Book book = bookRepo.findByIsbn(isbn);

        if (book != null) {
            System.out.printf("1 book found:\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s",
                    book.getTitle(), book.getGenre(), book.getAuthor());
        }
        else {
            System.out.printf("0 books found.");
        }

        System.out.print("\n\n");
    }
}
