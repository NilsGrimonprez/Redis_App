import redis.clients.jedis.Jedis;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Création d'une connexion à la base de données Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // Stockage d'une valeur dans Redis
        jedis.set("mykey", "Hello World!");

        // Récupération de la valeur stockée dans Redis
        String value = jedis.get("mykey");
        System.out.println(value);

        // Création et initialisation d'une nouvelle clé-valeur dans Redis
        jedis.lpush("maListe", "valeur1");
        jedis.lpush("maListe", "valeur2");
        jedis.lpush("maListe", "valeur3");

        // Récupération de la liste dans Redis
        List<String> list = jedis.lrange("maListe", 0, -1);
        System.out.println(list); // affiche ["valeur3", "valeur2", "valeur1"]

        // Fermeture de la connexion à la base de données
        jedis.close();
    }
}