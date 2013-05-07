package com.yueyun.service;
import java.util.List;

import com.yueyun.action.UserRegisterAction;
import com.yueyun.dao.TbUser;
import com.yueyun.dao.TbUserDAO;
import com.yueyun.dao.TbUserplaylist;
import com.yueyun.dao.TbUserplaylistDAO;
import com.yueyun.domain.User;
import com.yueyun.tool.SecurityPassword;


public class TbUserService{
	public static final String DEFAULT_PLAY_LIST = "默认列表";
	
	private TbUserDAO tbUserDAO;
	
	private TbUserplaylistDAO tbUserplaylistDAO;

	public TbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}

	public void setTbUserDAO(TbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}
	
	public TbUserplaylistDAO getTbUserplaylistDAO() {
		return tbUserplaylistDAO;
	}

	public void setTbUserplaylistDAO(TbUserplaylistDAO tbUserplaylistDAO) {
		this.tbUserplaylistDAO = tbUserplaylistDAO;
	}
	
	public User getUserInfo(int userId){
		User user = null;
		TbUser tbUser = tbUserDAO.findById(userId);
		if(tbUser != null){
			user = new User();
			user.setUserId(tbUser.getUserId());
			user.setUserName(tbUser.getUserName());
			user.setUserEmail(tbUser.getUserEmail());
			user.setUserGender(tbUser.getUserGender());
			user.setUserAvatarUrl(tbUser.getUserAvatarUrl());
			user.setUserDescription(tbUser.getUserDescription());
			user.setUserBirthday(tbUser.getUserBirthday());
		}
		return user;
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
	
	public TbUser registerNewUser(TbUser registerUser){
		registerUser.setUserPassword(SecurityPassword.encryptPassword(registerUser.getUserPassword()));
		tbUserDAO.save(registerUser);
		TbUser tbUser = null;
		List<TbUser> userList = tbUserDAO.findByExample(registerUser);
		if(userList.size() == 1){
			tbUser = userList.get(0);
		}
		
		TbUserplaylist tbUserPlayListItem = new TbUserplaylist();
		tbUserPlayListItem.setUserId(tbUser.getUserId());
		tbUserPlayListItem.setUserPlayListName(DEFAULT_PLAY_LIST);
		tbUserplaylistDAO.save(tbUserPlayListItem);
		
		return tbUser;
	}
}
