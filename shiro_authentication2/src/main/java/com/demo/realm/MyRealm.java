package com.demo.realm;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {
	//授权方法：获取授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
System.out.println("ִ执行授权方法...");
		String username =arg0.getPrimaryPrincipal().toString();
		System.out.println("授权-------------------");
		System.out.println("username==========="+username);
		//根据用户名到数据库查询用户对应的权限信息----模拟
		List<String> permission = new ArrayList<String>();
		permission.add("user:add");
		permission.add("user:delete");
		permission.add("user:update");
		permission.add("user:find");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (String string : permission) {
			info.addStringPermission(string);
		}
		return info;
	}
	
	//认证方法：获取认证信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//判断用户名或密码
		//1.获取用户输入的账户信息
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		String username = token.getUsername();
		//2.模拟数据库的账户信息
		String name = "zhangsan";
		String password = "1111";
		
		
		if(!username.equals(name)){
			return null; // shiro底层自动抛出UnknownAccountException
		}
		return new SimpleAuthenticationInfo("jack",password,"");
	}

}
