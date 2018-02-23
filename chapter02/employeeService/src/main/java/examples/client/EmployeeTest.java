package examples.client;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import examples.model.Employee;
import examples.model.EmployeeService;

public class EmployeeTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new EmployeeService(em);

        EntityTransaction entityTransaction = em.getTransaction();

        //  1) create and persist an employee
        entityTransaction.begin();
        Employee emp = service.createEmployee(158, "John Doe", 45000);
        entityTransaction.commit();
        System.out.println("Persisted " + emp);
        
        // 2) find a specific employee
        emp = service.findEmployee(158);
        System.out.println("Found " + emp);
        
        // 3) find all employees
        Collection<Employee> emps = service.findAllEmployees();
        for (Employee e : emps) 
            System.out.println("Found Employee: " + e);
        
        // 4) update the employee
        entityTransaction.begin();
        emp = service.raiseEmployeeSalary(158, 1000);
        entityTransaction.commit();
        System.out.println("Updated " + emp);

        // 5) remove an employee
        entityTransaction.begin();
        service.removeEmployee(158);
        entityTransaction.commit();
        System.out.println("Removed Employee 158");        
        
        // 6) close the EM and EMF when done
        em.close();
        emf.close();
    }
}
