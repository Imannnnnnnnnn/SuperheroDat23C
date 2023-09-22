import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

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
            System.out.println("1. Tilføj superhelt");
            System.out.println("2.Vis liste over alle superhelte  ");
            System.out.println("3. Søg en superhelt");
            System.out.println("4. Rediger en superhelt");
            System.out.println("5. Afslut programmet");

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
                        fortsæt = false;
                        break;

                    case 3:
                        søgEnSuperhelt();
                        fortsæt = false;
                        break;
                    case 4:
                        redigerSuperhelt();
                        fortsæt = false;
                        break;
                    case 5:
                        System.out.println("Afslut programmet");
                        fortsæt = false;
                        scanner.close();
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
        ArrayList<Superhelt> alleSuperhelte = controller.AlleSuperhelte();
        for (Superhelt superhelt : alleSuperhelte) {
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

}
