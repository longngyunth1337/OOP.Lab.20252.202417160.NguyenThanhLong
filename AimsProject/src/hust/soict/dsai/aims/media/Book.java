package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();
    private String content = "";

    public Book() {
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author already exists: " + authorName);
            return;
        }

        authors.add(authorName);
        System.out.println("Author added: " + authorName);
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author does not exist: " + authorName);
            return;
        }

        authors.remove(authorName);
        System.out.println("Author removed: " + authorName);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentLength() {
        if (content == null || content.trim().isEmpty()) {
            return 0;
        }

        return content.trim().split("\\s+").length;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory()
                + " - " + authors
                + " - content length: " + getContentLength()
                + ": " + getCost() + " $";
    }
}