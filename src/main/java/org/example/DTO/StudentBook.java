package org.example.DTO;

import lombok.*;
import org.example.Enums.Status;

import java.time.LocalDateTime;
@ToString @AllArgsConstructor @NoArgsConstructor
public class StudentBook {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Integer studentId;
    @Getter @Setter
    private String bookId;
    @Getter @Setter
    private LocalDateTime createDate;
    @Getter @Setter
    private Status status;
    @Getter @Setter
    private LocalDateTime returnedDate;
    @Getter @Setter
    private Integer duration;

}
