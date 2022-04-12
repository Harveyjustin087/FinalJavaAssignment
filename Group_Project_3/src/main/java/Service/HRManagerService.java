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
        //Question 3
        System.out.println("*************************************************************");
        System.out.println("Question 3                                                  *");
        System.out.println("*************************************************************");
        List<EmployeesEntity> listEmployeesAccounting = employeeRepository.findEmployeesEntitiesByDepartmentId(11);
        System.out.println("Employees in the Accounting Department:");
        listEmployeesAccounting.forEach(emp-> System.out.println(emp.getFirstName() + " " + emp.getLastName()));
        //Question 4
        System.out.println("*************************************************************");
        System.out.println("Question 4                                                  *");
        System.out.println("*************************************************************");
        List<EmployeesEntity> listEmployeesWithManager = employeeRepository.findEmployeesEntitiesByManagerId(108);
        System.out.println("Employees With Manager 108:");
        listEmployeesWithManager.forEach(emp -> System.out.println(emp.getFirstName() + " " + emp.getLastName()));
        //Question 5
        System.out.println("*************************************************************");
        System.out.println("Question 5                                                  *");
        System.out.println("*************************************************************");
        List<DepartmentsEntity> listDeptByLocation = deptrepository.findDepartmentsEntitiesByLocationId(1700);
        System.out.println("Departments with Location ID 1700:");
        listDeptByLocation.forEach(dept-> System.out.println(dept.getDepartmentName()));
        //Question 6
        System.out.println("*************************************************************");
        System.out.println("Question 6                                                  *");
        System.out.println("*************************************************************");
    }
}
