package io.github.tintinrevient.oauthserver.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

    private int id;
    private String author;
    private String subject;
    private String comment;
    private int product;
}
