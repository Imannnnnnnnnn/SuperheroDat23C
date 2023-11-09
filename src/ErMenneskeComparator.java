import java.util.Comparator;

public class ErMenneskeComparator implements Comparator<Superhelt> {
    @Override
    public int compare(Superhelt helt1, Superhelt helt2) {
        return Boolean.compare(helt1.getErMenneske(),(helt2.getErMenneske()));
    }
}

