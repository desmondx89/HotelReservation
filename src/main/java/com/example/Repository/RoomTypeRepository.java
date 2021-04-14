package com.example.Repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

	@Query("SELECT d FROM RoomType d WHERE " + " CONCAT(d.roomTypeId, d.roomNameType, d.roomPrice)" + " LIKE %?1%")
	public Page<RoomType> findAll(String keyword, Pageable pageable);
}
