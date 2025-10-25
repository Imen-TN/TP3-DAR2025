
---

# ☕ TP3-DAR2025: Applications Réparties en Java

*Un projet client-serveur utilisant les Sockets Java pour le cours de LSI3.*

**🧑‍💻 Auteur :** Imen Bouchelliga  
**🎓 Classe :** LSI3 - Groupe 2-2

---

## 📝 Aperçu du Projet

Ce projet universitaire s'inscrit dans le cadre du module d'Applications Réparties. L'objectif principal est de faire évoluer une application client-serveur simple pour qu'elle puisse gérer plusieurs clients simultanément grâce au **multi-threading**. Le serveur est capable d'accepter des connexions en continu et de traiter chaque client dans un thread séparé.

## 📂 Structure du Projet

Le projet est organisé avec une séparation claire entre le code du client et du serveur, chacun dans son propre package pour une meilleure modularité.

*   `src/serverPackage/` : Contient la classe `Server.java`, qui gère les connexions entrantes et la création des threads.
*   `src/clientPackage/` : Contient la classe `Client.java`, qui se connecte au serveur pour recevoir un message.

---

### 1️⃣ Activité 3.1: Serveur Multi-threads 🔗
*(Branche: `Activite_3_1`)*

> L'objectif est de transformer le serveur pour qu'il puisse accepter et gérer plusieurs clients en parallèle. Pour cela, chaque nouvelle connexion client est gérée dans un **thread dédié**. Le serveur attribue un numéro d'ordre à chaque client (client n°1, n°2, etc.) et lui envoie un message de bienvenue personnalisé contenant ce numéro. Cette approche permet au serveur de rester disponible pour de nouveaux clients sans être bloqué par le traitement d'un client existant.

---

## 🚀 Comment Compiler et Exécuter

Pour lancer l'application, assurez-vous d'avoir le **JDK (Java Development Kit)** installé sur votre machine. Les commandes suivantes doivent être exécutées depuis la racine de votre projet (`TP3-DAR2025`).

**Étape Préliminaire :** Créez un répertoire `bin` à la racine du projet pour stocker les fichiers compilés (`.class`).

```bash
mkdir bin
```

### Côté Serveur 🖥️
Ouvrez un terminal et exécutez les commandes suivantes :

```bash
# 1. Compiler tout le code source (serveur et client) dans le répertoire bin
javac -d bin src/serverPackage/Server.java src/clientPackage/Client.java

# 2. Lancer le serveur (il se mettra en attente de connexions)
java -cp bin serverPackage.Server
```

### Côté Client 💻
Ouvrez un **nouveau terminal** (ou plusieurs pour simuler plusieurs clients) et exécutez cette commande :

```bash
# 1. Lancer un client pour se connecter au serveur
#    (La compilation a déjà été faite à l'étape précédente)
java -cp bin clientPackage.Client
```
Vous pouvez lancer la dernière commande plusieurs fois pour voir comment le serveur gère plusieurs clients et leur attribue des numéros d'ordre différents.
