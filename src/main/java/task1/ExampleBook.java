package task1;

public class ExampleBook {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("Java for beginner");
        book1.setAuthor("Ivan Ivanov");
        book1.setYear(2025);
        book1.setPrice(29.99);

        Book book2 = new Book("Java for beginner", "Ivan Ivanov", 2025, 29.99);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book1.equals(book2));
    }
}
