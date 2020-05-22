package com.bw.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bw.beans.Camp;
import com.bw.service.HeroService;

public class Test01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HeroService mapper = ac.getBean(HeroService.class);
		Map<String, Object> map = new HashMap<>();
		
//		List<Hero> queryAll = mapper.queryAll(map);
//		for (Hero hero : queryAll) {
//			System.out.println(hero);
//		}
		List<Camp> all = mapper.queryCampAll();
		for (Camp camp : all) {
			System.out.println(camp);
		}
		
	}
}
