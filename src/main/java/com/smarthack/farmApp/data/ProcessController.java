package com.smarthack.farmApp.data;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("api/site")
public class ProcessController {

    @GetMapping("/price/{name}")
    public Float postPrice(@PathVariable String name) throws IOException {
        DataProcessing dataProcessing = new DataProcessing();
        dataProcessing.processData();
        Float m1 = dataProcessing.getVegetables().get(name).getPrice();
        Float m2 = dataProcessing.getFruits().get(name).getPrice();

        if(m1 == 0.0f){
            return  m2;
        } else {
            return m1;
        }
    }
}
