package libapp;

import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book("83471", "The Dead of Night", "Horror", null, "S.K. Eleton"));
        books.add(new Book("25274", "Castles and Crenellations", "Historical", null, "H.P. Anderson"));
        books.add(new Book("51573", "The Knight's Sword", "Fantasy", null, "F.E. Anvil"));
    }

    public Book findByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
