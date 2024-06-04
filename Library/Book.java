package Library;

public class Book {
    private String title;
    private String author;
    private int publicityYear;
    private String genre;

    public Book(String title, String author, int publicityYear, String genre) {
        this.title = title;
        this.author = author;
        this.publicityYear = publicityYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicityYear() {
        return publicityYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicityYear + "), Genre:" + genre;
    }

}
