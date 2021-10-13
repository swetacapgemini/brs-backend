package com.brs;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.entity.User;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.repository.IBusRepository;
import com.brs.repository.IFeedBackRepository;

import com.brs.repository.IUserRepository;
import com.brs.service.FeedBackService;

class FeedBackServiceMockitoTest {

	@Mock
	IFeedBackRepository feedbackrepo;
	@InjectMocks
	FeedBackService feedbackservice;
	List<FeedBack> feedbackList;
	FeedBack f1, f2, f3;
	@Mock
	IUserRepository userrepo;
	@Mock
	IBusRepository busrepo;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);

		feedbackList = new ArrayList<>();

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Bus bus1 = new Bus(1, "busname", "drivername", "bustype", "routefrom", "routeto", time, time, 3, 2);
		User user1 = new User(1, "raj", "password", "fname", "lstname", "979104571", "abc@gmail.com");
		User user2 = new User(2, "kamala", "absn", "firname", "lastname", "979104571", "abd@gmail.com");
		User user3 = new User(3, "kannan", "kann", "fistname", "ltname", "979104571", "aba@gmail.com");
		f1 = new FeedBack(1, 2, 2, 2, "bad", date, user1);
		f2 = new FeedBack(5, 5, 5, 5, "good", date, user2);
		f3 = new FeedBack(1, 3, 3, 3, "average", date, user3);
		feedbackList.add(f1);
		feedbackList.add(f2);
		feedbackList.add(f3);

	}

	@Test
	void addFeedBackTest() throws FeedBackNotFoundException {
		when(feedbackrepo.save(f1)).thenReturn(f1);
		Assertions.assertEquals(f1, feedbackservice.addFeedBack(f1));
	}

	@Test
	void viewAllReservationTest() throws FeedBackNotFoundException {
		when(feedbackrepo.findAll()).thenReturn(feedbackList);
		Assertions.assertEquals(feedbackList, feedbackservice.viewAllFeedBack());
	}

	@Test
	void updateFeedBackTest() throws FeedBackNotFoundException {
		when(feedbackrepo.findById((int) f1.getFeedBackId())).thenReturn(Optional.of(f1));
		when(feedbackrepo.save(f1)).thenReturn(f1);
		Assertions.assertEquals(f1, feedbackservice.updateFeedBack(f1));

	}

	@Test
	void viewFeedBackByIdTest() throws FeedBackNotFoundException {
		when(feedbackrepo.findById((int) f1.getFeedBackId())).thenReturn(Optional.of(f1));
		Assertions.assertEquals(f1, feedbackservice.viewFeedBack((int) f1.getFeedBackId()));
	}

	@Test
	void deleteFeedBackTest() throws FeedBackNotFoundException {
		when(feedbackrepo.findById((int) f1.getFeedBackId())).thenReturn(Optional.of(f1));
		Assertions.assertEquals(f1, feedbackservice.deleteFeedBack((int) f1.getFeedBackId()));
	}
}