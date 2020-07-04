package com.rao.springMockito.controller;

import com.rao.springMockito.pojo.Item;
import com.rao.springMockito.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Pencil", 10, 100);
    }


    @GetMapping("/dummy-item-service")
    public Item dummyItemService() {
        return businessService.retreiveItem();
    }

    @GetMapping("/item-fetch-all")
    public List<Item> retrieveAll(){
        return businessService.retreiveAll();
    }
}
