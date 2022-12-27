package com.webapp.demo.CheckInOutController;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.CheckInOut.CheckInOut;
import com.webapp.demo.CheckInOutDao.CheckInOutDao;

@RestController
public class CheckInOutController {
	@Autowired
	CheckInOutDao dao;
	@RequestMapping(path="/checkIn")
	@ResponseBody
	public void CheckIn(@RequestParam String name,CheckInOut obj){
		obj.setLogType("in");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		obj.setDate(date.toString());
		obj.setTime(time.toString());
		obj.setId(name+time.toString());
		dao.save(obj);
		System.out.println("checkIn"+ name);
		
	}
	
	@RequestMapping(path="/checkOut")
	@ResponseBody
	public void CheckOut(@RequestParam String name,CheckInOut obj){
		obj.setLogType("out");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		obj.setDate(date.toString());
		obj.setTime(time.toString());
		obj.setId(name+time.toString());
		dao.save(obj);
		System.out.println("checkout"+ name);
		
	}
	
	@RequestMapping(path="/getLog")
	@ResponseBody
	public List<CheckInOut> GetLogByDate(@RequestParam String date,CheckInOut obj){
		
		
		System.out.println("getLog"+ date);
		return dao.findAllByDate(date);
	
}
	@RequestMapping(path="/getAllLog")
	@ResponseBody
	public List<CheckInOut> GetAllLog(){
		return dao.findAll();
	
}
	
}