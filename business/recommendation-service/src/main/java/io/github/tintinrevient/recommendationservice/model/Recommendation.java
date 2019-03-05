package io.github.tintinrevient.recommendationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Recommendation {
    @Id
    @GeneratedValue
    private Long id;

    private String author;
    private int rate;
    private String comment;

    private Long product;

}
