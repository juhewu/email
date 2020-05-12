package org.juhewu.email;

import lombok.Data;
import lombok.experimental.Accessors;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 邮箱账户
 *
 * @author duanjw
 */
@Data
@Accessors(chain = true)
public class MailAccount {
    private static final Charset DEFAULT_CHARSET;
    public MailAccount() {
        this.defaultEncoding = DEFAULT_CHARSET;
        this.properties = new HashMap();
    }
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 租户id
     */
    private Long tenantId;


    /**
     * SMTP服务器域名
     */
    private String host;
    /**
     * SMTP服务端口
     */
    private Integer port;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    private String protocol;
    private Charset defaultEncoding;
    private Map<String, String> properties;

    static {
        DEFAULT_CHARSET = StandardCharsets.UTF_8;
    }

    /**
     * 是否需要用户名密码验证
     */
    private Boolean auth;

    /**
     * 发送方，遵循RFC-822标准
     */
    private String from;

    /**
     * 是否打开调试模式，调试模式会显示与邮件服务器通信过程，默认不开启
     */
    private boolean debug;
    /**
     * 编码用于编码邮件正文和发送人、收件人等中文
     */
    private Charset charset = Charset.defaultCharset();
    /**
     * 对于超长参数是否切分为多份，默认为false（国内邮箱附件不支持切分的附件名）
     */
    private boolean splitlongparameters;

    /**
     * 使用 STARTTLS安全连接，STARTTLS是对纯文本通信协议的扩展。它将纯文本连接升级为加密连接（TLS或SSL）， 而不是使用一个单独的加密通信端口。
     */
    private boolean starttlsEnable = false;
    /**
     * 使用 SSL安全连接
     */
    private Boolean sslEnable;
    /**
     * 指定实现javax.net.SocketFactory接口的类的名称,这个类将被用于创建SMTP的套接字
     */
    private String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
    /**
     * 如果设置为true,未能创建一个套接字使用指定的套接字工厂类将导致使用java.net.Socket创建的套接字类, 默认值为true
     */
    private boolean socketFactoryFallback;
    /**
     * 指定的端口连接到在使用指定的套接字工厂。如果没有设置,将使用默认端口
     */
    private int socketFactoryPort = 465;

    /**
     * SMTP超时时长，单位毫秒，缺省值不超时
     */
    private long timeout;
    /**
     * Socket连接超时值，单位毫秒，缺省值不超时
     */
    private long connectionTimeout;

}
