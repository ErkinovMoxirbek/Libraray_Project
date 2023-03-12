package org.example.DTO;

import lombok.*;
import org.example.Enums.Role;

import java.time.LocalDateTime;
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private String phone;
    @Getter @Setter
    private String pswd;
    @Getter @Setter
    private LocalDateTime createdDate;
    @Getter @Setter
    private boolean visible;
    @Getter @Setter
    private Role role ;
}
