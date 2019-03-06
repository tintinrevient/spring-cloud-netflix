package io.github.tintinrevient.dataservice.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recommendation {

    private int id;
    private String author;
    private int rate;
    private String comment;
    private int product;

}
