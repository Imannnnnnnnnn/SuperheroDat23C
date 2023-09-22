import java.util.ArrayList;

public class Controller {
    private Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public ArrayList<Superhelt> AlleSuperhelte() {
        return database.getAllSuperhelte();
    }

    public boolean JaEllerNej(String input) {
        return input.equalsIgnoreCase("ja") || input.equalsIgnoreCase("nej");
    }

}
