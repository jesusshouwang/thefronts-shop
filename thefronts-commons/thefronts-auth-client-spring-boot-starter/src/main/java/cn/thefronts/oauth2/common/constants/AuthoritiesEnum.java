package cn.thefronts.oauth2.common.constants;

/**
 * 权限常量
 *
 * @author chenkun
 * @version 1.0
 * @date 2022/5/8
 */
public enum AuthoritiesEnum {
    /**
     * 管理员
     */
    ADMIN("ROLE_ADMIN"),
    /**
     * 普通用户
     */
    USER("ROLE_USER"),
    /**
     * 匿名用户
     */
    ANONYMOUS("ROLE_ANONYMOUS");

    private String role;

    AuthoritiesEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
