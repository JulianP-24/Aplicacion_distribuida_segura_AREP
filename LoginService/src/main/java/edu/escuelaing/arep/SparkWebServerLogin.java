package edu.escuelaing.arep;

import static spark.Spark.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import edu.escuelaing.arep.Security.SecureUrlReader;
import edu.escuelaing.arep.controller.LoginController;
import edu.escuelaing.arep.Service.LoginService;

public class SparkWebServerLogin {
    private static LoginController loginController;

    public static void main(String[] args) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException,CertificateException, FileNotFoundException, IOException {
        
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), "123456", null, null);
        SecureUrlReader.initSecureContext();

        loginController = new LoginController(new LoginService());
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore.p12";
    }
}




