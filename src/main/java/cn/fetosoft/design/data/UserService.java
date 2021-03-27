package cn.fetosoft.design.data;


import cn.fetosoft.design.enttiry.User;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 10:13
 */
public interface UserService {

	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	boolean existUser(String username, String password);

	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	User findUser(String userId);
}
