package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query(value="select * from room where room_type_id = ?1",nativeQuery=true)
	public List<Room> findAll(int keyword);
}
