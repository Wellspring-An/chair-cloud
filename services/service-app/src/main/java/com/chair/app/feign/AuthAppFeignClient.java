package com.chair.app.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chair.app.feign.fallback.AuthAppFeignClientFallback;
import com.chair.auth.common.BaseResponse;
import com.chair.auth.model.entity.User;
import com.chair.auth.model.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(name = "service-auth", contextId = "auth-service-app", fallback = AuthAppFeignClientFallback.class)
public interface AuthAppFeignClient {

    // mvc注解的两套使用逻辑
    // 1、标注在Controller上，表示该Controller下的所有方法都是调用远程服务(接收请求)
    // 2、标注在方法上，表示该方法调用远程服务(发送请求)

    @GetMapping("/auth/user/get/login")
    BaseResponse getLoginUser(@RequestHeader("chair-token") String token);

    @PostMapping("/auth/user/list/page/vo/from/userIds")
    BaseResponse<List<UserVO>> getListByIds(@RequestBody Set<Long> ids, @RequestHeader("chair-token") String token);

    @GetMapping("/auth/user/get")
    BaseResponse<User> getById(@RequestParam("id") Long id);
}
