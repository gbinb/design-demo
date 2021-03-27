package cn.fetosoft.design.adapter;

/**
 * 响应码
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 13:44
 */
public enum RespCode {

	/**
	 * 定义响应码
	 */
	SUCCESS("0000", "成功"),
	ERROR("3000", "异常错误");

	private String code;
	private String message;

	RespCode(String code, String message){
		this.code = code;
		this.message = message;
	}

	public String getCode(){
		return this.code;
	}

	public String getMessage(){
		return this.message;
	}
}
