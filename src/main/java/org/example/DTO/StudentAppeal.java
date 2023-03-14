package org.example.DTO;

import lombok.*;

import java.time.LocalDateTime;

@ToString@AllArgsConstructor@NoArgsConstructor
public class StudentAppeal {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Integer student_id;
    @Getter @Setter
    private String appeal_text;
    @Getter @Setter
    private LocalDateTime createdDate;
}
