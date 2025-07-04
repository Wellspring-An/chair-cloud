package com.chair.ai.feign;

import com.chair.ai.feign.fallback.AuthFeignClientFallback;
import com.chair.auth.common.BaseResponse;
import com.chair.auth.model.vo.LoginUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "service-auth", fallback = AuthFeignClientFallback.class)
public interface AuthFeignClient {

    // mvc注解的两套使用逻辑
    // 1、标注在Controller上，表示该Controller下的所有方法都是调用远程服务(接收请求)
    // 2、标注在方法上，表示该方法调用远程服务(发送请求)
    @GetMapping("/auth/demo/hello")
    BaseResponse<LoginUserVO> demo(@RequestHeader("chair-token") String token);
}
