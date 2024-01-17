package com.version1.lapierrenoble.review;

import com.version1.lapierrenoble.prospect.Prospect;
import com.version1.lapierrenoble.prospect.ProspectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProspectService prospectService;

    @GetMapping
    public List<Review> retrieveAllReview(){
        return reviewService.findAll();
    }


    @PostMapping("/{idProspect}")
    public boolean createReview(@PathVariable Integer idProspect,@Valid @RequestBody Review review){
        Optional<Prospect> prospect = prospectService.findById(idProspect);
        if( prospect.isPresent() ){
            review.setProspect(prospect.get());
            review.setDatePublication(LocalDateTime.now());
            return reviewService.createReview(review);
        }
        return false;
    }

    @PutMapping("/{idProspect}")
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
