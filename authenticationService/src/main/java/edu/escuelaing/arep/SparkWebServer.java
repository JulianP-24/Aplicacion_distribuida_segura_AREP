package edu.escuelaing.arep;

import static spark.Spark.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import edu.escuelaing.arep.controller.authenticationController;
import edu.escuelaing.arep.Model.User;
import edu.escuelaing.arep.Service.AuthtenticationService;

public class SparkWebServer {
    private static authenticationController AuthenticationController;

    public static void main(String[] args) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException,CertificateException, FileNotFoundException, IOException {
        
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), "123456", null, null);
        
        AuthenticationController = new authenticationController(new AuthtenticationService());
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/authkeystore.p12";
    }
}




