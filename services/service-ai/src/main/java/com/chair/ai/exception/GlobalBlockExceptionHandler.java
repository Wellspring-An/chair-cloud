package com.chair.ai.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

import static org.apache.http.HttpStatus.SC_TOO_MANY_REQUESTS;

@Component
public class GlobalBlockExceptionHandler implements BlockExceptionHandler {

    private void writeErrorResponse(HttpServletResponse response, String code, String message) throws IOException {
        response.getWriter().print("{\"code\":\"" + code + "\",\"message\":\"" + message + "\"}");
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, String s, BlockException e) throws Exception {
        response.setContentType("application/json;charset=UTF-8");

        if (e instanceof FlowException) {
            response.setStatus(SC_TOO_MANY_REQUESTS);  // 429
            writeErrorResponse(response, "429", "请求被限流");
        } else if (e instanceof DegradeException) {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);  // 503
            writeErrorResponse(response, "503", "服务暂时不可用");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);  // 500
            writeErrorResponse(response, "500", "系统繁忙");
        }
    }
}