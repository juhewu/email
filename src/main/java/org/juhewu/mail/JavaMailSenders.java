package org.juhewu.mail;

import org.springframework.mail.javamail.JavaMailSender;

/**
 * 邮件发送器，多个
 *
 * @author duanjw
 */
public interface JavaMailSenders {
    JavaMailSender get(String key);
}
