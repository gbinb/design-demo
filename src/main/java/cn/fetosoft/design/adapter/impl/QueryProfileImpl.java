package cn.fetosoft.design.adapter.impl;

import cn.fetosoft.design.adapter.AbstractBusiService;
import cn.fetosoft.design.adapter.BusiServiceName;
import cn.fetosoft.design.adapter.Result;
import cn.fetosoft.design.adapter.req.ProfileReq;
import cn.fetosoft.design.adapter.res.ProfileRes;
import cn.fetosoft.design.data.UserService;
import cn.fetosoft.design.enttiry.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 查询用户个人信息
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 17:36
 */
@Component(BusiServiceName.QUERY_PROFILE)
public class QueryProfileImpl extends AbstractBusiService<ProfileReq, ProfileRes> {

	@Autowired
	private UserService userService;

	@Override
	protected ProfileReq parseParams(JSONObject data) {
		return JSON.toJavaObject(data, ProfileReq.class);
	}

	@Override
	protected Result<ProfileRes> handle(ProfileReq req) {
		Result<ProfileRes> result = Result.errorResult();
		User user = userService.findUser(req.getUserId());
		if(user!=null){
			ProfileRes res = new ProfileRes();
			BeanUtils.copyProperties(user, res);
			result = Result.successResult();
			result.setData(res);
		}else{
			result.setMessage("用户不存在!");
		}
		return result;
	}
}
