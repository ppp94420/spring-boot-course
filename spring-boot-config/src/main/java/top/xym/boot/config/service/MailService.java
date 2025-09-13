package top.xym.boot.config.service;

import enums.ResultStatus;
import org.springframework.web.multipart.MultipartFile;
import top.xym.boot.config.model.Mail;

/**
 * @Author: DELL
 * @Date: 2025/9/12
 * @Version: 1.0
 */
public interface MailService {
    /**
     * 发送简单邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendSimpleMail(Mail mail);

    /**
     * 发送HTML邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendHTMLMail(Mail mail);

    /**
     * 发送带附件的邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendAttachmentsMail(Mail mail, MultipartFile[] files);
}
