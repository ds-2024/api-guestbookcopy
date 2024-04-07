package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

//@Controller
@RestController
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//삭제
	//@ResponseBody
	@DeleteMapping(value="/api/guests/{no}")
	public String remove(@RequestBody GuestbookVo guestbookVo, 
						 @PathVariable(value="no") int no) { //{no}는 동적으로 변하는 값 => PathVariable
		System.out.println("GuestbookController.remove()");
		
		guestbookVo.setNo(no);
		System.out.println(guestbookVo);
		
		int count = guestbookService.exeRemove(guestbookVo);
		
		String result = "{\"count\": "+ count +"}";
		System.out.println(result);
		return result;
	}
	
	//저장 + 1개 가져오기
	//@ResponseBody
	@PostMapping(value="/api/guests")
	public GuestbookVo add(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()"); 
		System.out.println(guestbookVo);
		 
		GuestbookVo guestVo = guestbookService.exeAddandGuest(guestbookVo); //@RequestBody GuestbookVo guestbookVo(name,password,content 만 가지고 있음) 이름 겹쳐서 guestVo(no,name,pw,content,regDate 다 있음) 로
		System.out.println(guestVo);
		return guestVo;
	}
	
	//리스트
	//@ResponseBody
	@GetMapping(value="/api/guests")
	public List<GuestbookVo> list() {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVo> guestbookList = guestbookService.exeGuestlist();
		return guestbookList;
	}

}
