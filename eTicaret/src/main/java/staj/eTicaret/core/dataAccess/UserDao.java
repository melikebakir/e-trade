package staj.eTicaret.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import staj.eTicaret.core.entities.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);

}
