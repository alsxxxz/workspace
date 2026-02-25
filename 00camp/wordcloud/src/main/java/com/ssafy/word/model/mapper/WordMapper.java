package com.ssafy.word.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.word.model.WordDto;

@Mapper
public interface WordMapper {

	List<WordDto> listWord();
	void updateCount(String word);
	
}
