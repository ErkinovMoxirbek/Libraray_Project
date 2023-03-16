package org.example.DTO;

import lombok.*;
import org.example.Enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@ToString @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class StudentBook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "student_id")
    private Integer studentId;
    @Column(name = "book_id")
    private Integer bookId;
    @Column (name = "created_date")
    private LocalDateTime createdDate;
    private Status status;
    @Column (name = "returned_date")
    private LocalDateTime returnedDate;
    private LocalDateTime duration;

}
