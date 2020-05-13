package org.juhewu.email;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 聚合邮箱账户，获取邮箱账户从此获取
 *
 * @author duanjw
 */
public class CompositeMailAccountLocator implements MailAccountLocator {
    private final List<MailAccountLocator> emailAccountLocators;

    public CompositeMailAccountLocator(List<MailAccountLocator> emailAccountLocators) {
        this.emailAccountLocators = emailAccountLocators;
    }

    /**
     * 所有邮箱账户
     *
     * @return^
     */
    @Override
    public List<MailAccount> getEmailAccounts() {
        return emailAccountLocators.stream().flatMap(item -> item.getEmailAccounts().stream()).collect(Collectors.toList());
    }

    /**
     * 根据邮箱账户id获取邮箱账户
     *
     * @param id
     * @return
     */
    @Override
    public MailAccount getEmailAccount(String id) {
        return emailAccountLocators.stream().map(item -> item.getEmailAccount(id)).filter(Objects::nonNull).findFirst().orElseThrow(NullPointerException::new);
    }
}
