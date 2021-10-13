package com.brs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.entity.Route;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.repository.IFeedBackRepository;

@Service
@Transactional
/**
 * Description:This is feedback Service Class that provides the services to add
 * a feedback, remove a feedback, update a feedback and view a feedback
 **/
public class FeedBackService implements IFeedBackService {
	@Autowired
	private IFeedBackRepository feedbackRepository;

	/**
	 * Description :To add FeedBack to the database Input Params :FeedBack object to
	 * be added to the database Return Value :FeedBack Object
	 **/

	@Override
	public FeedBack addFeedBack(FeedBack feedBack)throws FeedBackNotFoundException {
		Optional<FeedBack> addFeedBackTemp = feedbackRepository.findById((int) feedBack.getFeedBackId());
		if (!addFeedBackTemp.isPresent()) {
			FeedBack savedFeedBack=new FeedBack();
			savedFeedBack = feedbackRepository.save(feedBack);
		return savedFeedBack;
	}
		 else {
				throw new FeedBackNotFoundException("FeedBack already exists");
			}
	}

	/**
	 * Description :To update FeedBack in the database Input Params :FeedBack object
	 * to be added to the database Return Value :FeedBack Object
	 **/

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedBackNotFoundException {
		Optional<FeedBack> updateFb = null;
		updateFb = feedbackRepository.findById((int) feedback.getFeedBackId());
		if (updateFb.isPresent()) {
		feedbackRepository.save(feedback);
		return feedback;
		}
		else throw new FeedBackNotFoundException("Feedback with given id is not found");

	}

	/**
	 * Description :To view FeedBack in the database Input Params :FeedBack id whose
	 * FeedBack object should be viewed in the database Return Value :FeedBack
	 * Object
	 **/

	@Override
	public FeedBack viewFeedBack(int id) throws FeedBackNotFoundException {
		Optional<FeedBack> retVal = null;

		retVal = feedbackRepository.findById(id);
		if (retVal.isPresent()) {
		return retVal.get();

	}
		else throw new FeedBackNotFoundException("Feedback with given id not found");
	}

	/**
	 * Description :To view all the FeedBack in the database Return Value :list of
	 * FeedBack Objects
	 **/

	@Override
	public List<FeedBack> viewAllFeedBack() throws FeedBackNotFoundException {

		return feedbackRepository.findAll();

	}

	/**
	 * Description :To delete FeedBack from the database Input Params :FeedBack
	 * object to be deleted from the database Return Value :FeedBack Object
	 * Exception :FeedBackNotFoundException-raised when FeedBack Id not found
	 * @throws  
	 **/
	@Override
public FeedBack deleteFeedBack(int feedbackId) throws FeedBackNotFoundException {
		
		
		Optional<FeedBack> deleteFb = null;
		deleteFb = feedbackRepository.findById(feedbackId);
		if (deleteFb.isPresent()) {

			Optional<FeedBack> feedback = feedbackRepository.findById(feedbackId);
            feedbackRepository.deleteById(feedbackId);
		return feedback.get();
	}
		else throw new FeedBackNotFoundException("Feedback with given id not found");
	}
}