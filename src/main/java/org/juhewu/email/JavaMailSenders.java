package org.juhewu.email;

import org.springframework.mail.javamail.JavaMailSender;

/**
 * 邮件发送器
 *
 * @author duanjw
 */
public interface JavaMailSenders {
    JavaMailSender get(String key);
}
