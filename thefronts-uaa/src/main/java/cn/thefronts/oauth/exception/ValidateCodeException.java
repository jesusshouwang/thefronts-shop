package cn.thefronts.oauth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 * @author thefronts
 * @date 2023/2/22
 */
public class ValidateCodeException extends AuthenticationException {
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}
}
