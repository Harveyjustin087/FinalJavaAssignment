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
}
