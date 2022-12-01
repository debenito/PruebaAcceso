package com.prueba.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.prueba.controller.ProductsRestController;
import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
import com.prueba.exceptions.PersonalizadaException;
import com.prueba.services.impl.ProductsServiceImpl;
import com.prueba.utils.AppLogger;


@WebMvcTest(ProductsRestController.class)
class ProductRestControllerOnlyWebTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductsServiceImpl productService;

    ProductDetail product1= new ProductDetail("1","Shirt",new BigDecimal(9.99),true);
    ProductDetail product2= new ProductDetail("2","Dress",new BigDecimal(19.99),true);
    ProductDetail product3= new ProductDetail("3","Blazer",new BigDecimal(29.99),false);
    ProductDetail product4= new ProductDetail("4","Boots",new BigDecimal(39.99),true);
    ProductDetail product100 = new ProductDetail("100","Trousers",new BigDecimal(49.99),false);
    ProductDetail product1000 = new ProductDetail("1000","Coat",new BigDecimal(89.99),true);
    ProductDetail product10000 = new ProductDetail("10000","Leather jacket",new BigDecimal(89.99),true);
   
    SimilarProducts similar = SimilarProducts.builder().build();

    @Test
    void testGetId1() throws Exception {
        Mockito.when(productService.findOne("1")).thenReturn(product1);

        String response = mockMvc.perform(get("/product" + "/{id}", "1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("1")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    

    @Test
    void testGetId2() throws Exception {
        Mockito.when(productService.findOne("2")).thenReturn(product2);

        String response = mockMvc.perform(get("/product" + "/{id}", "2"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("2")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }

    @Test
    void testGetId3() throws Exception {
        Mockito.when(productService.findOne("3")).thenReturn(product3);

        String response = mockMvc.perform(get("/product" + "/{id}", "3"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("3")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }


    @Test
    void testGetId4() throws Exception {
        Mockito.when(productService.findOne("4")).thenReturn(product4);

        String response = mockMvc.perform(get("/product" + "/{id}", "4"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("4")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    @Test
    void testGetId5() throws Exception {
        Mockito.when(productService.findOne("5")).thenThrow(new UnknownHostException());

        String response = mockMvc.perform(get("/product" + "/{id}", "5"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
               // .andExpect(jsonPath("$.message", is("Product not found")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    @Test
    void testGetId6() throws Exception {
        Mockito.when(productService.findOne("6")).thenThrow(new PersonalizadaException());;

        String response = mockMvc.perform(get("/product" + "/{id}", "6"))
               .andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    @Test
    void testGetId100() throws Exception {
        Mockito.when(productService.findOne("100")).thenReturn(product100);

        String response = mockMvc.perform(get("/product" + "/{id}", "100"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("100")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    @Test
    void testGetId1000() throws Exception {
        Mockito.when(productService.findOne("1000")).thenReturn(product1000);

        String response = mockMvc.perform(get("/product" + "/{id}", "1000"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("1000")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    
    @Test
    void testGetId10000() throws Exception {
        Mockito.when(productService.findOne("10000")).thenReturn(product10000);

        String response = mockMvc.perform(get("/product" + "/{id}", "10000"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id", is("10000")))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    @Test
    void testGetSimilarId1() throws Exception {
    	similar.add(product2);
    	similar.add(product3);
    	similar.add(product4);
        Mockito.when(productService.findRelactions("1")).thenReturn(similar);

        String response = mockMvc.perform(get("/product" + "/{id}", "1/similar"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    @Test
    void testGetSimilarId2() throws Exception {
    	similar.add(product3);
    	similar.add(product100);
    	similar.add(product100);
        Mockito.when(productService.findRelactions("2")).thenReturn(similar);

        String response = mockMvc.perform(get("/product" + "/{id}", "2/similar"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    @Test
    void testGetSimilarId3() throws Exception {
    	similar.add(product100);
    	similar.add(product1000);
    	similar.add(product10000);
        Mockito.when(productService.findRelactions("3")).thenReturn(similar);

        String response = mockMvc.perform(get("/product" + "/{id}", "3/similar"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    @Test
    void testGetSimilarId4() throws Exception {
    	similar.add(product1);
    	similar.add(product2);
        Mockito.when(productService.findRelactions("4")).thenReturn(similar);

        String response = mockMvc.perform(get("/product" + "/{id}", "4/similar"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }
    
    @Test
    void testGetSimilarId5() throws Exception {
    	similar.add(product1);
    	similar.add(product2);
        Mockito.when(productService.findRelactions("5")).thenReturn(similar);

        String response = mockMvc.perform(get("/product" + "/{id}", "5/similar"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse()
                .getContentAsString();

        AppLogger.info("response: " , response, ProductsRestController.class);
    }


}
