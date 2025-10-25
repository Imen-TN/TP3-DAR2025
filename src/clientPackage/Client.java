// Fichier : src/clientPackage/Client.java
package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;



        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("Connecté au serveur à l'adresse " + serverAddress + " sur le port " + serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String serverResponse = in.readLine();

            if (serverResponse != null) {
                System.out.println("Message reçu du serveur : " + serverResponse);
            } else {
                System.out.println("Le serveur a fermé la connexion sans envoyer de message.");
            }

            System.out.println("Connexion fermée.");

        } catch (UnknownHostException e) {
            System.err.println("Erreur : Hôte inconnu -> " + serverAddress);
        } catch (IOException e) {
            System.err.println("Erreur de connexion ou de communication avec le serveur : " + e.getMessage());
        }
    }
}