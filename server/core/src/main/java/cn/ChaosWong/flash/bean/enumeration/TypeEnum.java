package cn.ChaosWong.flash.bean.enumeration;

public class TypeEnum {


	public enum DataItemShowType {

		TEXT(0), SELECT(1), DATE(2);

		private int value;

		private DataItemShowType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}


	public enum InvokeTypeEnum {


		LOCAL("local"), REMOTE("remote");

		private String value;

		private InvokeTypeEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}


	public enum InvokeStateEnum {


		SUCCESS(1, "0000"), NO_DATA(-1, "0001"), ERROR(2, "9999"), ERROR_NO_WARN(2, "9999");

		private int value;

		private String code;

		private InvokeStateEnum(int value, String code) {
			this.value = value;
			this.code = code;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public static boolean isError(InvokeStateEnum invokeState) {
			return InvokeStateEnum.ERROR == invokeState || InvokeStateEnum.ERROR_NO_WARN == invokeState;
		}

		public static boolean isNeedWarning(InvokeStateEnum invokeState) {
			return InvokeStateEnum.ERROR == invokeState;
		}

		public static InvokeStateEnum getNoData() {
			return InvokeStateEnum.NO_DATA;
		}

		public static InvokeStateEnum getSuccess() {
			return InvokeStateEnum.SUCCESS;
		}

		public static InvokeStateEnum getError() {
			return InvokeStateEnum.ERROR;
		}

		public static InvokeStateEnum getErrorNoWarn() {
			return InvokeStateEnum.ERROR_NO_WARN;
		}
	}


	public enum OrderChannelEnum {
		WEB(0, "web"), WS(1, "接口");

		private int value;

		private String name;

		private OrderChannelEnum(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public enum AdminType {

		NORMAL(0), SUPERADMIN(1), ORGADMIN(2);

		private int value;

		private AdminType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	public enum MatchType {

		FUZZY(0), EXACT(1);

		private int value;

		private MatchType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	public enum MessageType {

		NOTIFY(0), SUBSCRIBE(1), SEND(2);

		private int value;

		private MessageType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	public enum Aspect {

		AFTERPAY("afterPay"),
		EVENTTRACK("eventTrack"),
		SNOWLOG("snowlog"),
		AFTERACTION("afterAction"),
		ENTERFINAL("enterFinal"),
		QUARTZJOB("quartzJob"),
		AUTOTRIGGER("autoTrigger"),
		PAYLIMIT("payLimit");

		private String value;

		private Aspect(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public enum JobStatus {
		NONE("NONE", "未知"),
		NORMAL("NORMAL", "正常运行"),
		PAUSED("PAUSED", "暂停状态"),
		COMPLETE("COMPLETE", "运行完成"),
		ERROR("ERROR", "错误状态"),
		BLOCKED("BLOCKED", "锁定状态");

		private JobStatus(String index, String name) {
			this.name = name;
			this.index = index;
		}

		private String index;
		private String name;

		public String getName() {
			return name;
		}

		public String getIndex() {
			return index;
		}
	}

}
