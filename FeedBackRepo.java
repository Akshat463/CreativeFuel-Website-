package com.creativeFuel.feedback_Request.dao;

import com.creativeFuel.feedback_Request.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepo extends JpaRepository<Feedback,Long> {

}
