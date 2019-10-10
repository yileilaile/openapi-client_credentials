package com.instai.open.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("conss")
public class Conss {

	/*
	 * 接口访问统一异常状态code
	 * -1接口未知异常；0失败；1接口正常；2token为空或无效；3token超时；4无访问权限;5用户不存在;6长时token到期;7参数为空
	 */
	public static final Integer SERVICE_ACCESS_CODE_SUCCESS = 1;
	public static final Integer SERVICE_ACCESS_CODE_error = -1;
	public static final Integer SERVICE_ACCESS_CODE_FAIL = 0;
	public static final Integer SERVICE_ACCESS_CODE_TOKEN_INVALID = 2;
	public static final Integer SERVICE_ACCESS_CODE_TOKEN_TIMEOUT = 3;
	public static final Integer SERVICE_ACCESS_CODE_NO_PERMISSION = 4;
	public static final Integer SERVICE_ACCESS_CODE_USER_INVALID = 5;
	public static final Integer SERVICE_ACCESS_CODE_SERVICETOKEN_INVALID = 6;
	public static final Integer SERVICE_ACCESS_PARAMETER_IS_NULL = 7;


	/**
	 * token级别：service级临时token用于接口调用；loginAuth级别长时token用于获取临时token
	 */
	public static final String TOKEN_TYPE_SERVICE = "serviceLevel";

	public static final String TOKEN_TYPE_LOGINAUTH = "loginAuthLevel";


}
