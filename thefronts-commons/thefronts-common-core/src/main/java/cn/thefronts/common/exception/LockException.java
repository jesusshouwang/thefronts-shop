package cn.thefronts.common.exception;

/**
 * 分布式锁异常
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public class LockException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public LockException(String message) {
        super(message);
    }
}
