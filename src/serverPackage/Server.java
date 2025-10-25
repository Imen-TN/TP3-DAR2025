// Fichier : src/serverPackage/Server.java
package serverPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 1234;
        int clientCounter = 0; // Compteur pour le numéro d'ordre des clients

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Le serveur multi-thread est démarré et écoute sur le port " + port);

            // Boucle infinie pour accepter les connexions des clients en continu
            while (true) {
                // La méthode accept() bloque l'exécution jusqu'à ce qu'un client se connecte
                Socket clientSocket = serverSocket.accept();

                // Incrémenter le compteur pour chaque nouvelle connexion
                clientCounter++;

                // On crée une copie de la variable pour qu'elle soit "effectively final" pour le thread
                final int clientNumber = clientCounter;
                final Socket finalClientSocket = clientSocket;

                // a) Démarrer un nouveau Thread pour gérer ce client
                //    Cela permet au serveur de gérer plusieurs clients simultanément.
                new Thread(() -> {
                    try {
                        // b) Afficher les informations du client côté serveur
                        System.out.println("Client n°" + clientNumber + " connecté.");
                        System.out.println("  - Adresse IP : " + finalClientSocket.getRemoteSocketAddress());

                        // Outil pour envoyer du texte au client
                        PrintWriter out = new PrintWriter(finalClientSocket.getOutputStream(), true);

                        // c) Envoyer au client son numéro d’ordre
                        out.println("Bienvenue, vous êtes le client n°" + clientNumber);

                        // La communication avec ce client est terminée pour cet exercice.
                        // On ferme la connexion.

                    } catch (IOException e) {
                        System.err.println("Erreur de communication avec le client n°" + clientNumber + ": " + e.getMessage());
                    } finally {
                        try {
                            finalClientSocket.close();
                            System.out.println("Connexion avec le client n°" + clientNumber + " fermée.");
                        } catch (IOException e) {
                            System.err.println("Erreur lors de la fermeture du socket du client n°" + clientNumber);
                        }
                    }
                }).start(); // Démarrer le Thread
            }
        } catch (IOException e) {
            System.err.println("Erreur sur le serveur : " + e.getMessage());
        }
    }
}