package cn.ChaosWong.flash.service.message.sms;

public interface SmsSender {


    boolean sendSms(String tplCode, String receiver, String[] args, String content);
}
