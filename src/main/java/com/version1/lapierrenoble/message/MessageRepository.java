package com.version1.lapierrenoble.message;

import com.version1.lapierrenoble.prospect.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findByProspect(Prospect prospect);

    Optional<Message> findById(Integer id);


}
