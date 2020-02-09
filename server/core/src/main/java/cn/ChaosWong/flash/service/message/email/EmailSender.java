package cn.ChaosWong.flash.service.message.email;

import org.springframework.core.io.InputStreamSource;


public interface EmailSender {

    boolean sendEmail(String from, String to, String cc, String title, String content);


    boolean sendEmail(String from, String to, String cc, String title, String content,String attachmentFilename, InputStreamSource inputStreamSource);
}
