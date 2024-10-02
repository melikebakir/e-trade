package staj.eTicaret.businness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import staj.eTicaret.businness.abstracts.UserService;
import staj.eTicaret.core.dataAccess.UserDao;
import staj.eTicaret.core.entities.User;
import staj.eTicaret.core.utilities.DataResult;
import staj.eTicaret.core.utilities.Result;
import staj.eTicaret.core.utilities.SuccessDataResult;
import staj.eTicaret.core.utilities.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	 
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}
	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>
		(this.userDao.findByEmail(email), "Kullanıcı bulundu");
	}


}
