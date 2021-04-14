package com.example.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room room;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkIn;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkOut;

	private float totalCost;

	public Booking() {
		super();
	}

	public Booking(int bookingId, Customer customer, Room room, LocalDate checkIn, LocalDate checkOut,
			float totalCost) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalCost = totalCost;
	}

	public Booking(Room room, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Booking(Customer customer, Room room, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.customer = customer;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the customer
	 */
	public Customer getUser() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setUser(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the checkIn
	 */
	public LocalDate getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public LocalDate getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public float getTotalCost(Temporal checkIn, Temporal checkOut, Room room) {
		if (checkIn == null || checkOut == null) {
			return 0;
		} else {
			totalCost = TotalDays(checkIn, checkOut) * room.getRoomType().getRoomPrice();
		}
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public long TotalDays(Temporal checkIn, Temporal checkOut) {
		if (checkIn == null || checkOut == null) {
			return 0;
		} else if (checkIn.equals(checkOut)) {
			return 1;
		} else {
			return ChronoUnit.DAYS.between(checkIn, checkOut)+1;
		}
	}

}
