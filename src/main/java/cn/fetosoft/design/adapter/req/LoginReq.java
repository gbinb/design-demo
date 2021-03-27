package cn.fetosoft.design.adapter.req;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 15:19
 */
@Setter
@Getter
public class LoginReq {

	@NotBlank(message = "用户名不能为空")
	@Length(min = 4, max = 20, message = "用户名长度是4~20个字符")
	private String username;

	@NotBlank(message = "密码不能为空")
	@Length(min = 6, max = 20, message = "密码长度是6~20个字符")
	private String password;
}
