package com.brs.service;

import java.util.List;

import com.brs.entity.FeedBack;
import com.brs.exceptions.FeedBackNotFoundException;

public interface IFeedBackService {

	FeedBack addFeedBack(FeedBack feedback) throws FeedBackNotFoundException;

	FeedBack updateFeedBack(FeedBack feedback) throws FeedBackNotFoundException;

	FeedBack viewFeedBack(int id) throws FeedBackNotFoundException;

	List<FeedBack> viewAllFeedBack() throws FeedBackNotFoundException;

	FeedBack deleteFeedBack(int feedBackId) throws FeedBackNotFoundException;

}
