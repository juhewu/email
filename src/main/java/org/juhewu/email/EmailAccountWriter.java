package org.juhewu.email;

import java.util.List;

/**
 * 邮箱账户修改
 *
 * @author duanjw
 */
public interface EmailAccountWriter {
    /**
     * 新增邮箱账户
     * @param emailAccount
     */
    void add(EmailAccount emailAccount);
    /**
     * 批量新增邮箱账户
     * @param emailAccounts
     */
    void add(List<EmailAccount> emailAccounts);

    /**
     * 根据id删除邮箱账户
     * @param id
     */
    void delete(String id);

    /**
     * 批量删除邮箱账户
     * @param ids
     */
    void delete(List<String> ids);
}
