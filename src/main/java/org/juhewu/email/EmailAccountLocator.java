package org.juhewu.email;

import java.util.List;

/**
 * 邮箱账户定位器
 *
 * @author duanjw
 */
public interface EmailAccountLocator {
    /**
     * 所有邮箱账户
     *
     * @return
     */
    List<EmailAccount> getEmailAccounts();

    /**
     * 根据邮箱账户id获取邮箱账户
     * @param id
     * @return
     */
    EmailAccount getEmailAccount(String id);
}
