package com.rao.springMockito.service;

import com.rao.springMockito.data.ItemRepository;
import com.rao.springMockito.pojo.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {


    @InjectMocks
    private BusinessService businessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retreiveAllItems_Test(){
        when(itemRepository.findAll())
                .thenReturn(Arrays.asList(new Item(1,"Pencil",10,100),new Item(2,"Pen",10,100)));

        List<Item> items = businessService.retreiveAll();

        assertEquals("Pencil",items.get(0).getName());

    }
}
