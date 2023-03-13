package org.example.DTO;

import lombok.*;
import org.example.Enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

@ToString @AllArgsConstructor @NoArgsConstructor
public class StudentBook {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Integer studentId;
    @Getter @Setter
    private Integer bookId;
    @Getter @Setter
    private LocalDateTime createdDate;
    @Getter @Setter
    private Status status;
    @Getter @Setter
    private LocalDateTime returnedDate;
    @Getter @Setter
    private LocalDateTime duration;

}
