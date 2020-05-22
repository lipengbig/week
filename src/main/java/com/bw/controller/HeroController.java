package com.bw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.beans.Camp;
import com.bw.beans.Hero;
import com.bw.service.HeroService;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class HeroController {
	
	@Resource
	private HeroService heroService;

	@RequestMapping("queryAll")
	public String queryAll(@RequestParam(defaultValue="1")Integer pageNum,Model model
			,Integer cid,Integer status,Double startPrice,Double endPrice){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		System.out.println(status);
		map.put("status", status);
		map.put("startPrice", startPrice);
		map.put("endPrice", endPrice);
		PageHelper.startPage(pageNum, 2);
		List<Hero> list = heroService.queryAll(map);
		PageInfo<Hero> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		
		//查询所有阵营
		List<Camp> campList = heroService.queryCampAll();
		model.addAttribute("campList", campList);
		return "list";
	}

	@RequestMapping("queryCampAll")
	@ResponseBody
	public List<Camp> queryCampAll(){
		//查询所有阵营
		List<Camp> campList = heroService.queryCampAll();
		return campList;
	}
	
	
	@RequestMapping("addHer")
	public String addHero(Hero hero,Model model,MultipartFile file){
		
		try {
			String upload2 = FileUtils.upload(file);
			hero.setPicurl(upload2);
			heroService.insertHero(hero);
			return "redirect:queryAll";
		} catch (Exception e) {
			e.printStackTrace();
			return "add";

		} 
	
	}

	
}
