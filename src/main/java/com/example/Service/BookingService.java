package com.example.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Booking;
import com.example.Model.Customer;
import com.example.Model.Room;
import com.example.Repository.BookingRepository;
import com.example.Repository.RoomRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private RoomRepository roomRepo;
		

	public void save(Booking booking) {
		bookingRepo.save(booking);
	}

	public Booking get(int bookingId) {
		return bookingRepo.findById(bookingId).get();
	}

	public void delete(int bookingId) {
		bookingRepo.deleteById(bookingId);
	}

	public void insertFromSummary(LocalDate checkIn, LocalDate checkOut, Customer customer, int roomId, float totalCost) {
		Booking booking = new Booking();
		booking.setUser(customer);
		booking.setCheckIn(checkIn);
		booking.setCheckOut(checkOut);
		booking.setTotalCost(totalCost);
		Room room = roomRepo.findById(roomId).get();
		booking.setRoom(room);
		save(booking);
//		bookingRepo.save(booking);
	}
	
}
