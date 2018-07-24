package org.gongyuan303.MiniBBS.exception;

import org.gongyuan303.MiniBBS.enums.ResultEnum;

/**
 * Created by Administrator on 2017/7/18.
 */
public class GirlExpection extends RuntimeException {
    private Integer code;

    public GirlExpection(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
