package fr.eni.bo;

import fr.eni.exceptions.AucunResultatTrouveException;

import java.util.ArrayList;
import java.util.List;

/** Classe qui représente un Répertoire (qui est un Elément).
 *
 * @author laz_R
 * @version 1.0
 */
public class Repertoire extends Element{

    // • Déclatation

    // Attributs d'instance
    private List<Element> liste_d_elements = new ArrayList<>();

    // • Méthodes

    /** Constructeur avec tous les paramètres.
     *
     * @param nom - String
     */
    public Repertoire(String nom) {
        super(nom);
    }

    // Getters & Setters
    public List<Element> getListe_d_elements() {
        return liste_d_elements;
    }

    // Mes méthodes

    /** Méthode qui permets d'ajouter un élément à la liste d'éléments de ce répertoire.
     *
     * @param element_a_ajouter - Element
     */
    public void addElements(Element element_a_ajouter) {
        element_a_ajouter.path = this.path +  element_a_ajouter.path;
        this.liste_d_elements.add(element_a_ajouter);
    }


    /** Sous-méthode qui recherche le nombre d'itérations d'un String présentes dans la liste de ce répertoire.
     *  Retourne le nombre d'itérations.
     *  Affiche les éventuelles itérations trouvées.
     *
     * @param nom_element_a_rechercher - String
     * @return iterations - int
     */
    public int sousSousRecherche(String nom_element_a_rechercher){
        int iterations = 0;
        for (int i = 0; i < this.liste_d_elements.size(); i++) {
            if (this.liste_d_elements.get(i) instanceof Repertoire) {
                if (this.liste_d_elements.get(i).getNom().equalsIgnoreCase(nom_element_a_rechercher)) {
                    System.out.printf("Dossier trouvé : %s%n", liste_d_elements.get(i).path);
                    iterations += 1;
                }
                else {
                    ((Repertoire) this.liste_d_elements.get(i)).sousSousRecherche(nom_element_a_rechercher);
                }
            }
            else {
                if (this.liste_d_elements.get(i).getNom().equalsIgnoreCase(nom_element_a_rechercher)) {
                    System.out.printf("Fichier trouvé : %s%n", liste_d_elements.get(i).path);
                    iterations += 1;
                }
            }
        }
        return iterations;

    }

    /** Sous-méthode qui recherche des itérations sur le répertoire, et lève une exception si aucune itération n'a été trouvée.
     *
     * @param nom_element_a_rechercher - String
     * @throws AucunResultatTrouveException - Exception
     */
    public void sousRecherche(String nom_element_a_rechercher) throws AucunResultatTrouveException {
        int iterations = sousSousRecherche(nom_element_a_rechercher);
        if (iterations == 0){
            throw new AucunResultatTrouveException();
        }
    }

    /** Méthode de recherche d'un élément dans la liste des éléments de ce répertoire, avec traitement de l'exception si aucun résultat trouvé.
     *
     * @param nom_element_a_rechercher - String
     */
    public void recherche(String nom_element_a_rechercher) {

        System.out.printf("Recherche %s%n",nom_element_a_rechercher);

        if (this.nom.equalsIgnoreCase(nom_element_a_rechercher)) {
            System.out.println(this.path);
        }
        else {
            try {
                sousRecherche(nom_element_a_rechercher);
            } catch (AucunResultatTrouveException e) {
                System.err.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
}
