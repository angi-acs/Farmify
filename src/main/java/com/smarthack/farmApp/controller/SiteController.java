package com.smarthack.farmApp.controller;

import com.smarthack.farmApp.entity.Color;
import com.smarthack.farmApp.entity.Data;
import com.smarthack.farmApp.entity.Farmer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/site")
public class SiteController {
    Color color;

    @GetMapping("/color")
    public Color getColor () {
        return color;
    }

    @PostMapping("/add")
    public Color remember(@RequestBody Color color) {
        this.color = color;
        return color;
    }

    @PostMapping("/pic")
    public String remember(@RequestBody String data) {
        String returnvalue = data;

        data = data.substring(9, data.length() - 2);
        String base64Image = data.split(",")[1];
        byte[] imgData = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);

        String extension;
        System.out.println(data.split(",")[0]);
        switch (data.split(",")[0]) {//check image's extension
            case "data:image/png;base64":
                extension = "png";
                break;
            default:
                extension = "jpg";
                break;
        }

        File file = new File("src/main/resources/test_sample." + extension);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(imgData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnvalue;
    }
}
