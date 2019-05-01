package com.gitboy.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gitboy.shiro.pojo.Function;
import com.gitboy.shiro.pojo.User;
import com.gitboy.shiro.service.UserService;


public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	UserService userService;
	/**
	 * 授权的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行了授权的方法");
		//获取用户对象
		User user = (User)principals.getPrimaryPrincipal();
		//获取用户权限列表
		List<String> perms = new ArrayList<String>();
		//根据用户id获取权限类别
		List<Function> functions = userService.findFuncByUserId(user.getUserId());
		if(functions != null){
			for(Function func : functions){
				perms.add(func.getFuncCode());
			}
		}
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(perms); //把用户的所有权限类别添加到对象中
		//authorizationInfo.addRoles(roles); //把所有的用户角色添加到对象中
		return authorizationInfo;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行了认证方法。。。。");
		String username = token.getPrincipal().toString();
		System.out.println("username:" + username);
		//需要通过用户名查询用户密码
		User user = userService.findByUsername(username);
		String password = user.getPassword();
		//把用户名和密码封装到AuthenticationInfo对象中
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,password,"shiroRealm");
		return authenticationInfo;
	}

}
