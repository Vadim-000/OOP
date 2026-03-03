import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    // Статический реестр всех загруженных сотрудников (симулирует БД)
    private static Map<Integer, Employee> employeesRegistry = new HashMap<>();

    private int id;
    private String name;
    private transient String password;
    private String position;

    public Employee(int id, String name, String password, String position) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.position = position;
    }

    public static Employee getFromRegistry(int id) {
        return employeesRegistry.get(id);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (employeesRegistry.containsKey(this.id))
            System.out.println("Дубликат "+this.id);
        else
            employeesRegistry.put(this.id,this);
    }
}
