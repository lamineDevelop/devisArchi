package com.candle.devisarchi.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messagerie")
public class FactureControler {
    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    @ResponseBody
    public String receiveMessage() {
        return "this.listeMessage";
    }

}
