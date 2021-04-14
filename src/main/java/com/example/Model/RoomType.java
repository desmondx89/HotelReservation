package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomType {

	@Id
	private int roomTypeId;

	private String roomNameType;

	private float roomPrice;

	

	public RoomType(int roomTypeId, String roomNameType, float roomPrice) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomNameType = roomNameType;
		this.roomPrice = roomPrice;
	}

	public RoomType() {
		
	}

	/**
	 * @return the roomTypeId
	 */
	public int getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param roomTypeId the roomTypeId to set
	 */
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	/**
	 * @return the roomNameType
	 */
	public String getRoomNameType() {
		return roomNameType;
	}

	/**
	 * @param roomNameType the roomNameType to set
	 */
	public void setRoomNameType(String roomNameType) {
		this.roomNameType = roomNameType;
	}

	/**
	 * @return the roomPrice
	 */
	public float getRoomPrice() {
		return roomPrice;
	}

	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(float roomPrice) {
		this.roomPrice = roomPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomNameType == null) ? 0 : roomNameType.hashCode());
		result = prime * result + Float.floatToIntBits(roomPrice);
		result = prime * result + roomTypeId;
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
		RoomType other = (RoomType) obj;
		if (roomNameType == null) {
			if (other.roomNameType != null)
				return false;
		} else if (!roomNameType.equals(other.roomNameType))
			return false;
		if (Float.floatToIntBits(roomPrice) != Float.floatToIntBits(other.roomPrice))
			return false;
		if (roomTypeId != other.roomTypeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoomType [roomTypeId=" + roomTypeId + ", roomNameType=" + roomNameType + ", roomPrice=" + roomPrice
				+ "]";
	}

}
