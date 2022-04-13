package Repository;

import Model.DepartmentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {
  
  List<DepartmentsEntity> findDepartmentsEntitiesByLocationId(int a);
  @Query("SELECT u.countryId, count(u.city) FROM LocationsEntity u GROUP BY u.countryId")
  List<Object[]> getCountryCount();
  @Query("SELECT a.departmentName, b.city, b.stateProvince FROM DepartmentsEntity a JOIN LocationsEntity b ON a.locationId = b.locationId")
  List<Object[]> getDepartmentLocation();

}
