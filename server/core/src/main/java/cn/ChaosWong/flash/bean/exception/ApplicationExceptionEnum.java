package cn.ChaosWong.flash.bean.exception;


public enum ApplicationExceptionEnum implements ServiceExceptionEnum{


	WRITE_ERROR(500,"渲染界面错误"),


	FILE_READING_ERROR(400,"FILE_READING_ERROR!"),
	FILE_NOT_FOUND(400,"FILE_NOT_FOUND!"),


	REQUEST_NULL(400, "请求有错误"),
	SERVER_ERROR(500, "服务器异常"),

	TASK_CONFIG_ERROR(500, "定时任务配置错误");

	ApplicationExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;

	private String message;

	@Override
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
