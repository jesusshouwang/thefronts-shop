package cn.thefronts.common.exception;

/**
 * 幂等性异常
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public class IdempotencyException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public IdempotencyException(String message) {
        super(message);
    }
}
