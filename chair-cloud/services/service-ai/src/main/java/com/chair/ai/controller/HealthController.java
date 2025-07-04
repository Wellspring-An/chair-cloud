package com.chair.ai.controller;

import com.chair.ai.service.HealthService;
import com.chair.auth.common.BaseResponse;
import com.chair.auth.model.vo.LoginUserVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Resource
    private HealthService healthService;

    @GetMapping
    public String healthCheck() {
        return "ok";
    }

    @GetMapping("/demo")
    public BaseResponse<LoginUserVO> demo(HttpServletRequest request) {
        return healthService.demo(request);
    }
}