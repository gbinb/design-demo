package cn.fetosoft.design.adapter.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 17:37
 */
@Setter
@Getter
public class ProfileReq {

	/**
	 * 用户ID
	 */
	@NotBlank(message = "用户ID不能为空")
	private String userId;
}
