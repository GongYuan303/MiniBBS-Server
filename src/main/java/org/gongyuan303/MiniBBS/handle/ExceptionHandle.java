package org.gongyuan303.MiniBBS.handle;

import org.gongyuan303.MiniBBS.domain.Result;
import org.gongyuan303.MiniBBS.enums.ResultEnum;
import org.gongyuan303.MiniBBS.exception.GirlExpection;
import org.gongyuan303.MiniBBS.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/18.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlExpection) {
            GirlExpection girlExpection = (GirlExpection) e;
            return ResultUtil.error(girlExpection.getCode(), girlExpection.getMessage());
        } else {
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());
        }
    }
}
