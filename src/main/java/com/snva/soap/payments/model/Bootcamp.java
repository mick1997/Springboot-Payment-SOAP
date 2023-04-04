package com.snva.soap.payments.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "bootcamp")
public class Bootcamp {

    @Id
    private String id;
    private String bootcampName;
    private String details;
    private String instructor;
}
