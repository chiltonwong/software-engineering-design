package cn.ChaosWong.flash.bean.exception;


public class XSException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public String getCode() {
		return this.code;
	}

	public XSException(String code, String message, Throwable t) {
		super(message, t);
		this.code = code;
	}

	public XSException(String code, String message) {
		this(code, message, null);
	}

}
