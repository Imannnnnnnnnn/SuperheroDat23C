import java.util.Comparator;


    public class SuperkraftComparator implements Comparator<Superhelt> {
        @Override
        public int compare(Superhelt helt1, Superhelt helt2) {
            return helt1.getSuperkraft().compareTo(helt2.getSuperkraft());
        }
    }


