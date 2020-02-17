package org.framework.edo.spike.model;

import lombok.Data;

/**
 * sys_user
 *
 * @author
 */
@Data
public class User {
    /**
     * 主键
     */
    private Long id;

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


}