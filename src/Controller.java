import java.util.ArrayList;

public class Controller {
    private Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public void saveSuperhelt() {
        this.database.saveSuperhelt();
    }

    public ArrayList<Superhelt> seAlleSuperhelte() {
        return database.getseAllSuperhelte();
    }

    public boolean JaEllerNej(String input) {
        return input.equalsIgnoreCase("ja") || input.equalsIgnoreCase("nej");
    }

    public boolean sletSuperhelt(String superhelteNavn) {
        return database.sletSuperhelt(superhelteNavn);

    }
}
