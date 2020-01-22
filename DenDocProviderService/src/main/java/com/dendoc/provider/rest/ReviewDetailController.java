/**
 * 
 */
package com.dendoc.provider.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dendoc.provider.model.Provider;
import com.dendoc.provider.model.ReviewDetail;
import com.dendoc.provider.service.ReviewDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Chetan
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(tags = "ReviewDetail Service")
@FeignClient(name="ZUUL-SERVER")
public class ReviewDetailController {

	Logger logger = Logger.getLogger(ReviewDetailController.class.getName());

	@Autowired
	ReviewDetailService reviewDetailService;
	
	@Value("${server.port}")
	private int port;
	
	@PostMapping("/review-service/updateReview")
	@ApiOperation(value = "this is to Update Review details")
	public ResponseEntity<ReviewDetail> updateReview(@RequestBody ReviewDetail reviewDetail){
		ReviewDetail reviewDetails = reviewDetailService.updateReviewDetail(reviewDetail.getReviewId(), reviewDetail);
		return new ResponseEntity<>(reviewDetails,HttpStatus.OK);
	}
	
	@PostMapping("/review-service/insertReview" )
	@ApiOperation(value = "this is to Insert new Review details")
	public ResponseEntity<ReviewDetail> insertReview(@RequestBody ReviewDetail inputReview){
		ReviewDetail reviewDetail = reviewDetailService.insertProvider(inputReview);
		return new ResponseEntity<>(reviewDetail,HttpStatus.OK);
	}
	
	@GetMapping("/review-service/getReviewById/{ReviewId}")
	@ApiOperation(value = "this is to get Review details based on ReviewId")
	public ResponseEntity<ReviewDetail> getReviewById(@PathVariable(value="ReviewId") long reviewId){
		ReviewDetail reviewDetail = reviewDetailService.getreviewDetailById(reviewId);
		return new ResponseEntity<>(reviewDetail,HttpStatus.OK);
	}
	
	@GetMapping("/review-service/getAllReviews")
	@ApiOperation(value = "this is to get all provider details")
	public ResponseEntity<List<ReviewDetail>> getAllReviews(){
		List<ReviewDetail> reviewDetails = reviewDetailService.getAllreviewDetails();
		return new ResponseEntity<>(reviewDetails,HttpStatus.OK);
	}
	
	@DeleteMapping("/review-service/deleteReview/{reviewId}")
	@ApiOperation(value = "this is to delete Review details based on rviewId")
	public ResponseEntity<Void> deleteReviewDetail(@PathVariable(value="reviewId") long reviewId){
		reviewDetailService.deleteReviewDetail(reviewId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
