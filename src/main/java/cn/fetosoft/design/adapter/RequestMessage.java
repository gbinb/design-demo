package cn.fetosoft.design.adapter;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 请求报文封装
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 13:56
 */
@Setter
@Getter
public class RequestMessage {

	/**
	 * 接口名称，也是每个接口实现中bean的名称
	 */
	private String serviceName;

	/**
	 * 认证信息
	 */
	private String token;

	/**
	 * 请求者IP
	 */
	private String remoteIp;

	/**
	 * 具体业务参数
	 */
	private JSONObject data;
}
