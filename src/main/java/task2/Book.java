package task2;

import lombok.Builder;

@Builder
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;
}
