package com.version1.lapierrenoble.prospect;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProspectRepository extends JpaRepository<Prospect,Integer> {

//    @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//    List<Message> findMessageById(Integer status, String name);
//
//
    List<Prospect> findAll();

    Optional<Prospect> findById(Integer id);

}
