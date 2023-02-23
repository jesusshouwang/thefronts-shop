package cn.thefronts.common.model;

/**
 * 错误码枚举
 *
 * @author chenkun
 * @date 2023/2/22 16:44
 */
public enum CodeEnum {
    SUCCESS(0),
    ERROR(1);

    private Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
