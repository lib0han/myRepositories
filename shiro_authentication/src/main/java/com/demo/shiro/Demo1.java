package com.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

public class Demo1 {
	public static void main(String[] args) {
		//1.创建安全管理器工厂:读取相应的配置文件
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		//2.创建安全管理器：获取SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		
		//3.初始化SecurityUtils工具类:将securityManager对象 设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//4.从SecurityUtils工具中获取主题Subject
		Subject subject = SecurityUtils.getSubject();
		
		//5.认证操作（登录）
		//AuthenticationToken: 用于封装用户输入的账户信息
		//而shiro.ini中的信息相当于是数据里面存的
		try {
			AuthenticationToken token = new UsernamePasswordToken("zhangsan", "1111");
			//DisabledAccountException账户失效异常
			//ExcessiveAttemptsException尝试次数过多
			//UnknownAccountException用户不正确
			//ExpiredCredentialsException凭证过期异常
			//IncorrectCredentialsException凭证不正确
			//虽然shiro为每一种异常都提供了准确的异常类，但是在编写代码的过程中应该提示
			//用户的异常信息为模糊的。这样有利于安全。
			subject.login(token);
			
			//获取SimpleAuthenticationInfo的第一个参数：principal
			Object principal = subject.getPrincipal();
			
			//如果login方法没有任何异常，代表认证成功
			System.out.println("登录成功："+principal);
		} catch (UnknownAccountException e) {
			//账户不存在
			System.out.println("账户不存在");
		}  catch (IncorrectCredentialsException e) {
			//密码错误
			System.out.println("密码错误");
		} catch (Exception e) {
			//系统错误
			System.out.println("系统错误");
		} 
	}
}
