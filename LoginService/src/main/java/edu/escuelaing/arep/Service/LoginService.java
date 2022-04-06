package edu.escuelaing.arep.Service;

import java.io.IOException;

import edu.escuelaing.arep.Security.SecureUrlReader;
import spark.Request;
import spark.Response;

/**
 * Clase que maneja las operaciones de registro autorizado de un usuario
 *
 */
public class LoginService {
    
    
    private final String URL_SERVICE = "https://localhost:4567";
    // private final String URL_SERVICE = "https://ec2-184-73-66-215.compute-1.amazonaws.com:4500";

    /**
     * Método que autentica un usuario
     * 
     * @param req - solicitud con las credenciales requeridas
     * @param res - respuesta HTTP
     * @return Un mensaje de exito o no de la autenticación
     * @throws IOException
     */
    public Object authenticate(Request req, Response res) throws IOException {
        
        String username = req.queryParams("username");
        String password = req.queryParams("password");
        String response;

        if (username != null && password != null) {
            res.status(200);
            response = SecureUrlReader
                    .readURL(URL_SERVICE + "/auth?username=" + username + "&password=" + password);
        } else {
            res.status(400);
            response = "BAD REQUEST!";
        }

        return response;
    }

}