package com.demo.realm;

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
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	//授权方法：获取授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("ִ执行授权方法...");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//资源的授权码
		//info.addStringPermission("productAdd");
		
		//通配符的授权
		info.addStringPermission("product:*");
		
		//角色的授权码
		info.addRole("admin");
		
		return info;
	}
	
	//认证方法：获取认证信息
	//完成身份认证(从数据库中取数据)并且返回认证信息
	//如果身份验证失败 返回null
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//判断用户名或密码
		//1.获取用户输入的账户信息
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		String username = token.getUsername();
		//2.模拟数据库的账户信息
		String name = "lisi";
		String password = "39cb1ef74671dc8ad4efe556e061add8";
		
		
		if(!username.equals(name)){
			return null; // shiro底层自动抛出UnknownAccountException
		}
		
		return new SimpleAuthenticationInfo("jack",password,"");
	}

}
