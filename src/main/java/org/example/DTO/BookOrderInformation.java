package org.example.DTO;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class BookOrderInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sb_id;
    private Integer book_id;
    private String book_title;
    private String book_author;
    private LocalDateTime taken_time;
    private LocalDateTime returned_time;
    private String student_name;
    private String student_surname;
    private String student_phone;


}
