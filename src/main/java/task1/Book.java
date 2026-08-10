package task1;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
   private String title;
   private String author;
   private int year;
   private double price;
}
