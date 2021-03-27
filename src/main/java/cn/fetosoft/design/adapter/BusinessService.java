package cn.fetosoft.design.adapter;

/**
 * 业务接口
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 14:36
 */
public interface BusinessService<R> {

	/**
	 * 业务处理
	 * @param requestMessage
	 * @return
	 */
	Result<R> doHandle(RequestMessage requestMessage);
}
