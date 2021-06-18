package Model;

public class Book {

    private int bookId;
    private String title;
    private String category;
    private String author;
    private String award;
    private float rating;
    private int year;
    private int numberOfPages;
    private String shortDescription;

    public Book(int bookId, String title, String category, String author, String award, float rating, int year, int numberOfPages, String shortDescription) {
        this.bookId = bookId;
        this.title = title;
        this.category = category;
        this.author = author;
        this.award = award;
        this.rating = rating;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.shortDescription = shortDescription;
    }

    public Book() {
    }

    public Book(String[] data) {
        this.bookId = Integer.parseInt(data[0]);
        this.title = data[1];
        this.category = data[2];
        this.author = data[3];
        this.award = data[4];
        this.rating = Float.parseFloat(data[5]);
        this.year = Integer.parseInt(data[6]);
        this.numberOfPages = Integer.parseInt(data[7]);
        this.shortDescription = data[8];
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return bookId + "," + title + "," + category + "," + author + "," + award
                + "," + rating + "," + year + "," + numberOfPages + "," + shortDescription;
    }

    public Object[] toObject() {
        return new Object[]{bookId, title, category, author, award, rating, year, numberOfPages, shortDescription};
    }

}
