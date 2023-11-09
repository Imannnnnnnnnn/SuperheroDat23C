import java.util.Comparator;

public class SuperhelteavnOgStyrkeComparator implements Comparator<Superhelt> {

    @Override
    public int compare(Superhelt helt1, Superhelt helt2){
        int comparison = helt1.getSuperhelteNavn().compareTo(helt2.getSuperhelteNavn());
        if(comparison == 0){
            return helt1.getStyrke().compareTo(helt2.getStyrke());
        }
        return comparison;
    }
}
