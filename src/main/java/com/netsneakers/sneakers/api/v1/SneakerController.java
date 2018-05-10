package com.netsneakers.sneakers.api.v1;

import com.netsneakers.sneakers.domain.exception.NotFoundException;
import com.netsneakers.sneakers.service.SneakerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/sneackers")
public class SneakerController {

    private final SneakerService sneakerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SneakerResource getSneakerById(@PathVariable String sku) throws NotFoundException {
        return new SneakerResource(sneakerService.getBySku(sku));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SneakerResource save(@RequestBody SneakerResource sneakerResource) {
        return new SneakerResource(sneakerService.save(sneakerResource.toDomain(sneakerResource)));
    }
}
