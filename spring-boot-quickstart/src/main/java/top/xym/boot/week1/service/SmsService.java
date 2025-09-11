package top.xym.boot.week1.service;

/**
 * @Author: DELL
 * @Date: 2025/9/6
 * @Version: 1.0
 */
public interface SmsService {
    /**
     * 发送短信
     *
     * @param phone 手机号
     */
    void sendSms(String phone);
}
