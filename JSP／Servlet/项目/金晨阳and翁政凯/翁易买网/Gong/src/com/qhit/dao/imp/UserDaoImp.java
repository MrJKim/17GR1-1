package com.qhit.dao.imp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.qhit.dao.BaseDao;
import com.qhit.dao.UserDao;
import com.qhit.entity.User;

public class UserDaoImp extends BaseDao implements UserDao{
	//注册
	public int inserUser_Dao(User user) {
		String sql = "insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile,type) values(?,?,?,?,?,?,?,?)";
		String sdf = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		int i = 1;
		int executeUpdate = super.executeUpdate(sql,user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),sdf,user.getEmali(),user.getMobile(),i);
		return executeUpdate;
	}
	
	//查询用户，登陆
	public User selectUser_Dao(String name, String password) {
		String sql="select * from easybuy_user where loginName=? and password=?";
		ResultSet executeQuery = super.executeQuery(sql, name,password);
		User user = new User();
		try {
			while(executeQuery.next()){
				user.setId(executeQuery.getInt(1));
				user.setLoginName(executeQuery.getString(2));
				user.setUserName(executeQuery.getString(3));
				user.setPassword(executeQuery.getString(4));
				user.setSex(executeQuery.getInt(5));
				user.setIdentityCode(executeQuery.getDate(6));
				user.setEmali(executeQuery.getString(7));
				user.setMobile(executeQuery.getString(8));
				user.setType(executeQuery.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
