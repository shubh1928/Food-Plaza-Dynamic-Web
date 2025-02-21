package com.dao;

import java.util.List;
import com.pojo.Feedback;

public interface FeedbackDao {
	
	boolean addFeedback(Feedback fd);
	List<Feedback>getAllFeedback();

}
