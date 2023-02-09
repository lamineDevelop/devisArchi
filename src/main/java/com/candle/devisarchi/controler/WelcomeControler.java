package com.candle.devisarchi.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControler {

    @GetMapping("/welc")
    public String welcom(){
        return "bienvenu à mon site";
    }
}
