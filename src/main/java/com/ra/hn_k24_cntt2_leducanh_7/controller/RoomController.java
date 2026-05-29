package com.ra.hn_k24_cntt2_leducanh_7.controller;

import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomCreateDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomPatchDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomPutDTO;
import com.ra.hn_k24_cntt2_leducanh_7.service.IRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService roomService;

    @GetMapping
    public ResponseEntity<?> getAllRooms(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return roomService.getAllRoom(keyword, page, size);
    }

    @PostMapping
    public ResponseEntity<?> addRooms(@Valid @RequestBody RoomCreateDTO roomCreateDTO) {
        return roomService.addRoom(roomCreateDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRooms(@PathVariable Long id,
                                         @Valid @RequestBody RoomPutDTO roomPutDTO) {
        return roomService.updateRoom(id, roomPutDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchRooms(@PathVariable Long id,
                                          @RequestBody RoomPatchDTO roomPatchDTO) {
        return roomService.patchRoom(id, roomPatchDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRooms(@PathVariable Long id) {
        return roomService.deleteRoom(id);
    }
}