package org.example.DTO;

import lombok.*;

import java.time.LocalDateTime;
@ToString@AllArgsConstructor@NoArgsConstructor
public class Book {
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private String title;
    @Getter@Setter
    private String author;
    @Getter@Setter
    private LocalDateTime publishYear;
    @Getter@Setter
    private Double amount;
    @Getter@Setter
    private boolean visible;

}
