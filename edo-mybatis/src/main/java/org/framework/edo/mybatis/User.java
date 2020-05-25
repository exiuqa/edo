package org.framework.edo.mybatis;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user
 *
 * @author
 */
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String sysName;

    /**
     * 密码
     */
    private String sysPassword;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    private static final long serialVersionUID = 1L;
}