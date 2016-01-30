package com.mikadosolutions.training.springmvc.controllers;
 import com.mikadosolutions.training.springmvc.bean.Room;
import com.mikadosolutions.training.springmvc.bean.RoomMasterDAO;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
//import javax.validation.valid;
import javax.servlet.http.HttpSession;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;


@Controller
@RequestMapping("/")
public class RoomController
{
@Autowired
RoomMasterDAO dao;

@RequestMapping("general/getAvailableRooms")
	public ModelAndView getAvailableRooms ()
	{
Collection <Room> rooms = dao.getAvailableRooms();
ModelAndView mv = new ModelAndView("roomList");//passing jsp file
System.out.println(rooms);
mv.addObject("rooms", rooms); 
mv.addObject("status", "A");
return mv;
	}
@RequestMapping("secure/getOccupiedRooms")
	public ModelAndView getOccupiedRooms()
	{
Collection <Room> rooms = dao.getOccupiedRooms();
ModelAndView mv = new ModelAndView("roomList");//passing jsp file
System.out.println(rooms);
mv.addObject("rooms", rooms); 
mv.addObject("status", "O");
return mv;
	}
@RequestMapping("/secure/allocateRooms")
	public String allocateRoom(Room room)
	{
	dao.allocateRoom(room);
	return "roomAllocated";
	}
@RequestMapping("/secure/deallocateRooms")
	public String deallocateRoom(Room room)
	{
	dao.deallocateRoom(room);
	return "roomDeallocated";
	}


};
