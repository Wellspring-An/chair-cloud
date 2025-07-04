package com.chair.ai.service;

import com.chair.auth.common.BaseResponse;
import com.chair.auth.model.vo.LoginUserVO;
import jakarta.servlet.http.HttpServletRequest;

public interface HealthService {

    BaseResponse<LoginUserVO> demo(HttpServletRequest request);
}
