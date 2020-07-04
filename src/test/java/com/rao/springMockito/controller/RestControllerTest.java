package com.rao.springMockito.controller;

import com.rao.springMockito.data.ItemRepository;
import com.rao.springMockito.pojo.Item;
import com.rao.springMockito.service.BusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RestController.class)
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Pencil\",\"price\":10,\"quantity\":100}")).andReturn();
    }


    @Test
    public void dummyItem_service() throws Exception {

        when(businessService.retreiveItem()).thenReturn(new Item(1,"Pencil",10,100));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Pencil\",\"price\":10,\"quantity\":100}")).andReturn();


    }


    @Test
    public void dummyItem_service_fetchAll() throws Exception {

        when(businessService.retreiveAll()).thenReturn(Arrays.asList(new Item(1,"Pencil",10,100)));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-fetch-all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Pencil\",\"price\":10,\"quantity\":100}]")).andReturn();


    }
}
