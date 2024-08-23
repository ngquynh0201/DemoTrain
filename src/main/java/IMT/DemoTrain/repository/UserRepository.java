package IMT.DemoTrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IMT.DemoTrain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUserName(String userName);
}
