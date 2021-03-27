package cn.fetosoft.design.adapter.impl;

import cn.fetosoft.design.adapter.AbstractBusiService;
import cn.fetosoft.design.adapter.BusiServiceName;
import cn.fetosoft.design.adapter.NotNeedToken;
import cn.fetosoft.design.adapter.Result;
import cn.fetosoft.design.adapter.req.LoginReq;
import cn.fetosoft.design.adapter.res.LoginRes;
import cn.fetosoft.design.data.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户登录
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 15:20
 */
@Component(BusiServiceName.USER_LOGIN)
public class UserLoginImpl extends AbstractBusiService<LoginReq, LoginRes>
		implements NotNeedToken {

	@Autowired
	private UserService userService;

	@Override
	protected LoginReq parseParams(JSONObject data) {
		return JSON.toJavaObject(data, LoginReq.class);
	}

	@Override
	protected Result<LoginRes> handle(LoginReq req) {
		Result<LoginRes> result = Result.errorResult();
		if(userService.existUser(req.getUsername(), req.getPassword())){
			result = Result.successResult();
			LoginRes res = new LoginRes();
			//仅作为示例，生产可以使用Jwt生成token
			res.setToken("qwertyuiop");
			result.setData(res);
		}else{
			result.setMessage("用户名或密码不正确！");
		}
		return result;
	}
}
