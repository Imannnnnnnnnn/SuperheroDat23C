import java.util.ArrayList;

public class Database {
    private ArrayList<Superhelt> superhelte;


    public Database() {
        this.superhelte = new ArrayList<>();

        superhelte.add(new Superhelt("Clark Kent", "Superman", "Solar flare", false, 1938, "stærk"));
        superhelte.add(new Superhelt("Tony Stark", "Iron Man", "Superhuman strength", true, 1963, "stærk"));
        superhelte.add(new Superhelt("T'Challa", "Black Panther", "Superhuman acute senses", true, 1966, "stærk"));
        superhelte.add(new Superhelt("Peter Parker ", "Spider-Man,", "Spider sense", true, 1962, "stærk"));
        superhelte.add(new Superhelt("Steve Rogers", "Captain America", "Body strength", true, 1964, "stærk"));
    }

    public void addSuperhelt(String rigtigeNavn, String superhelteNavn, String superkraft, boolean erMenneske, int oprettelsesår, String styrke) {
        Superhelt superhelt = new Superhelt(rigtigeNavn, superhelteNavn, superkraft, erMenneske, oprettelsesår, styrke);

    }

    public void addSuperhelt(Superhelt superhelt) {
        superhelte.add(superhelt);

    }

    public ArrayList<Superhelt> getAllSuperhelte() {
        return superhelte;
    }

    public ArrayList<Superhelt> søgSuperhelte(String søgeord) {
        ArrayList<Superhelt> matchendeSuperhelte = new ArrayList<>();

        for (Superhelt superhelt : superhelte) {
            if (superhelt.getSuperhelteNavn().toLowerCase().contains(søgeord.toLowerCase())) {
                matchendeSuperhelte.add(superhelt);
                return matchendeSuperhelte;
            }
        }
        return null;
    }


    public void editSuperhero(String nytSuperhelteNavn, String nytRigtigeNavn, String nySuperkraft, Boolean nyErMenneske, int nytOprettelsesår, String nyStyrke) {
        for (Superhelt superhelt : superhelte) {
            if (superhelt.getSuperhelteNavn().equalsIgnoreCase(nytSuperhelteNavn)) {

                superhelt.setSuperhelteNavn(nytSuperhelteNavn);
                superhelt.setRigtigeNavn(nytRigtigeNavn);
                superhelt.setSuperkraft(nySuperkraft);
                superhelt.setErMenneske(nyErMenneske);
                superhelt.setOprettelsesår(nytOprettelsesår);
                superhelt.setStyrke(nyStyrke);


                System.out.println("Superhelten er blevet redigeret.");
                return;
            }
        }
        System.out.println("Ingen superhelt med det navn blev fundet.");
    }

}

