package com.youcode.carpooling.main.entities;


import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String lastName;
    @Column(nullable = false) private String firstName;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String phone;
}
