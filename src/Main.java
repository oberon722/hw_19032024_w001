import java.util.*;

record Book<T>(T title) {}

record LibraryCard<K, V>(K cardNumber, V bookInfo) {}

class Library {
    private final Map<LibraryCard<?, ?>, Boolean> issuedBooks;

    public Library() {
        issuedBooks = new HashMap<>();
    }

    public <K, V> void addBook(LibraryCard<K, V> card) {
        issuedBooks.put(card, false);
    }

    public void issueBook(LibraryCard<?, ?> card) {
        if (issuedBooks.containsKey(card)) {
            issuedBooks.put(card, true);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void displayIssuedBooks() {
        System.out.println("Issued Books:");
        for (Map.Entry<LibraryCard<?, ?>, Boolean> entry : issuedBooks.entrySet()) {
            if (entry.getValue()) {
                LibraryCard<?, ?> card = entry.getKey();
                System.out.println("Card Number: " + card.cardNumber() + ", Book Info: " + card.bookInfo());
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        Book<String> book1 = new Book<>("Java Programming");
        LibraryCard<Integer, String> card1 = new LibraryCard<>(1234, book1.title());

        Book<String> book2 = new Book<>("Data Structures and Algorithms");
        LibraryCard<Integer, String> card2 = new LibraryCard<>(5678, book2.title());

        library.addBook(card1);
        library.addBook(card2);

        library.issueBook(card1);

        library.displayIssuedBooks();
    }
} 