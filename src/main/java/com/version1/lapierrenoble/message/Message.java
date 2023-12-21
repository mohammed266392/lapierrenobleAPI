package com.version1.lapierrenoble.message;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.version1.lapierrenoble.prospect.Prospect;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private LocalDateTime localDateTime;

    @JsonBackReference
    @ManyToOne
    private Prospect prospect;
}
