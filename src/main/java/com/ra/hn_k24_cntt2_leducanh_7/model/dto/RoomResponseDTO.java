package com.ra.hn_k24_cntt2_leducanh_7.model.dto;

import com.ra.hn_k24_cntt2_leducanh_7.model.entity.Status;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoomResponseDTO {
    private Long id;
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private Status status;
    private boolean is_deleted = false;
}
