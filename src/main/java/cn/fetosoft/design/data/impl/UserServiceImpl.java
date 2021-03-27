package cn.fetosoft.design.data.impl;

import cn.fetosoft.design.data.UserService;
import cn.fetosoft.design.enttiry.User;
import org.springframework.stereotype.Service;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 14:27
 */
@Service
public class UserServiceImpl implements UserService {


	@Override
	public boolean existUser(String username, String password) {
		return "admin".equals(username) && "000000".equals(password);
	}

	@Override
	public User findUser(String userId) {
		if("123".equals(userId)){
			User user = new User();
			user.setName("t_gbinb");
			user.setAge(37);
			user.setNickName("米酒");
			return user;
		}
		return null;
	}
}
