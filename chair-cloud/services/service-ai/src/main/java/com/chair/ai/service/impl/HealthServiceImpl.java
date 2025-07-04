package com.chair.ai.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.chair.ai.feign.AuthFeignClient;
import com.chair.ai.service.HealthService;
import com.chair.auth.common.BaseResponse;
import com.chair.auth.model.vo.LoginUserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    @Resource
    private AuthFeignClient authFeignClient;

    @SentinelResource(value = "/demo")
    @Override
    public BaseResponse<LoginUserVO> demo(HttpServletRequest request) {
        return authFeignClient.demo(request.getHeader("chair-token"));
    }
}
