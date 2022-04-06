package edu.escuelaing.arep.controller;

import static spark.Spark.get;

import edu.escuelaing.arep.Service.LoginService;

/**
 * Clase que maneja los endpoints del servicio
 *
 */
public class LoginController {

    /**
     * Método que gestiona la autenticación del login service
     * 
     * @param loginService - servicio a gestionar
     */
    public LoginController(final LoginService loginService) {
        get("hello", (req, res) -> "Hello World, from Login Service!");
        get("auth", (req, res) -> loginService.authenticate(req, res));
    }

}