/**
 * 
 */
package com.dendoc.provider.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dendoc.provider.config.Configuration;
import com.dendoc.provider.dao.ReviewDetailRepository;
import com.dendoc.provider.exception.CustomException;
import com.dendoc.provider.model.Provider;
import com.dendoc.provider.model.ReviewDetail;

/**
 * @author Chetan
 *
 */
@Service
public class ReviewDetailService {
	Logger logger = Logger.getLogger(ReviewDetailService.class.getName());
	
	@Autowired
	Configuration config;

	
	@Value("${server.port}")
	private int port;
	
	@Autowired
	ReviewDetailRepository reviewDetailRepository;
	
	public ReviewDetail updateReviewDetail(Long id, ReviewDetail reviewDetail) {
		logger.info("Inside updateReviewDetail "+reviewDetail.toString());
		ReviewDetail reviewDetailToUpdate = reviewDetailRepository.findById(id).
				orElseThrow(()->new CustomException("ReviewDetail not found"));
	 
		reviewDetailToUpdate =reviewDetail;
	    logger.info( "reviewDetail details Before updating into DB : "+reviewDetail.toString());
	    return  reviewDetailRepository.save(reviewDetailToUpdate);
	} 
	
	public ReviewDetail insertProvider(ReviewDetail reviewDetail) {
		logger.log(Level.INFO, "Inside insertreviewDetail {}",reviewDetail.toString());
		logger.info("Inside insertreviewDetail "+reviewDetail.toString());
		//logger.info("Inside insertreviewDetail {}",reviewDetail.toString());
		return reviewDetailRepository.save(reviewDetail);
	} 
	
	public ReviewDetail getreviewDetailById(Long id) {
		logger.log(Level.INFO, "Inside getreviewDetailById {}",id);
	    return reviewDetailRepository.findById(id).orElseThrow(()->new CustomException("reviewDetail not found"));
	}  
	
	public List<ReviewDetail> getAllreviewDetails() {
		logger.log(Level.INFO, "Inside getAllreviewDetails");
	    return reviewDetailRepository.findAll();
	} 
	
	public void deleteReviewDetail(Long id) {

		logger.log(Level.INFO, "Inside deletereviewDetail {} ",id);
		reviewDetailRepository.findById(id).orElseThrow(()->new CustomException("reviewDetail not found"));
		reviewDetailRepository.deleteById(id);
	}
	
	
}
