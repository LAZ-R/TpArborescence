package fr.eni.exceptions;

/** Exception à lever si aucune concordance n'est trouvée lors d'une recherche de fichier.
 *
 * @author laz_R
 * @version 1.0
 */
public class AucunResultatTrouveException extends Exception{

    // • Méthodes

    /** Constructeur avec aucun paramètre qui incorpore le message d'erreur personnalisé.
     */
    public AucunResultatTrouveException() {
        super("Aucun fichier ne correspond.");
    }
}
