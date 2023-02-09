package com.candle.devisarchi.controler;

import com.candle.devisarchi.dto.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControler {

    @Autowired
    @GetMapping("/welc")
    public String welcom(){
        return "bienvenu à mon site";
    }

    @PostMapping("/auth")
    public String generatePassword(@RequestBody AuthenticationRequest auth){

        return "token";
    }
}
