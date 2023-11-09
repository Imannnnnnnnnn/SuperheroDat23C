import java.util.Comparator;

import java.util.Comparator;

public class SuperhelteNavnComparator implements Comparator<Superhelt> {
    @Override
    public int compare(Superhelt helt1, Superhelt helt2) {
        return helt1.getSuperhelteNavn().compareTo(helt2.getSuperhelteNavn());
    }
}

