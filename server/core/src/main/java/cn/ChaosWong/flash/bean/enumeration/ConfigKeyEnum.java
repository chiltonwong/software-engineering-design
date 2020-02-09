package cn.ChaosWong.flash.bean.enumeration;

public enum ConfigKeyEnum {

    SYSTEM_FILE_UPLOAD_PATH("system.file.upload.path"),

    SYSTEM_APP_NAME("system.app.name"),

    API_TENCENT_SMS_APPID("api.tencent.sms.appid"),

    API_TENCENT_SMS_APPKEY("api.tencent.sms.appkey"),

    API_TENCENT_SMS_SIGN("api.tencent.sms.sign");

    private String value;

    ConfigKeyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
