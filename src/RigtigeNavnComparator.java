import java.util.Comparator;

public class RigtigeNavnComparator implements Comparator<Superhelt> {
    @Override
    public int compare(Superhelt helt1, Superhelt helt2) {
        return helt1.getRigtigeNavn().compareTo(helt2.getRigtigeNavn());
    }
}











