public class Superhelt {
    private String superhelteNavn;
    private String rigtigeNavn;
    private boolean erMenneske;
    private String superkraft;
    private int oprettelsesår;
    private String styrke;

    public Superhelt(String rigtigeNavn, String superhelteNavn, String superkraft, boolean erMenneske, int oprettelsesår, String styrke) {
        this.rigtigeNavn = rigtigeNavn;
        this.superhelteNavn = superhelteNavn;
        this.superkraft = superkraft;
        this.erMenneske = erMenneske;
        this.oprettelsesår = oprettelsesår;
        this.styrke = styrke;
    }

    public String toString() {
        return
                " Rigtige Navn: " + rigtigeNavn +
                        " Superhelte Navn: " + superhelteNavn +
                        " Menneske: " + (erMenneske ? "Ja" : "Nej") +
                        " Superkraft: " + superkraft +
                        " Oprettelsesår: " + oprettelsesår +
                        " Styrke: " + styrke + "" + "\n";
    }


    public String getGetRigtigeNavn() {
        return rigtigeNavn;
    }

    public String getSuperhelteNavn() {
        return superhelteNavn;
    }

    public boolean getErMenneske() {
        return erMenneske;
    }

    public String getSuperkraft() {
        return superkraft;
    }

    public int getOprettelsesår() {
        return oprettelsesår;
    }

    public String getStyrke() {
        return styrke;
    }

    public void setRigtigeNavn(String nytrigtigeNavn) {
        this.rigtigeNavn = nytrigtigeNavn;
    }

    public void setSuperhelteNavn(String nytsuperhelteNavn) {
        this.superhelteNavn = nytsuperhelteNavn;
    }

    public void setSuperkraft(String nySuperkraft) {
        this.superkraft = nySuperkraft;
    }

    public void setErMenneske(boolean nyErMenneske) {
        this.erMenneske = nyErMenneske;
    }

    public void setOprettelsesår(int nytOprettelsesår) {
        this.oprettelsesår = nytOprettelsesår;
    }

    public void setStyrke(String nyStyrke) {
        this.styrke = nyStyrke;
    }

}
