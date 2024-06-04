package Library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllBooksList {

    private static ObservableList<Book> books = FXCollections.observableArrayList();

        static {
            books.addAll(
                new Book("Start a Fire", "P.S.Herytiera", 2022, "Romance"),//1
                new Book("A Court of Throns and Roses", "Sarah.J.Maas", 2024, "Romance"),//2
                new Book("Assassing's Creed: Renesans", "Anton Gill",2009, "Historical Fiction"),//3
                new Book("Black City", "Marta Knopik", 2020, "Fiction"),//4
                new Book("Outsider", "Stephen King", 2020, "Criminal"),//5
                new Book("Holly", "Stephen King", 2023, "Criminal"),//6
                new Book("Hobbit", "J.R.R.tolkien", 1937, "Fantasy"),//7
                new Book("Star Wars Dartch Vader", "Pak Greg lenco Raffaele", 2020, "Fantasy"),//8
                new Book("Certificated ISTQB Tester", "Lucjan Stapp, Michael Pilaeten", 2024, "Guide"),//9
                new Book("The Adventure of Sherlock Holmes", "Arthur Conan Doyle", 2003, "Adventure"),//10
                new Book("The Witcher Blood of Elves", "Andrzej Sapkowski", 2003, "Fantasy"),//11
                new Book("The Shadow Of The Gods", "John Gwynne", 2007, "Fantasy"),//12
                new Book("Harry Potter and the Goblet of Fire", "J.K.Rowling", 2000, "Fantasy"),//13
                new Book("IT", "Stephen King", 1986, "Horror"),//14
                new Book("Notebook", "Tomasz Lipko", 2015, "Criminal"),//15
                new Book("Blackout", "Marc Elsberg", 2015, "Criminal"),//16
                new Book("Game of Throne", "George R.R.Martin", 1996, "Fantasy"),//17
                new Book("Glass House", "Eve Chase", 2022, "Thriller"),//18
                new Book("Fourth Wing", "Rebecca Yarros", 2023, "Fantasy"),//19
                new Book("Yellowface", "Rebecca F.Kuang", 2023, "Thriller"),//20
                new Book("Throne of glass", "Sarah.J.Maas", 2019, "Fantasy"),//21
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction"),//22
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction"),//23
                new Book("1984", "George Orwell", 1949, "Science Fiction"),//24
                new Book("Pride and Prejudice", "Jane Austen", 1813, "Romance")//25
            );
        }
    

    public static ObservableList<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void deleteBook(Book book) {
        books.remove(book);
    }

}