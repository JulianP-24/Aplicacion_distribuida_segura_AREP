package edu.escuelaing.arep.controller;

import static spark.Spark.get;

import edu.escuelaing.arep.Service.AuthtenticationService;

/**
 * Clase que maneja los endpoints del servicio
 *
 */
public class authenticationController {

    /**
     * Método que gestiona la autenticación del login service
     * 
     * @param loginService - servicio a gestionar
     */
    public authenticationController(final AuthtenticationService authtenticationService) {
        get("hello", (req, res) -> "Hello World, from Authentication Service!");
        get("auth", (req, res) -> authtenticationService.login(req, res));
    }

}