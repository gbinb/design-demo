package cn.fetosoft.design.adapter;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.HibernateValidator;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 业务基类
 * @author guobingbing
 * @version 1.0
 * @wechat t_gbinb
 * @create 2021/3/15 15:16
 */
public abstract class AbstractBusiService<T, R> implements BusinessService<R> {

	private Validator validator;

	/**
	 * 初始化校验器Validator
	 */
	@PostConstruct
	public void initValidation(){
		validator = Validation.byProvider(HibernateValidator.class)
				.configure()
				.failFast(true)
				.buildValidatorFactory()
				.getValidator();
	}

	/**
	 * 接口实现
	 * @param requestMessage
	 * @return
	 */
	@Override
	public Result<R> doHandle(RequestMessage requestMessage) {
		Result<R> result = Result.errorResult();
		T t = null;
		try{
			t = this.parseParams(requestMessage.getData());
			this.before(t);
			result = this.passValidator(t);
			if(RespCode.SUCCESS.getCode().equals(result.getCode())) {
				result = this.handle(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			this.after(t, result.getData());
		}
		return result;
	}

	/**
	 * 参数校验
	 * @param t
	 * @param groups
	 * @return
	 */
	private Result passValidator(T t, Class<?>... groups){
		Result result = Result.successResult();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(t, groups);
		if (!constraintViolations.isEmpty()) {
			StringBuilder msg = new StringBuilder();
			for(ConstraintViolation<Object> constraint:  constraintViolations){
				msg.append(constraint.getMessage()).append(",");
			}
			result = Result.errorResult();
			result.setMessage(msg.toString());
		}
		return result;
	}

	/**
	 * 进入doHandle方法时调用
	 * @param t
	 */
	protected void before(T t){

	}

	/**
	 * 执行结束时调用
	 * @param t
	 * @param r
	 */
	protected void after(T t, R r){

	}

	/**
	 * 转换参数
	 * @param data
	 * @return
	 */
	protected abstract T parseParams(JSONObject data);

	/**
	 * 详细业务
	 * @param t
	 * @return
	 */
	protected abstract Result<R> handle(T t);
}
