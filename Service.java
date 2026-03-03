import java.io.*;
import java.util.List;

public class Service {
    public void saveToFile(List<Employee> employees, String filename){
        try (ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
            for (Employee emp: employees)
                out.writeObject(emp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));){
            while (true)
                try {
                    in.readObject();
                } catch (EOFException e) {
                    break;
                }
        }
    }
}
