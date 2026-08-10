package task2;

public class ExampleBook {
    public static void main(String[] args) {
        Book book = Book.builder()
                .title("чистый код")
                .author("Роберт Мартин")
                .year(2008)
                .price(35.50)
                .build();
    }
}
