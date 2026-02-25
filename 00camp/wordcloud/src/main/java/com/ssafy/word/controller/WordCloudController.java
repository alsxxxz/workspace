package com.ssafy.word.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.word.model.WordDto;
import com.ssafy.word.model.service.WordService;


@CrossOrigin("*")
@RestController
@RequestMapping("/word")
public class WordCloudController {
	private final WordService wordService;
	public WordCloudController(WordService wordService) {
		this.wordService = wordService;
	}

	@GetMapping
	public ResponseEntity<List<WordDto>> listWord() {
		System.out.println("listWord - 호출");
		
		List<WordDto> wordList = wordService.listWord();
		return ResponseEntity.ok(wordList);
	} 
	
	@PostMapping("/{word}")
	public ResponseEntity<List<WordDto>> updateWordCount(@PathVariable String word) {
		System.out.println("updateWordCount("+word+") - 호출");
		
		wordService.updateCount(word);
		
		List<WordDto> wordList = wordService.listWord();
		return ResponseEntity.ok(wordList);
	}
}
