package com.ra.hn_k24_cntt2_leducanh_7.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoomCreateDTO {

    @NotBlank(message = "roomNumber không được để trống")
    private String roomNumber;

    @NotBlank(message = "Roomtype không được để trống")
    private String Roomtype;

    @NotNull(message = "Price không được để trống")
    @Min(value = 1, message = "Price phải lớn hơn 0")
    private double pricePerNight;

    public String getRoomType() {
            return null;
    }
}