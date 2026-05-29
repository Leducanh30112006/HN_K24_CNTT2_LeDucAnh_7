package com.ra.hn_k24_cntt2_leducanh_7.service;



import com.ra.hn_k24_cntt2_leducanh_7.exception.ResourceNotFoundException;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomCreateDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomPatchDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomPutDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.dto.RoomResponseDTO;
import com.ra.hn_k24_cntt2_leducanh_7.model.entity.Room;
import com.ra.hn_k24_cntt2_leducanh_7.model.entity.Status;
import com.ra.hn_k24_cntt2_leducanh_7.repository.IRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements IRoomService {

    private final IRoomRepository roomRepository;

    @Override
    public ResponseEntity<?> getAllRoom(String keyword, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Page<Room> roomPage;
        if (keyword != null && !keyword.trim().isEmpty()) {

            roomPage = roomRepository.findByName(keyword.trim(), pageable);;
        }   else {

            roomPage = roomRepository.findAll(pageable);
        }

        List<RoomResponseDTO> dtos = roomPage.getContent().stream()

                .map(room -> RoomResponseDTO.builder()
                        .id(room.getId())
                        .roomNumber(room.getRoomNumber())
                        .roomType(room.getRoomType())
                        .pricePerNight(room.getPricePerNight())
                        .status(room.getStatus())
                        .is_deleted(room.is_deleted())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<?> addRoom(RoomCreateDTO roomCreateDTO) {
        Room room = Room.builder()
                .roomNumber(roomCreateDTO.getRoomNumber())
                .roomType(roomCreateDTO.getRoomType())
                .pricePerNight(roomCreateDTO.getPricePerNight())
                .status(Status.AVAILABLE)
                .is_deleted(false)
                .build();

        roomRepository.save(room);


        return ResponseEntity.ok("Thêm phòng thành công");
    }

    @Override
    public ResponseEntity<?> updateRoom(Long id, RoomPutDTO roomPutDTO) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng có id: " + id));
        room.setRoomNumber(roomPutDTO.getRoomNumber());
        room.setRoomType(roomPutDTO.getRoomType());
        room.setPricePerNight(roomPutDTO.getPricePerNight());
        room.setStatus(roomPutDTO.getStatus());
        roomRepository.save(room);

        return ResponseEntity.ok("Cập nhật phòng thành công");
    }

    @Override
    public ResponseEntity<?> patchRoom(Long id, RoomPatchDTO roomPatchDTO) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng có id: " + id));
        if (roomPatchDTO.getRoomNumber() != null) {
            room.setRoomNumber(roomPatchDTO.getRoomNumber());
        }
        if (roomPatchDTO.getRoomType() != null) {
            room.setRoomType(roomPatchDTO.getRoomType());
        }
        if (roomPatchDTO.getPricePerNight() != 0) {
            room.setPricePerNight(roomPatchDTO.getPricePerNight());
        }
        if (roomPatchDTO.getStatus() != null) {
            room.setStatus(roomPatchDTO.getStatus());
        }
        roomRepository.save(room);
        return ResponseEntity.ok("Cập nhật phòng thành công");
    }

    @Override
    public ResponseEntity<?> deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng có id: " + id));
        roomRepository.delete(room);
        return ResponseEntity.ok("Xóa phòng thành công");
    }

}