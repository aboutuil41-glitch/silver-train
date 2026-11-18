package com.youcode.carpooling.main.entities;


import com.youcode.carpooling.main.enums.StatutTrajet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @Column(nullable = false) private String departureCity;
    @Column(nullable = false) private String arrivalCity;
    @Column(nullable = false) private LocalDateTime departureDate;
    @Column(nullable = false) private int seatsOffered;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutTrajet statut;
}
