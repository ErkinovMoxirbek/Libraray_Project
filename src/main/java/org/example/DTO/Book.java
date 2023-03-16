package org.example.DTO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@ToString@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column (name = "publish_year")
    private LocalDateTime publishYear;
    private Integer amount;
    private boolean visible;

}
