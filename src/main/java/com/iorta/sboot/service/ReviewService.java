package com.iorta.sboot.service;

import java.util.List;

import com.iorta.sboot.dto.ReviewDTO;

public interface ReviewService {
	String addReview(ReviewDTO reviewDTO);
	
	List<ReviewDTO> getReviewsByBookId(Long bookId);
	
	String updateReview(Long reviewId, ReviewDTO reviewDTO);
	
	String deleteReview(Long reviewId);
}
