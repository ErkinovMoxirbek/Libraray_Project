package org.example.DTO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString@AllArgsConstructor@NoArgsConstructor
@Getter @Setter
@Entity
public class StudentAppeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer student_id;
    private String appeal_text;
    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
