package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.beans.Camp;
import com.bw.beans.Hero;
import com.bw.mapper.HeroMapper;
@Service
public class HeroServiceImpl implements HeroService{
	@Resource
	private HeroMapper heroMapper;
	
	@Override
	public List<Hero> queryAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return heroMapper.queryAll(map);
	}

	@Override
	public List<Camp> queryCampAll() {
		// TODO Auto-generated method stub
		return heroMapper.queryCampAll();
	}

	@Override
	public void insertHero(Hero hero) {
		// TODO Auto-generated method stub
		heroMapper.insertHero(hero);
	}

}
