import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe permettant de générer aléatoirement un nom qui sera associé à un cheval.
 */
public class GenererNomCheval {
    /**
     * Attribut static étant une liste permettant de regrouper les noms possibles pour un cheval.
     */
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

    /**
     * Méthode static permettant de retourner un nom choisit aléatoirement dans la liste. Le nom alors choisit sera aussi
     * supprimé de la liste.
     * @return Une chaine de caractère correspondant au nom du cheval.
     */
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
