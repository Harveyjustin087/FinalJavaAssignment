package Service;

import Model.DepartmentsEntity;
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
        List<Object[]> listCountriesByCountryId = deptrepository.getCountryCount();
        System.out.println("Number of cities per country:");
        listCountriesByCountryId.forEach(count-> System.out.println(count[0] + " " + count[1]));
        //Question 7
        System.out.println("*************************************************************");
        System.out.println("Question 7                                                  *");
        System.out.println("*************************************************************");
        List<Object[]> departmentLocations = deptrepository.getDepartmentLocation();
        System.out.println("Department Location Info:");
        departmentLocations.forEach(dept-> System.out.println(dept[0] + " " + dept[1] + " " + dept[2]));
        //Question 8
        System.out.println("*************************************************************");
        System.out.println("Question 8                                                  *");
        System.out.println("*************************************************************");
        List<Object[]> empInToronto = employeeRepository.employeesWorkInToronto("Toronto");
        System.out.println("Employees Working In Toronto:");
        empInToronto.forEach(emp-> System.out.println(emp[0] + " " + emp[1] + " " + emp[2]));
        //Question 9
        System.out.println("*************************************************************");
        System.out.println("Question 9                                                  *");
        System.out.println("*************************************************************");
        List<Object[]> departmentSalary = employeeRepository.averageSalaryByDepartment();
        System.out.println("Average Salaries Per Department:");
        departmentSalary.forEach(emp-> System.out.println(emp[0] + " " + emp[1]));
        //Question 10
        System.out.println("*************************************************************");
        System.out.println("Question 10                                                 *");
        System.out.println("*************************************************************");
        List<Object[]> managerCount = employeeRepository.employeesUnderManager();
        System.out.println("Number of Employees Under a Manager:");
        managerCount.forEach(emp-> System.out.println(emp[0] + " " + emp[1] + " " + emp[2] + " " + emp[3]));
    }
}
