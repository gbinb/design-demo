package cn.fetosoft.design.controller;

import cn.fetosoft.design.enttiry.User;
import cn.fetosoft.design.adapter.Result;
import cn.fetosoft.design.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户业务接口
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 10:05
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 登录
	 * @return
	 */
	@PostMapping("/login")
	public Result login(@RequestParam String username,
						@RequestParam String password){
		//校验参数
		//验证登录信息
		//返回登录结果
		return null;
	}

	/**
	 * 获取个人信息
	 * @param userId
	 * @return
	 */
	@GetMapping("/getProfile")
	public Result<User> getProfile(@RequestParam String userId){
		//查询用户数据
		//返回查询结果
		return null;
	}
}
