/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.controladores;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.umg.modelo.ListaDoble;
import org.umg.modelo.Nodo;

/**
 *
 * @author Edgar Mayorga
 */
@RestController
@RequestMapping(path = "/api")
public class ControladorDatos {
    private ListaDoble listaPasajerosAvion1 = new ListaDoble();
    private ListaDoble listaPasajerosAvion2 = new ListaDoble();
    private ListaDoble listaPasajerosAvion3 = new ListaDoble();
    private Nodo nodoPasajero = null;
    
    @RequestMapping(method = RequestMethod.GET,  value = "/mensaje")
    public String mensaje(){
        return "Hola, esta funcionando la API";
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/insertarAvion1")
    @ResponseBody
    public String insertarDatosAvion1(@RequestParam("avion") int numeroAvion, @RequestParam("dpi") int dpi, @RequestParam("nombre") String nombrePasajero, @RequestParam("asiento") int numeroAsiento){
        String retorna = "";
        nodoPasajero = listaPasajerosAvion1.buscarAsiento(numeroAsiento);     //busco el asiento para saber si esta ocupado o no
        
        if(nodoPasajero == null){
            //Manejo del avion 1
            if(listaPasajerosAvion1.elementos() < 10){        //verifico que el avion tenga asientos vacios
                listaPasajerosAvion1.insertaFinal(numeroAvion, dpi, nombrePasajero, numeroAsiento);
                retorna = "OK";
            }else{
                retorna = "EXCEDE";
            }
        }else{
            retorna = "OCUPADO";
        }
        
        return retorna;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/insertarAvion2")
    @ResponseBody
    public String insertarDatosAvion2(@RequestParam("avion") int numeroAvion, @RequestParam("dpi") int dpi, @RequestParam("nombre") String nombrePasajero, @RequestParam("asiento") int numeroAsiento){
        String retorna = "";
        nodoPasajero = listaPasajerosAvion2.buscarAsiento(numeroAsiento);     //busco el asiento para saber si esta ocupado o no
        
        if(nodoPasajero == null){
            //Manejo del avion 1
            if(listaPasajerosAvion2.elementos() < 10){        //verifico que el avion tenga asientos vacios
                listaPasajerosAvion2.insertaFinal(numeroAvion, dpi, nombrePasajero, numeroAsiento);
                retorna = "OK";
            }else{
                retorna = "EXCEDE";
            }
        }else{
            retorna = "OCUPADO";
        }
        
        return retorna;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/insertarAvion3")
    @ResponseBody
    public String insertarDatosAvion3(@RequestParam("avion") int numeroAvion, @RequestParam("dpi") int dpi, @RequestParam("nombre") String nombrePasajero, @RequestParam("asiento") int numeroAsiento){
        String retorna = "";
        nodoPasajero = listaPasajerosAvion3.buscarAsiento(numeroAsiento);     //busco el asiento para saber si esta ocupado o no
        
        if(nodoPasajero == null){
            //Manejo del avion 1
            if(listaPasajerosAvion3.elementos() < 10){        //verifico que el avion tenga asientos vacios
                listaPasajerosAvion3.insertaFinal(numeroAvion, dpi, nombrePasajero, numeroAsiento);
                retorna = "OK";
            }else{
                retorna = "EXCEDE";
            }
        }else{
            retorna = "OCUPADO";
        }
        
        return retorna;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/verListaAvion1")
    @ResponseBody
    public String mostrarListaAvion1(){
        Gson gson = new Gson();
        int elementos = listaPasajerosAvion1.elementos();
        int correlativo = 0;
        int numeroAvion = 0;
        int dpi = 0;
        int numeroAsiento = 0;
        String retorna = "";
        String jsonString = "";
        String nombrePasajero = "";
        
        if(!listaPasajerosAvion1.vacia()){
            for(int i = 1; i <= elementos; i++){
                correlativo = listaPasajerosAvion1.buscarCorrelativo(i).correlativo;
                numeroAvion = listaPasajerosAvion1.buscarCorrelativo(i).numeroAvion;
                dpi = listaPasajerosAvion1.buscarCorrelativo(i).dpi;
                nombrePasajero = listaPasajerosAvion1.buscarCorrelativo(i).nombrePasajero;
                numeroAsiento = listaPasajerosAvion1.buscarCorrelativo(i).numeroAsiento;
                nodoPasajero = new Nodo(correlativo, numeroAvion, dpi, nombrePasajero, numeroAsiento);
                jsonString = jsonString + gson.toJson(nodoPasajero);
                retorna = jsonString;
            }
        }else{
            retorna = "VACIO";
        }
        
        return retorna;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/verListaAvion2")
    @ResponseBody
    public String mostrarListaAvion2(){
        Gson gson = new Gson();
        int elementos = listaPasajerosAvion2.elementos();
        int correlativo = 0;
        int numeroAvion = 0;
        int dpi = 0;
        int numeroAsiento = 0;
        String retorna = "";
        String jsonString = "";
        String nombrePasajero = "";
        
        if(!listaPasajerosAvion2.vacia()){
            for(int i = 1; i <= elementos; i++){
                correlativo = listaPasajerosAvion2.buscarCorrelativo(i).correlativo;
                numeroAvion = listaPasajerosAvion2.buscarCorrelativo(i).numeroAvion;
                dpi = listaPasajerosAvion2.buscarCorrelativo(i).dpi;
                nombrePasajero = listaPasajerosAvion2.buscarCorrelativo(i).nombrePasajero;
                numeroAsiento = listaPasajerosAvion2.buscarCorrelativo(i).numeroAsiento;
                nodoPasajero = new Nodo(correlativo, numeroAvion, dpi, nombrePasajero, numeroAsiento);
                jsonString = jsonString + gson.toJson(nodoPasajero);
                retorna = jsonString;
            }
        }else{
            retorna = "VACIO";
        }
        
        return retorna;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/verListaAvion3")
    @ResponseBody
    public String mostrarListaAvion3(){
        Gson gson = new Gson();
        int elementos = listaPasajerosAvion3.elementos();
        int correlativo = 0;
        int numeroAvion = 0;
        int dpi = 0;
        int numeroAsiento = 0;
        String retorna = "";
        String jsonString = "";
        String nombrePasajero = "";
        
        if(!listaPasajerosAvion3.vacia()){
            for(int i = 1; i <= elementos; i++){
                correlativo = listaPasajerosAvion3.buscarCorrelativo(i).correlativo;
                numeroAvion = listaPasajerosAvion3.buscarCorrelativo(i).numeroAvion;
                dpi = listaPasajerosAvion3.buscarCorrelativo(i).dpi;
                nombrePasajero = listaPasajerosAvion3.buscarCorrelativo(i).nombrePasajero;
                numeroAsiento = listaPasajerosAvion3.buscarCorrelativo(i).numeroAsiento;
                nodoPasajero = new Nodo(correlativo, numeroAvion, dpi, nombrePasajero, numeroAsiento);
                jsonString = jsonString + gson.toJson(nodoPasajero);
                retorna = jsonString;
            }
        }else{
            retorna = "VACIO";
        }
        
        return retorna;
    }
}
