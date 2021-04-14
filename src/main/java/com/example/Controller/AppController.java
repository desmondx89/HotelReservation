package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Model.Booking;
import com.example.Model.RoomType;
import com.example.Repository.RoomTypeRepository;

@Controller
@SessionAttributes("Booking")
public class AppController {

	@Autowired
	private RoomTypeRepository roomTypeRepo;
	
	
		
	@ModelAttribute("Booking")
	public Booking bookings() {
	    return new Booking();
	}
	
	@GetMapping("/")
	public String home(Model model) {
				
		List<RoomType> listRoomType = roomTypeRepo.findAll();
				
		model.addAttribute("listRoomType", listRoomType);
		model.addAttribute("Booking",new Booking());
		
		return "index";
	}

	
		
}
