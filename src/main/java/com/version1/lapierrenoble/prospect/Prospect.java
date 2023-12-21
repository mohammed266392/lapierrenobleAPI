package com.version1.lapierrenoble.prospect;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.version1.lapierrenoble.message.Message;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Prospect {

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String email;

    private String companyName;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prospect")
    private List<Message> message;

}
