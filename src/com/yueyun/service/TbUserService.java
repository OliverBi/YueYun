package com.yueyun.service;
import java.util.List;

import com.yueyun.action.UserRegisterAction;
import com.yueyun.dao.*;
import com.yueyun.tool.SecurityPassword;


public class TbUserService{
	private TbUserDAO tbUserDAO;

	public TbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}

	public void setTbUserDAO(TbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}
	
	public TbUser checkLoginInfo(String userEmail, String userPassword){
		/*boolean result = false;*/
		TbUser tbUser = null;
		TbUser loginUser = new TbUser();
		loginUser.setUserEmail(userEmail);
		loginUser.setUserPassword(SecurityPassword.encryptPassword(userPassword));
		List<TbUser> list = tbUserDAO.findByExample(loginUser);
		if(list.size() == 1){
			tbUser = list.get(0);
		}
		return tbUser;
	}
	
	public String checkRegisterInfo(TbUser registerUser){
		boolean isUserNameExist = false;
		boolean isUserEmailExist = false;
		List<TbUser> userNameList = tbUserDAO.findByUserName(registerUser.getUserName());
		if(userNameList != null && userNameList.size() > 0)
			isUserNameExist = true;
		List<TbUser> userEmailList = tbUserDAO.findByUserEmail(registerUser.getUserEmail());
		if(userEmailList != null && userEmailList.size() > 0)
			isUserEmailExist = true;
		if(isUserNameExist && isUserEmailExist)
			return UserRegisterAction.REGISTER_FAIL_USERNAME_USEREMAIL_EXIST;
		else if(isUserNameExist)
			return UserRegisterAction.REGISTER_FAIL_USERNAME_EXIST;
		else if(isUserEmailExist)
			return UserRegisterAction.REGISTER_FAIL_USEREMAIL_EXIST;
		else
			return UserRegisterAction.REGISTER_FIRSTSTEP_SUCCESS;
	}
	
	public void registerNewUser(TbUser registerUser){
		registerUser.setUserPassword(SecurityPassword.encryptPassword(registerUser.getUserPassword()));
		tbUserDAO.save(registerUser);
	}
}
