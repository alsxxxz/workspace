package com.ssafy.word.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.word.model.WordDto;
import com.ssafy.word.model.mapper.WordMapper;

@Service
public class WordServiceImpl implements WordService {
	private final WordMapper wordMapper;
	public WordServiceImpl(WordMapper wordMapper) {
		this.wordMapper = wordMapper;
	}

	@Override
	public List<WordDto> listWord() {
		return wordMapper.listWord();
	}

	@Override
	public void updateCount(String word) {
		wordMapper.updateCount(word);
	} 
}
