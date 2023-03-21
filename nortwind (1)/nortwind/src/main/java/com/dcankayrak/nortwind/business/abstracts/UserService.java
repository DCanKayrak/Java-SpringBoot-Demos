package com.dcankayrak.nortwind.business.abstracts;

import com.dcankayrak.nortwind.core.entities.User;
import com.dcankayrak.nortwind.core.utilities.results.DataResult;
import com.dcankayrak.nortwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
