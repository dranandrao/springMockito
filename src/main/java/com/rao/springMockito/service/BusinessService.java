package com.rao.springMockito.service;

import com.rao.springMockito.data.ItemRepository;
import com.rao.springMockito.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retreiveItem(){
        return new Item(1,"Pencil", 10 ,100);
    }

    public List<Item> retreiveAll(){
        return repository.findAll();
    }
}
