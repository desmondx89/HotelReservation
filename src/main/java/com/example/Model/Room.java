package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int roomId;

	private String roomNumber;

	@JoinColumn(name = "roomTypeId")
	@ManyToOne
	private RoomType roomType;

	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
		
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the roomType
	 */
	public RoomType getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Room(int roomId, String roomNumber, RoomType roomType) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}

	public Room() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roomId;
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomId != other.roomId)
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomType=" + roomType;
	}

	
}
