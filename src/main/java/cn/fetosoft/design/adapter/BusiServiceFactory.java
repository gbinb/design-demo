package cn.fetosoft.design.adapter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 14:39
 */
@Component
public class BusiServiceFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 从spring上下文中获取接口实现的bean
	 * @param beanName
	 * @return
	 */
	public BusinessService getBusiService(String beanName){
		return this.applicationContext.getBean(beanName, BusinessService.class);
	}
}
