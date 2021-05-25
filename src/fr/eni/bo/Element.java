package fr.eni.bo;

/** Classe qui représente un Elément
 *
 * @author laz_R
 * @version 1.0
 */
public class Element {

    // • Déclaration

    // Attributs d'instance
    protected String nom;
    protected String path;

    // • Méthodes

    /** Constructeur avec tous les paramètres
     *  Ajoute son propre nom à son PATH
     *
     * @param nom String
     */
    public Element(String nom) {
        this.nom = nom;
        this.path = "\\" + this.nom;
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    // Overrides
    @Override
    public String toString() {
        return "Element{" +
                "nom='" + nom + '\'' +
                '}';
    }

    // Mes méthodes

    /** Méthode d'affichage du PATH de cet élément
     */
    public void afficherPath() {
        System.out.println(this.path);
    }
}
