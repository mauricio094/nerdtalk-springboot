package com.netsneakers.sneakers.api.v1;

import com.netsneakers.sneakers.domain.Sneaker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SneakerResource {

    private String sku;
    private String name;
    private String color;
    private String size;

    public SneakerResource(Sneaker sneaker) {
        this.setSku(sneaker.getSku());
        this.setName(sneaker.getName());
        this.setColor(sneaker.getColor());
        this.setSize(sneaker.getSize());
    }

    public Sneaker toDomain(SneakerResource sneakerResource) {
        Sneaker sneaker = new Sneaker();
        sneaker.setSku(sneakerResource.getSku());
        sneaker.setName(sneakerResource.getName());
        sneaker.setColor(sneakerResource.getColor());
        sneaker.setSize(sneakerResource.getSize());
        return sneaker;
    }

}
