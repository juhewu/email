package org.juhewu.email;

/**
 * @author duanjw
 */
public class Test {
    public static void main(String[] args) {
        MailAccount mailAccount = new MailAccount().setId("1");
        MailAccountRepository mailAccountRepository = new InMemoryMailAccountRepository();
        mailAccountRepository.add(mailAccount);

        JavaMailSenders javaMailSenders = new JavaMailSendersImpl(mailAccountRepository);
        System.out.println(javaMailSenders.get("1"));
    }
}
