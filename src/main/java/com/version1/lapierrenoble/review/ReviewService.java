package com.version1.lapierrenoble.review;

import com.version1.lapierrenoble.prospect.Prospect;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    List<Review> findAll(){
        return reviewRepository.findAll();
    }

    Optional<Review> findByProspect(Prospect prospect){
        return reviewRepository.findByProspect(prospect);
    }

    boolean createReview(Review review){
        Review review1 = reviewRepository.save(review);
        return true;
    }
}
