import java.util.Comparator;

    public class StyrkeComparator implements Comparator<Superhelt> {
        @Override
        public int compare(Superhelt helt1, Superhelt helt2) {
            return helt1.getStyrke().compareTo(helt2.getStyrke());
        }
    }


