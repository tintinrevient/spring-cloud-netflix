package io.github.tintinrevient.oauthserver.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private int id;
    private String name;
    private String description;

}
