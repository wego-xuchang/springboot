package com.gitboy.shiro.conf;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gitboy.shiro.realm.MyShiroRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

	//添加创建securityManager的工厂类注入bean
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		Map<String,String> perms = new HashMap<String,String>();
		/**
		 * 设置权限认证过滤器
		 * anon : 可以匿名访问
		 * authc: 必须通过认证，授权后才能访问
		 */
		perms.put("/toLogin.do", "anon");
		perms.put("/userList.do", "authc");
		
		perms.put("/toAdd.do", "perms[user:add]");
		perms.put("/toUpdate", "perms[user:update]");
		perms.put("/toDelete", "perms[user:delete]");
		
		shiroFilterFactoryBean.setLoginUrl("/toLogin.do");
		//shiroFilterFactoryBean.setSuccessUrl("login.do");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unFunc.do");
		
		//把权限过滤map设置shiroFilterFactoryBean
		shiroFilterFactoryBean.setFilterChainDefinitionMap(perms);
		return shiroFilterFactoryBean;
	}
	
	//创建SecurityManager类的注入bean
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") MyShiroRealm shiroRealm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm);
		return securityManager;
	}
	
	//创建自定义realm域类的注入bean
	@Bean(name="shiroRealm")
	public MyShiroRealm getMyShiroRealm(){
		MyShiroRealm shiroRealm = new MyShiroRealm();
		return shiroRealm;
	}
	@Bean //提供对thymeleaf模板引擎的页面中的shiro自定义标签的支持
	public ShiroDialect getShiroDialect(){
		return new ShiroDialect();
	}
}
