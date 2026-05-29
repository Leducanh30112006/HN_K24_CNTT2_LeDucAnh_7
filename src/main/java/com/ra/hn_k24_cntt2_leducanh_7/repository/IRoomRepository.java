package com.ra.hn_k24_cntt2_leducanh_7.repository;



import com.ra.hn_k24_cntt2_leducanh_7.model.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Long> {
    Page<Room> findByName(String roomName, Pageable pageable);

}