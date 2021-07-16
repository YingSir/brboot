package com.boransolution.brboot.advise;

import com.boransolution.brboot.enums.ResultCode;
import com.boransolution.brboot.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice                                                    // 作为一个控制层的切面处理
public class GlobalExceptionAdvice {
    public static final String DEFAULT_ERROR_VIEW = "error";        // 定义错误显示页，error.html

//    @ExceptionHandler(Exception.class)                                // 处理所有Exception类
//    public ModelAndView defaultErrorHandler(HttpServletRequest request,
//                                            Exception e) { 											// 出现异常之后会跳转到此方法
//        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); 	// 设置跳转路径
//        mav.addObject("exception", e); 								// 保存异常信息
//        mav.addObject("url", request.getRequestURL()); 				// 获得请求的路径
//        return mav;
//    }

    //Restful方式返回
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Result> doExceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(Result.failure(ResultCode.FAILURE,e));
    }
}

