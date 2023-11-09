import java.util.Comparator;

public class OprettelsesårComparator implements Comparator<Superhelt> {

    @Override
    public int compare(Superhelt helt1,Superhelt helt2) {
        return helt1.getOprettelsesår();
    }
}
