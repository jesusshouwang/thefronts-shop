package cn.thefronts.common.exception;

/**
 * 业务异常
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public BusinessException(String message) {
        super(message);
    }
}
