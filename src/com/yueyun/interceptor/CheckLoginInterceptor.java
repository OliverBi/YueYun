package com.yueyun.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.yueyun.domain.User;

@SuppressWarnings("serial")
public class CheckLoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		if(currentUser != null){
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
	}

}
