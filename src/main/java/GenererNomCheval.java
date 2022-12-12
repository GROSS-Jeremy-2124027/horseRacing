import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenererNomCheval {
    // Liste de chaine de caractère comportant les cinquante noms de chevaux les plus utilisés (apparement)
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
    // Méthode qui renvoie une chaine de caractère pour nommer un cheval
    public static String donneNomCheval() {
        // On prend un indice aléatoirement
        int indiceListeCheval = new Random().nextInt(listeNomCheval.size());
        // On prend le nom de cheval à cet indice
        String nomCheval = listeNomCheval.get(indiceListeCheval);
        // On supprime ce même nom
        listeNomCheval.remove(indiceListeCheval);
        // On retourne le nom
        return nomCheval;
    }
}
