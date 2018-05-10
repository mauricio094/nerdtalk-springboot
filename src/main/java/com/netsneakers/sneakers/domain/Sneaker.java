package com.netsneakers.sneakers.domain;


import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sneaker")
public class Sneaker {

    @Id
    @Indexed
    @Field(value = "sku")
    private String sku;
    private String name;
    private String color;
    private String size;
}
