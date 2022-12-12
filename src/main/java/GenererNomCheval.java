import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenererNomCheval {
    private static List<String> listeNomCheval = new ArrayList<>(List.of("Arion",
            "Balios",
            "Basmati",
            "Ben-hur",
            "Chaplin",
            "Chocolatine",
            "Christmas",
            "Clair-obscure",
            "Coeur-de-jonquille",
            "Demi-lune",
            "Diva",
            "Ebony",
            "Elfia",
            "Flamboyant",
            "Gaillard",
            "Géricault",
            "Google",
            "Hashtag",
            "Illico",
            "Jet-lag",
            "Kahena",
            "Kimono",
            "Loshad",
            "Maestro",
            "Maracas",
            "Milky-way",
            "Naïade",
            "Olaf",
            "Passiflore",
            "Poème",
            "Pointilleux",
            "Puzzle",
            "Quadrige",
            "Risotto",
            "Rossinante",
            "Rustique",
            "Sérénade",
            "Sleipnir",
            "Soie",
            "Tamarin",
            "Trappeur",
            "Tulparue",
            "Uma",
            "Vent-du-nord",
            "Virevolte",
            "Western",
            "Wool",
            "Xanthos",
            "Youps",
            "Zigzag"));


    public static String donneNomCheval() {
        Random random = new Random();
        return listeNomCheval.get(random.nextInt(0, listeNomCheval.size()));
    }
}
