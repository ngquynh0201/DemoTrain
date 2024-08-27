package IMT.DemoTrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IMT.DemoTrain.entity.User;

public interface EmployeeRepository extends JpaRepository<User, String>{
    
}
