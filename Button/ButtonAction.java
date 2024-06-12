package Button;

import Library.Book;

import java.util.Comparator;
import java.util.regex.Pattern;

import Library.AllBooksList;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;



public class ButtonAction {

    public static void searchResult(TextField searchField, ListView<Book> bookListView) {
        String searchTerm = searchField.getText();

        ObservableList<Book> books = AllBooksList.getBooks();
        ObservableList<Book> filteredResult = FXCollections.observableArrayList();

        for (Book book : books) {
            if (Pattern.compile(Pattern.quote(searchTerm),Pattern.CASE_INSENSITIVE).matcher(book.toString()).find()) {
                filteredResult.add(book);
            }
        }
        bookListView.setItems(filteredResult);
    }

    public static void addBook() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Book");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter book title:");
        dialog.showAndWait().ifPresent(title -> {
            TextInputDialog authorDialog = new TextInputDialog();
            authorDialog.setTitle("Add Book");
            authorDialog.setHeaderText(null);
            authorDialog.setContentText("Enter book author:");
            authorDialog.showAndWait().ifPresent(author -> {
                TextInputDialog yearDialog = new TextInputDialog();
                yearDialog.setTitle("Add Book");
                yearDialog.setHeaderText(null);
                yearDialog.setContentText("Enter publicity year:");
                yearDialog.showAndWait().ifPresent(year -> {
                    int publicityYear;
                    try{
                        publicityYear = Integer.parseInt(year);
                    } catch (NumberFormatException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid year format");
                        alert.showAndWait();
                        return;
                    }
                    TextInputDialog genreDialog = new TextInputDialog();
                    genreDialog.setTitle("Add Book");
                    genreDialog.setHeaderText(null);
                    genreDialog.setContentText("Enter book genre:");
                    genreDialog.showAndWait().ifPresent(genre -> {
                        AllBooksList.addBook(new Book(title, author, publicityYear, genre));
                    });
                });
            }); 
        });
    }
    
    public static void deleteButton(ListView<Book> bookListView) {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            AllBooksList.deleteBook(selectedBook);
            ObservableList<Book> items = bookListView.getItems();
            items.remove(selectedBook);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("No book selected");
            alert.showAndWait();
        }

    }

    public static void sortTitle(ListView<Book> bookListView) {
        Comparator<Book> comparator;
        comparator = Comparator.comparing(Book::getTitle);
        ObservableList<Book> items = bookListView.getItems();
        FXCollections.sort(items, comparator);
    }

    public static void sortAuthor(ListView<Book> bookListView) {
        Comparator<Book> comparator;
        comparator = Comparator.comparing(Book::getAuthor);
        ObservableList<Book> items = bookListView.getItems();
        FXCollections.sort(items, comparator);
    }

    public static void sortPublicityYear(ListView<Book> bookListView) {
        Comparator<Book> comparator;
        comparator = Comparator.comparing(Book::getPublicityYear);
        ObservableList<Book> items = bookListView.getItems();
        FXCollections.sort(items, comparator.reversed());
    }

    public static void sortGenre(ListView<Book> bookListView) {
        Comparator<Book> comparator;
        comparator = Comparator.comparing(Book::getGenre);
        ObservableList<Book> items = bookListView.getItems();
        FXCollections.sort(items, comparator);
    }
}
