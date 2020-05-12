package org.juhewu.email;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.synchronizedMap;

/**
 * 内存中的邮箱账户
 *
 * @author duanjw
 */
public class InMemoryMailAccountRepository implements MailAccountRepository {
    private final Map<String, MailAccount> emailAccounts = synchronizedMap(
            new LinkedHashMap());

    /**
     * 内存中的所有邮箱账户
     * @return
     */
    @Override
    public List<MailAccount> getEmailAccounts() {
        return new ArrayList<>(emailAccounts.values());
    }

    /**
     * 根据邮箱账户id获取邮箱账户
     * @param id
     * @return
     */
    @Override
    public MailAccount getEmailAccount(String id) {
        return emailAccounts.get(id);
    }

    /**
     * 新增邮箱账户
     * @param mailAccount
     */
    @Override
    public void add(MailAccount mailAccount) {
        emailAccounts.put(mailAccount.getId(), mailAccount);
    }

    /**
     * 批量新增邮箱账户
     * @param mailAccounts
     */
    @Override
    public void add(List<MailAccount> mailAccounts) {
        this.emailAccounts.putAll(mailAccounts.stream().collect(Collectors.toMap(MailAccount::getId, Function.identity())));
    }

    /**
     * 根据id删除邮箱账户
     * @param id
     */
    @Override
    public void delete(String id) {
        emailAccounts.remove(id);
    }

    /**
     * 批量删除邮箱账户
     * @param ids
     */
    @Override
    public void delete(List<String> ids) {
        for (String id : ids) {
            this.delete(id);
        }
    }
}
