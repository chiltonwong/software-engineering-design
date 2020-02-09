package cn.ChaosWong.flash.service.message.sms.tencent;

import cn.ChaosWong.flash.bean.enumeration.ConfigKeyEnum;
import cn.ChaosWong.flash.cache.ConfigCache;
import cn.ChaosWong.flash.service.message.sms.SmsSender;
import cn.ChaosWong.flash.utils.StringUtil;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TencentSmsSender implements SmsSender {
    private Logger logger = LoggerFactory.getLogger(TencentSmsSender.class);
    @Autowired
    private ConfigCache configCache;
    @Override
    public boolean sendSms(String tplCode, String receiver, String[] args, String content) {
        Integer appid = Integer.valueOf((String) configCache.get(ConfigKeyEnum.API_TENCENT_SMS_APPID.getValue()));
        String appkey = (String) configCache.get(ConfigKeyEnum.API_TENCENT_SMS_APPKEY.getValue());
        String smsSign = (String) configCache.get(ConfigKeyEnum.API_TENCENT_SMS_SIGN.getValue());
        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result = null;
        try{
            if(StringUtil.isNotEmpty(tplCode)){


                result = ssender.sendWithParam("86", receiver,
                    Integer.valueOf(tplCode), args, smsSign, "", "");
            }else {

                result = ssender.send(0, "86", receiver,
                        content, "", "");

            }
            logger.info(result.errMsg);
            return result.result == 0;
        } catch (Exception e) {
                logger.error("发送短信异常",e);
        }

        return false;
    }
}
