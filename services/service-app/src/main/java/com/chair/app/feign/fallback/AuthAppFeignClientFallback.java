package com.chair.app.feign.fallback;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chair.app.feign.AuthAppFeignClient;
import com.chair.auth.common.BaseResponse;
import com.chair.auth.common.ResultUtils;
import com.chair.auth.model.entity.User;
import com.chair.auth.model.vo.LoginUserVO;
import com.chair.auth.model.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Set;

@Component
public class AuthAppFeignClientFallback implements AuthAppFeignClient {

    @Override
    public BaseResponse<LoginUserVO> getLoginUser(@RequestHeader("chair-token") String token) {
        LoginUserVO userVO = new LoginUserVO();
        userVO.setId(1L);
        userVO.setUserAvatar("http://www.baidu.com");
        userVO.setUserName("user");
        userVO.setUserRole("user");
        userVO.setUserProfile("this is user profile");
        return ResultUtils.success(userVO);
    }

    @Override
    public BaseResponse<List<UserVO>> getListByIds(Set<Long> ids, String token) {
        return null;
    }

    @Override
    public BaseResponse<User> getById(Long id) {
        return null;
    }
}
