import java.io.FileWriter;
import java.io.IOException;

    public class DataStorage {
        private String filePath;

        public DataStorage(String filePath) {
            this.filePath = filePath;
        }

        public void saveData(Superhelt data) {
            try {
                FileWriter writer = new FileWriter(filePath, true);
                writer.write(data.getSuperhelteNavn() + "," + data.getStyrke() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
