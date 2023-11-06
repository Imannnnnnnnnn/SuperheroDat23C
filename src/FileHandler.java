

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File CSVFile = new File("superheroDatabase.csv");
    private final ArrayList<Superhelt> LOADED_FILE = new ArrayList<>();

    public void saveSuperhelt(ArrayList<Superhelt> listOfHeroesToSave) throws FileNotFoundException {
        PrintStream saveToFile = new PrintStream(CSVFile);

        for (Superhelt superhelt : listOfHeroesToSave) {
            saveToFile.println(superhelt.getGetRigtigeNavn() + "," +
                    superhelt.getSuperhelteNavn() + "," +
                    superhelt.getSuperkraft() + "," +
                    superhelt.getErMenneske() + "," +
                    superhelt.getOprettelsesår() + "," +
                    superhelt.getStyrke());
        }
    }

    public ArrayList<Superhelt> loadListOfSuperhelte() throws FileNotFoundException {
        Scanner loadFromFile = new Scanner(CSVFile);

        while (loadFromFile.hasNext()) {
            String linje = loadFromFile.nextLine();
            String[] attributter = linje.split(",");

            Superhelt superheltToAdd;
            superheltToAdd = new Superhelt(attributter[0].trim(),
                    attributter[1].trim(),
                    attributter[2].trim(),
                    Boolean.parseBoolean(attributter[3].trim()),
                    Integer.parseInt(attributter[4].trim()),
                    attributter[5].trim());
            LOADED_FILE.add(superheltToAdd);
        }
        loadFromFile.close();
        return LOADED_FILE;
    }

}



