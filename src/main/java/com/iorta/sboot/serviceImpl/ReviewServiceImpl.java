package com.iorta.sboot.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iorta.sboot.dao.Review;
import com.iorta.sboot.dto.ReviewDTO;
import com.iorta.sboot.repository.ReviewRepository;
import com.iorta.sboot.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addReview(ReviewDTO reviewDTO) {
		Review review = modelMapper.map(reviewDTO, Review.class);
		reviewRepository.save(review);
		return "Review added successfully!";
	}

	@Override
	public List<ReviewDTO> getReviewsByBookId(Long bookId) {
		return reviewRepository.findByBookId(bookId).stream()
				.map(review -> modelMapper.map(review, ReviewDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public String updateReview(Long reviewId, ReviewDTO reviewDTO) {
		Optional<Review> existing = reviewRepository.findById(reviewId);
		if (existing.isPresent()) {
			Review review = existing.get();
			review.setReviewerName(reviewDTO.getReviewerName());
			review.setComment(reviewDTO.getComment());
			review.setRating(reviewDTO.getRating());
			reviewRepository.save(review);
			return "Review updated successfully!";
		} else {
			return "Review not found!";
		}
	}

	@Override
	public String deleteReview(Long reviewId) {
		reviewRepository.deleteById(reviewId);
		return "Review deleted successfully!";
	}
	
}
