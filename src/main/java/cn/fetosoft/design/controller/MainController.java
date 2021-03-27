package cn.fetosoft.design.controller;

import cn.fetosoft.design.adapter.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 服务入口
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 11:47
 */
@RequestMapping("/api/service")
@Controller
public class MainController {

	@Autowired
	private BusiServiceFactory busiServiceFactory;

	/**
	 * 请求入口
	 * @param request
	 * @return
	 */
	@PostMapping("/v1")
	@ResponseBody
	public String doRequest(HttpServletRequest request){
		Result result = Result.errorResult();
		try {
			// 读取请求内容
			String reqBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
			JSONObject reqJson = JSON.parseObject(reqBody);
			//转换成RequestMessage
			RequestMessage reqMessage = JSON.toJavaObject(reqJson, RequestMessage.class);
			//设置请求者的IP地址，此处仅做示例
			reqMessage.setRemoteIp(request.getRemoteAddr());

			//根据接口名称获取具体的接口实现bean，最后处理业务将结果返回
			BusinessService businessService = busiServiceFactory.getBusiService(reqMessage.getServiceName());
			if(businessService instanceof NotNeedToken){
				result = businessService.doHandle(reqMessage);
			}else{
				//对token进行验证，仅用于示例
				String token = reqMessage.getToken();
				if("qwertyuiop".equals(token)){
					result = businessService.doHandle(reqMessage);
				}else{
					result.setMessage("用户身份不合法，请先登录！");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			result.setMessage(e.getMessage());
		}
		return JSON.toJSONString(result);
	}
}
