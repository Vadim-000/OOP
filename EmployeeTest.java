import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmployeeTest {
    Service service=new Service();
    @Test
    public void testSerialized() throws Exception {
        Employee employee = new Employee(1, "John Doe", "secret123", "Developer");
        List<Employee> employees = Arrays.asList(employee);
        service.saveToFile(employees, "test_employees.dat");
        File file = new File("test_employees.dat");
        assertTrue(file.exists());
        file.delete();
    }
    @Test
    public void testLoadUniqueEmployees() throws Exception {
        Employee emp1 = new Employee(1, "Alice", "pass1", "Manager");
        Employee emp2 = new Employee(2, "Bob", "pass2", "Developer");

        List<Employee> employees = Arrays.asList(emp1, emp2);
        service.saveToFile(employees, "unique_test.dat");

        service.loadFromFile("unique_test.dat");

        assertNotNull(Employee.getFromRegistry(1));
        assertNotNull(Employee.getFromRegistry(2));
    }


}


