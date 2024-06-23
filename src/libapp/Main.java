package libapp;

public class Main {
    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.searchByIsbn("51573");
        app.searchByIsbn("29716");
        app.searchByIsbn("83471");
    }
}