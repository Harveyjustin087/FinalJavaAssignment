package Repository;

import Model.EmployeesEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;


public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {

    List<EmployeesEntity> findEmployeesEntitiesBySalaryBetween(double a, double b );
    List<EmployeesEntity> findEmployeesEntitiesByLastNameEndingWith(String a);
    List<EmployeesEntity> findEmployeesEntitiesByDepartmentId(int a);
    List<EmployeesEntity> findEmployeesEntitiesByManagerId(int a);
}
