package Repository;

import Model.EmployeesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;


public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {

    List<EmployeesEntity> findEmployeesEntitiesBySalaryBetween(double a, double b );
    List<EmployeesEntity> findEmployeesEntitiesByLastNameEndingWith(String a);
    List<EmployeesEntity> findEmployeesEntitiesByDepartmentId(int a);
    List<EmployeesEntity> findEmployeesEntitiesByManagerId(int a);
    @Query("SELECT a.lastName, a.departmentId, b.departmentName FROM EmployeesEntity a JOIN DepartmentsEntity b ON a.departmentId = b.departmentId JOIN LocationsEntity c ON b.locationId = c.locationId WHERE c.city = ?1")
    List<Object[]> employeesWorkInToronto(String city);
    @Query("SELECT a.departmentId, AVG(a.salary) FROM EmployeesEntity a GROUP BY a.departmentId ORDER BY a.departmentId")
    List<Object[]> averageSalaryByDepartment();
    @Query("SELECT a.firstName,a.lastName,a.departmentId,COUNT(b.employeeId) AS Total_Employees FROM EmployeesEntity a JOIN EmployeesEntity b ON b.managerId = a.employeeId GROUP BY a.firstName, a.lastName, a.departmentId")
    List<Object[]> employeesUnderManager();
}
