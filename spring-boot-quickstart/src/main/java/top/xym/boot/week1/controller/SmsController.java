package top.xym.boot.week1.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.boot.week1.service.SmsService;

/**
 * @Author: DELL
 * @Date: 2025/9/6
 * @Version: 1.0
 */
@RestController
public class SmsController {
    @Resource
    private SmsService smsService;
    @GetMapping("/sms")
    public void sendSms(String phone)
    {
        smsService.sendSms(phone);
    }
}
