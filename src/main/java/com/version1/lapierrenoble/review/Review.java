package com.version1.lapierrenoble.review;

import com.version1.lapierrenoble.prospect.Prospect;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue
    private Integer id;

    private String review;

    @Min(1)
    @Max(5)
    private Integer note;

    @OneToOne
    private Prospect prospect;

}
