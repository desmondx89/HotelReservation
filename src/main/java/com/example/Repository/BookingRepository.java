package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
//	@Query("SELECT e FROM Booking e WHERE " 
//			+ " CONCAT(e.bookingId, e.roomType.roomNameType, e.user.name, e.totalCost, e.checkIn, e.checkOut)"
//			+ " LIKE %?1%")
//	public Page<Booking> findAll(String keyword, Pageable pageable);

//	@Query("INSERT INTO Booking (checkIn, checkOut, customer, totalCost) values (:checkIn,:checkOut,:customer,:totalCost")
//	public void insert(LocalDate checkIn, LocalDate checkOut, Customer
//			customer, float totalCost);

	@Query("SELECT COALESCE(MAX(bookingId),0) FROM Booking")
	public int maxValue();
}
