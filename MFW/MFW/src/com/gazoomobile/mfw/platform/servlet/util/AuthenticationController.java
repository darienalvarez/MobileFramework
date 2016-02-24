/**
 * 
 */
package com.gazoomobile.mfw.platform.servlet.util;

import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.service.UserService;
import com.gazoomobile.mfw.platform.service.impl.UserServiceImpl;
import com.gazoomobile.mfw.platform.web.MfwSecutiryException;

/**
 * @author darien
 *
 */
public class AuthenticationController {
	
	private UserService userService;
	
	public AuthenticationController() {
		userService = new UserServiceImpl();
	}
	
	public boolean isAuthenticated(String username, String password){
		try {
			User user = userService.login(username, password);
			
			if(user!= null)
				return true;
		} catch (MfwSecutiryException e) {
			e.printStackTrace();
		}
		return false;
	}

}
