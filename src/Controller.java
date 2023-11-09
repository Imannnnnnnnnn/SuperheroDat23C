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

    public void superhelteNavnComparator(){
        database.superhelteNavnComparator();
    }

    public void rigtigeNavn(){
        database.rigtigeNavn();
    }

    public void superkraft(){
        database.superkraft();
    }

    public void styrke(){
        database.styrke();
    }

    public void oprettelseår(){
        database.oprettelseår();
    }

    public boolean erMenneske(){
        return database.erMenneske();
    }
    public boolean trackChanges(Superhelt oldData, Superhelt newData){
        return database.trackChanges(oldData,newData);
    }
}
