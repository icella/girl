package com.icella.girl.controller;

import com.icella.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloGirlController {

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = {"/say"}, method = RequestMethod.GET)
    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "400") Integer myId){

        return girlProperties.getCupSize() + "id : " + myId;
    }
}
