package Service;

import Model.EmployeesEntity;
import Repository.DepartmentRepository;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("hrManagerService")
public class HRManagerService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository deptrepository;

    public void Test(){
        //Question 1
        System.out.println("*************************************************************");
        System.out.println("Question 1                                                  *");
        System.out.println("*************************************************************");
        List<EmployeesEntity> listSalary = employeeRepository.findEmployeesEntitiesBySalaryBetween(9000,17000);
        System.out.println("Employees with salaries between $9000 and $1700:");
        listSalary.forEach(emp -> System.out.println(emp.getFirstName() + " " + emp.getLastName()));
        //Question 2
        System.out.println("*************************************************************");
        System.out.println("Question 2                                                  *");
        System.out.println("*************************************************************");
        List<EmployeesEntity> listEndsWithA = employeeRepository.findEmployeesEntitiesByLastNameEndingWith("a");
        System.out.println("Employees who's Last Name Ends with A");
        listEndsWithA.forEach(emp-> System.out.println(emp.getFirstName() + " " + emp.getLastName()));
        //Question 2
        System.out.println("*************************************************************");
        System.out.println("Question 3                                                  *");
        System.out.println("*************************************************************");
    }
}
