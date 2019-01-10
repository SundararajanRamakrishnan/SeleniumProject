package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.UserBean;
import com.training.dao.ELearningDAO;

public class RegistrationDataProviders {
	
	@DataProvider(name = "db-inputs")
	public Object [][] getUsersData() {

		List<UserBean> list = new ELearningDAO().getUsers(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(UserBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName();
			obj[2] = temp.getEmail(); 
			obj[3] = temp.getUserName();
			obj[4] = temp.getPwd(); 
			obj[5] = temp.getCPwd();
			obj[6] = temp.getPhone(); 
			obj[7] = temp.getLang();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}

}
