package com.version1.lapierrenoble.review;

import com.version1.lapierrenoble.prospect.Prospect;
import com.version1.lapierrenoble.prospect.ProspectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {


    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProspectService prospectService;

    @GetMapping("reviews")
    public List<Review> retrieveAllReview(){
        return reviewService.findAll();
    }


    @PostMapping("reviews/{idProspect}")
    public boolean createReview(@PathVariable Integer idProspect,@Valid @RequestBody Review review){
        Optional<Prospect> prospect = prospectService.findById(idProspect);
        if( prospect.isPresent() ){
            review.setProspect(prospect.get());
            return reviewService.createReview(review);
        }
        return false;
    }

    @PutMapping("reviews/{idProspect}")
    public boolean updateReview(@PathVariable Integer idProspect,@Valid @RequestBody Review review){
        Optional<Prospect> prospect = prospectService.findById(idProspect);

        if( prospect.isPresent() ){
            Optional<Review> reviewOfProspect = reviewService.findByProspect(prospect.get());
            if(reviewOfProspect.isPresent()){
                reviewOfProspect.get().setNote(review.getNote());
                reviewOfProspect.get().setReview(review.getReview());
                return reviewService.createReview(reviewOfProspect.get());
            }
        }
        return false;
    }



}
