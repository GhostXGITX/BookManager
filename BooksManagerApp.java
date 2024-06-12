import Button.ButtonAction;
import Library.AllBooksList;
import Library.Book;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BooksManagerApp extends Application {

    private ListView<Book> bookListView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Books Manager");

        bookListView = new ListView<>();
        bookListView.setItems(AllBooksList.getBooks());
        bookListView.setMinWidth(470);
        
        
        TextField searchField = new TextField("Search Field");

        Label sortLabel = new Label("Sort Book by:");

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> ButtonAction.searchResult(searchField, bookListView));

        Button addBook = new Button("Add Book");
        addBook.setOnAction(e -> ButtonAction.addBook());
        
        Button deleteButton = new Button("Delete Book");
        deleteButton.setOnAction(e -> ButtonAction.deleteButton(bookListView));

        Button sortTitle = new Button("Title");
        sortTitle.setOnAction(e -> ButtonAction.sortTitle(bookListView));

        Button sortAuthor = new Button("Author");
        sortAuthor.setOnAction(e -> ButtonAction.sortAuthor(bookListView));

        Button sortPublicityYear = new Button("Publicity Year");
        sortPublicityYear.setOnAction(e -> ButtonAction.sortPublicityYear(bookListView));

        Button sortGenre = new Button("Genre");
        sortGenre.setOnAction(e -> ButtonAction.sortGenre(bookListView));


        //Layout
        HBox hBox = new HBox(2, searchButton, addBook, deleteButton);
        VBox vBox = new VBox(5, searchField, hBox, sortLabel, sortTitle, sortAuthor, sortPublicityYear, sortGenre);
        HBox hBox2 = new HBox(10, vBox, bookListView);


        Scene scene = new Scene(hBox2,700, 300);  
        primaryStage.setScene(scene);            
        primaryStage.show();                     
    }

    public static void main(String[] args) {
        launch(args);
    }

}


