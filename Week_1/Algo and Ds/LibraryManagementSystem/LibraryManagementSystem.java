import java.util.Arrays;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("2", "1984", "George Orwell"),
            new Book("3", "To Kill a Mockingbird", "Harper Lee"),
            new Book("4", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("5", "The Lord of the Rings", "J.R.R. Tolkien")
        };

        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        System.out.println("Linear Search Result: " + linearSearch(books, "1984"));
        System.out.println("Binary Search Result: " + binarySearch(books, "1984"));

        System.out.println("Linear Search Result (Not Found): " + linearSearch(books, "Moby Dick"));
        System.out.println("Binary Search Result (Not Found): " + binarySearch(books, "Moby Dick"));
    }
}

