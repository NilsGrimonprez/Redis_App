import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {
        // Création d'une connexion à la base de données Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // Stockage d'une valeur dans Redis
        jedis.set("mykey", "Hello World!");

        // Récupération de la valeur stockée dans Redis
        String value = jedis.get("mykey");
        System.out.println(value);

        // Fermeture de la connexion à la base de données
        jedis.close();
    }
}