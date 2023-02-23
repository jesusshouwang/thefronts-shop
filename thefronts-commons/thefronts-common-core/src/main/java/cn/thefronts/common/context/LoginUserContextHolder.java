package cn.thefronts.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import cn.thefronts.common.model.SysUser;

/**
 * 登录用户holder
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public class LoginUserContextHolder {
    private static final ThreadLocal<SysUser> CONTEXT = new TransmittableThreadLocal<>();

    public static void setUser(SysUser user) {
        CONTEXT.set(user);
    }

    public static SysUser getUser() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}