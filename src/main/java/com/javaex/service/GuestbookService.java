package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	//저장 + 1개가져오기
	public GuestbookVo exeAddandGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestService.exeAddandGuest()");

		// 등록
		int count = guestbookDao.insertSelectKey(guestbookVo); //Dao에 2개 만들어 줘야함

		// no 의 데이터 가져오기
		// no값 확인
		int no = guestbookVo.getNo();
		// no데이터 가져오기

		GuestbookVo gVo = guestbookDao.guestbookSelectOne(no);//Dao에 2개 만들어 줘야함
		return gVo;
	}
	
	//리스트 가져오기 
	public List<GuestbookVo> exeGuestlist(){
		System.out.println("GuestbookService.exeGuestlist()");
		
		List<GuestbookVo> guestbookList = guestbookDao.guestbookSelectList();
		
		return guestbookList;
		
	}

}
