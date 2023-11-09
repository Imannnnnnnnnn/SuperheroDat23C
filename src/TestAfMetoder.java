import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TestAfMetoder {
   @Test
    public void søgSuperhelte(){
        ArrayList<Superhelt> matchendeSuperhelte = new ArrayList<>();

       Superhelt heltTest = new Superhelt("Iman","Sheikh", "Svæve" ,true, 1923 ,"Stærk");
       matchendeSuperhelte.add(heltTest);

       ArrayList<Superhelt> expected = new ArrayList<>();
       expected.add(heltTest);
       assertArrayEquals(matchendeSuperhelte.toArray(), expected.toArray());
    }
}

