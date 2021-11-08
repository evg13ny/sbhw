package ru.skillbox;

public class Book {
    private final String title;
    private final String author;
    private final int pages;
    private final String isbn;

    public Book(String title, String author, int pages, String isbn) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }
}
