package cn.fetosoft.design.adapter;

import lombok.Getter;
import lombok.Setter;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 10:13
 */
@Setter
@Getter
public class Result<T>{

	/**
	 * 响应码
	 */
	private String code;

	/**
	 * 响应信息
	 */
	private String message;

	/**
	 * 返回的业务数据
	 */
	private T data;


	public Result(RespCode respCode){
		this.code = respCode.getCode();
		this.message = respCode.getMessage();
	}

	public static <T> Result<T> successResult(){
		return new Result<>(RespCode.SUCCESS);
	}


	public static <T> Result<T> errorResult(){
		return new Result<>(RespCode.ERROR);
	}
}
