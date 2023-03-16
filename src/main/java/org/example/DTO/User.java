package org.example.DTO;

import lombok.*;
import org.example.Enums.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String pswd;
    @Column (name = "created_date")
    private LocalDateTime createdDate;
    private boolean visible;
    private Role role ;
}
