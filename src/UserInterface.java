import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private ArrayList<Superhelt> superhelte;

    private Scanner scanner;
    private Database database;
    private Controller controller;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.database = new Database();
        this.controller = new Controller(database);
    }

    public void start() {
        boolean fortsæt = true;

        while (fortsæt) {

            System.out.print("Velkommen til superheltenes verden ");
            System.out.println("\nMENU: ");
            System.out.println("1.Opret superhelt");
            System.out.println("2.Vis alle superhelte");
            System.out.println("3.Vis en superhelt!!");
            System.out.println("4. Rediger superhelt");
            System.out.println("5. Slet superhelt");
            System.out.println("6. sorteret liste af superheltene");
            System.out.println("7. afslut programmet");

            System.out.println("Vælg en valgmulighed: ");


            try {
                int menuValg = scanner.nextInt();
                scanner.nextLine();

                switch (menuValg) {
                    case 1:
                        tilføjSuperhelt();

                        break;
                    case 2:

                        visListeOverAlleSuperhelte();

                        break;

                    case 3:
                        søgEnSuperhelt();

                        break;
                    case 4:
                        redigerSuperhelt();

                        break;
                    case 5:
                        sletSuperhelt();
                        System.out.println("Slet superhelt");
                        break;
                    case 6:
                        System.out.println("Menu af sorteret valgmuligheder, vælg en af disse: ");
                        System.out.println("1. Sorteret efter superhelte navn");
                        System.out.println("2. Sorteret efter rigtige navn");
                        System.out.println("3. Sorteret efter superkrafter");
                        System.out.println("4. Sorteret efter styrker");
                        System.out.println("5. Sorteret efter oprettelsesår");
                        System.out.println("6. Sorteret om hvorvidt superhelten er menneske eller ej");
                        sorted();
                    case 7:
                        System.out.println("Afslut programmet");
                        fortsæt = false;
                        scanner.close();
                        //TO DO
                        controller.saveSuperhelt();
                        break;

                    default:
                        System.out.println(" Vælg igen");
                }
            } catch (InputMismatchException e) {
                System.out.println("Indtast en gyldig værdi");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }

        }

    }

    public void sorted(){
        int SortedMenu = scanner.nextInt();
        scanner.nextLine();

        switch (SortedMenu){
            case 1:
                controller.superhelteNavnComparator();
                break;
            case 2:
                controller.rigtigeNavn();
                break;
            case 3:
                controller.superkraft();
                break;
            case 4:
                controller.styrke();
                break;
            case 5:
                controller.oprettelseår();
                break;
            case 6:
                controller.erMenneske();

            default:
                System.out.println("Ugyldigt input, prøv igen.");

        }
    }

    public void tilføjSuperhelt() {
        while (true) {
            System.out.print("\nIndtast heltenavn: ");
            String superhelteNavn = scanner.nextLine();
            System.out.println("\n Indtast virkeligt navn: ");
            String rigtigeNavn = scanner.nextLine();
            System.out.print("Er superhelten et menneske? (ja/nej): ");
            boolean erMenneske = scanner.nextLine().equalsIgnoreCase("ja");

            System.out.print("Indtast superkrafter: ");
            String superkraft = scanner.nextLine();

            int oprettelsesår = 0;

            while (true) {
                System.out.print("Indtast oprindelsesår: ");
                String input = scanner.nextLine();

                if (input.length() == 4 && input.matches("\\d+")) {
                    oprettelsesår = Integer.parseInt(input);
                    break;
                } else {
                    System.out.print("Ugyldigt input ");
                }
            }

            System.out.print("Hvilken styrke har din superhelt: ");
            String styrke = scanner.nextLine();

            Superhelt superhelt = new Superhelt(rigtigeNavn, superhelteNavn, superkraft, erMenneske, oprettelsesår, styrke);
            database.addSuperhelt(superhelt);

            System.out.println("Vil du lave en ny superhelt? (ja/nej): ");
            String igen = scanner.nextLine();
            if (!igen.equalsIgnoreCase("ja")) {
                break;
            }
        }
    }


    public void visListeOverAlleSuperhelte() {
        SuperhelteavnOgStyrkeComparator comparison = new SuperhelteavnOgStyrkeComparator();
        Collections.sort(superhelte, comparison);
        ArrayList<Superhelt> seAlleSuperhelte = controller.seAlleSuperhelte();
        for (Superhelt superhelt : seAlleSuperhelte) {
            System.out.println(superhelt);
        }
    }

    public void søgEnSuperhelt() {
        System.out.println("Søg ved hjælp af et eller flere bogstaver på den superhelt du vil finde: ");

        String søgeord = scanner.nextLine();
        ArrayList<Superhelt> matchendeSuperhelte = database.søgSuperhelte(søgeord);


        if (matchendeSuperhelte.isEmpty()) {
            System.out.println("Ingen superhelte blev fundet.");
        } else {
            System.out.println("Matchende superhelte:");
            for (int i = 0; i < matchendeSuperhelte.size(); i++) {
                System.out.println((i + 1) + ". " + matchendeSuperhelte.get(i).getSuperhelteNavn());

                if (matchendeSuperhelte == null) {

                }
            }
        }
    }

    public void redigerSuperhelt() {


        System.out.println("Indtast superhelte navnet på den superhelt, du vil redigere: ");
        String nytSuperhelteNavn = scanner.nextLine();

        System.out.println("Indtast rigtige navn på den superhelt, du vil redigere: ");
        String nytRigtigeNavn = scanner.nextLine();

        System.out.print("Indtast en ny superkraft: ");
        String nySuperkraft = scanner.nextLine();

        System.out.print("Er superhelten et menneske eller ej? ja/nej: ");
        Boolean nyErMenneske = scanner.nextLine().equalsIgnoreCase("ja");

        System.out.print("Indtast et nyt oprettelsesår: ");
        int nytOprettelsesår = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Indtast en ny styrke: ");
        String nyStyrke = scanner.nextLine();


        database.editSuperhero(nytSuperhelteNavn, nytRigtigeNavn, nySuperkraft, nyErMenneske, nytOprettelsesår, nyStyrke);
    }

    public void sletSuperhelt() {
        System.out.println("Indtast navnet på den superhelt, du vil slette: ");
        String superhelteNavn = scanner.nextLine();
        boolean slettet = controller.sletSuperhelt(superhelteNavn);


        if (slettet) {
            System.out.println(superhelteNavn + " blev slettet.");
        } else {
            System.out.println(superhelteNavn + " blev ikke fundet.");
        }
    }

    public boolean trackChanges() {

        boolean changesDetected = true;

        if (changesDetected) {
            System.out.println("Data blev gemt.");
        } else {
            System.out.println("Ingen ændringer i data, intet blev gemt.");
        }

        return changesDetected;
    }
}



