package com.example.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Model.Customer;
import com.example.Model.Room;
import com.example.Repository.BookingRepository;
import com.example.Repository.CustomerRepository;
import com.example.Repository.RoomRepository;
import com.example.Service.BookingService;

@Controller
@SessionAttributes("Booking")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private RoomRepository roomRepo;

	@Autowired
	private BookingService bookingService;

	@ModelAttribute(value = "Customer")
	public Customer customer() {
		return new Customer();
	}

//	Moved to add guest details
	@PostMapping("/bookings/customer")
	public String getCustomerDetails(Model model, @RequestParam("room.roomType.roomNameType") int roomTypeValue,
			@RequestParam("checkIn") LocalDate checkIn, @RequestParam("checkOut") LocalDate checkOut,

			HttpSession session) {

		List<Room> listRoom = roomRepo.findAll(roomTypeValue);

		model.addAttribute("listRoom", listRoom);
		model.addAttribute("roomTypeValue", roomTypeValue);
		model.addAttribute("checkOut", checkOut);
		model.addAttribute("checkIn", checkIn);

		session.setAttribute("listRoom", listRoom);
		session.setAttribute("roomTypeValue", roomTypeValue);
		session.setAttribute("checkIn", checkIn);
		session.setAttribute("checkOut", checkOut);

		System.out.println("check in date is :" + checkIn);
		System.out.println("check out date is :" + checkOut);

		model.addAttribute("Room", new Room());
		model.addAttribute("Customer", new Customer());
		return "booking_form";
	}

//	Move back to dates
	@PostMapping(value = "/bookings/confirmation", params = "back")
	public String fromCustomerToDates(Model model) {
		return "redirect:/";
	}

//	Add customer details and go to summary
	@PostMapping(value = "/bookings/confirmation", params = "next")
	public String postAddGuest(Model model, HttpSession session,

			@RequestParam("name") String cname, @RequestParam("email") String cemail

	) {

		System.out.println("Triggered the postaddguest method");

		session.setAttribute("cname", cname);
		session.setAttribute("cemail", cemail);
//		session.setAttribute("roomPrice", roomPrice);
//		session.setAttribute("totalPrice", totalPrice);
//		session.setAttribute("daysDiff", daysDiff);

		LocalDate checkIn = (LocalDate) session.getAttribute("checkIn");
				
		System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(checkIn));
		
		return "summary";
	}

	/*
	 * Logic for date checking
	 * INPUTS
	 * ------------
	 * start date of input = inputStartDate 
	 * end date of input = inputEndDate
	 * 
	 * EXISTING
	 * --------------
	 * existing start date = existingStartDate 
	 * existing end date = existingEndDate
	 *  
	 * if(inputEndDate < existingStartDate || (inputStartDate > existingEndDate )
	 * {no overlap}
	 * else{overlap}
	 */

	@PostMapping("/bookings/add")
	public String saveBooking(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "pricePerNight") Object roomPrice, @RequestParam(value = "daysDiff") Long daysDiff,
			@RequestParam(value = "totalPrice") float totalPrice, @RequestParam(value = "roomId") int roomId,
			@RequestParam(value = "roomNumber") int roomNumber, @RequestParam(value = "roomType") String roomType

	) {

		System.out.println("value of pricePerNight " + roomPrice);
		System.out.println("value of totalPrice " + totalPrice);
		System.out.println("value of totalNights " + daysDiff);

		String cname = (String) session.getAttribute("cname");
		String cemail = (String) session.getAttribute("cemail");

		Customer customer = new Customer(cname, cemail);

		LocalDate checkIn = (LocalDate) session.getAttribute("checkIn");
		LocalDate checkOut = (LocalDate) session.getAttribute("checkOut");

		System.out.println("triggered the Post Mapping");
		Customer saved = customerRepo.saveAndFlush(customer);
		bookingService.insertFromSummary(checkIn, checkOut, saved, roomId, totalPrice);

		return "redirect:/";
	}

}
