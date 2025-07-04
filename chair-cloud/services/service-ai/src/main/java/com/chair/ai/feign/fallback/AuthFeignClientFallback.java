package com.chair.ai.feign.fallback;

import com.chair.ai.feign.AuthFeignClient;
import com.chair.auth.common.BaseResponse;
import com.chair.auth.common.ResultUtils;
import com.chair.auth.model.vo.LoginUserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
public class AuthFeignClientFallback implements AuthFeignClient {

    @Override
    public BaseResponse<LoginUserVO> demo(@RequestHeader("chair-token") String token) {
        LoginUserVO userVO = new LoginUserVO();
        userVO.setId(1L);
        userVO.setUserAvatar("http://www.baidu.com");
        userVO.setUserName("user");
        userVO.setUserRole("user");
        userVO.setUserProfile("this is user profile");
        return ResultUtils.success(userVO);
    }
}
