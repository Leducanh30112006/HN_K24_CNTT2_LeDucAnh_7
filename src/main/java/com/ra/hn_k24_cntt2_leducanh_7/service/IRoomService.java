package com.ra.hn_k24_cntt2_leducanh_7.service;

import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomCreateDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomPatchDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomPutDTO;
import org.springframework.http.ResponseEntity;

public interface IRoomService {

    ResponseEntity<?> getAllRoom(String keyword, int page, int size);

    ResponseEntity<?> addRoom(RoomCreateDTO roomCreateDTO);

    ResponseEntity<?> updateRoom(Long id, RoomPutDTO roomPutDTO);

    ResponseEntity<?> patchRoom(Long id, RoomPatchDTO roomPatchDTO);

    ResponseEntity<?> deleteRoom(Long id);
}