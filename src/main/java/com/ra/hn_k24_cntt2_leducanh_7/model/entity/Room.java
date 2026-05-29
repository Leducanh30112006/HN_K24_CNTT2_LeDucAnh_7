package com.ra.hn_k24_cntt2_leducanh_7.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean is_deleted = false;

}
