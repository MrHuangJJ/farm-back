package com.lanzan.shiro;

import com.lanzan.dao.UserMapper;
import com.lanzan.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserMapper userMapper;

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		/*//获取传递过来的数据
		UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
		//拿到输入的用户账号
		String uname=usernamePasswordToken.getUsername();
		//根据用户名拿对象
		User u_user=userMapper.getUserWhereuname(uname);
		if(u_user==null){
			return null;
		}
		//认证，把认证的结果 返回
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(u_user, u_user.getUpass(), this.getName());*/
		return null;
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("进入授权");
		/*//获取用户名
		String uname=(String) principals.getPrimaryPrincipal();
		//根据用户名获取角色
		List<String> roles=new ArrayList<String>();
		//给用户添加角色
		*//*roles.add("son");
		if("admin".equals(uname)){
			roles.add("father");
		}*//*
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.addRoles(roles);*/
		return null;
	}

}
