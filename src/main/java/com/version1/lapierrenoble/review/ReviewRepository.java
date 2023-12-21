package com.version1.lapierrenoble.review;

import com.version1.lapierrenoble.prospect.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    Optional<Review> findByProspect(Prospect prospect);

}
