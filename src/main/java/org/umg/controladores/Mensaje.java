/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edgar Mayorga
 */
@RestController
@RequestMapping(path = "/servicesRest")
public class Mensaje {
    
    /*@RequestMapping(method = RequestMethod.GET, value = "/mensaje")
    //@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/mensaje")
    public String mensaje(){
        return "Hola, estoy funcionando como API";
    }*/
}
