public class CompteBancaire {
    private static int nombreComptes = 0;

    private String numeroCompte;
    private double solde;
    private Client proprietaire;

    public CompteBancaire(String numeroCompte, double soldeInitial, Client proprietaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.proprietaire = proprietaire;
        nombreComptes++;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " TND effectué.");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " TND effectué.");
            return true;
        }
        System.out.println("Retrait de " + montant + " TND refusé (solde insuffisant).");
        return false;
    }

    public void virement(CompteBancaire destination, double montant) {
        if (retirer(montant)) {
            destination.deposer(montant);
            System.out.println("Virement de " + montant + " TND vers " + destination.numeroCompte + " réussi.");
        } else {
            System.out.println("Virement échoué.");
        }
    }

    public void afficherDetails() {
        System.out.println("Compte : " + numeroCompte
                + " | Titulaire : " + proprietaire
                + " | Solde : " + solde + " TND");
    }

    public static int getNombreComptes() {
        return nombreComptes;
    }
}