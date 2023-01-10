import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Création d'une connexion à la base de données Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre adresse e-mail : ");
        String email = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String password = scanner.nextLine();
        scanner.close();

        String name = jedis.hget("user1", "name");

        Map<String, String> user = jedis.hgetAll("user1");
        if (user.get("password").equals(password) && user.get("email").equals(email)) {
            System.out.println("Authentication successful! Vous êtes connecté en tant que : " + user.get("name"));
        } else {
            System.out.println("Authentication failed!");
        }
        // Fermeture de la connexion à la base de données
        jedis.close();
    }
}