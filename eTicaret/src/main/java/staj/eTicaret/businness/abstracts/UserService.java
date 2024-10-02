package staj.eTicaret.businness.abstracts;

import staj.eTicaret.core.entities.User;
import staj.eTicaret.core.utilities.DataResult;
import staj.eTicaret.core.utilities.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
	

}
