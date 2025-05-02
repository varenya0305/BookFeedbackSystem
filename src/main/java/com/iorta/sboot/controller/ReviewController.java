package com.iorta.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.ReviewDTO;
import com.iorta.sboot.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/addReview")
	public String addReview(@RequestBody ReviewDTO reviewDTO) {
		return reviewService.addReview(reviewDTO);
	}
	
	@GetMapping("/getReviewsByBookId/{bookId}")
	public List<ReviewDTO> getReviewsByBookId(@PathVariable Long bookId) {
		return reviewService.getReviewsByBookId(bookId);
	}
	
	@PutMapping("/updateReview/{reviewId}")
	public String updateReview(@PathVariable Long reviewId, @RequestBody ReviewDTO reviewDTO) {
		return reviewService.updateReview(reviewId, reviewDTO);
	}
	
	@DeleteMapping("/deleteReview/{reviewId}")
	public String deleteReview(@PathVariable Long reviewId) {
		return reviewService.deleteReview(reviewId);
	}
}


