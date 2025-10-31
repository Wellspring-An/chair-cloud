package com.chair.app.feign.fallback;

import com.chair.app.feign.AiAppFeignClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class AiAppFeignClientFallback implements AiAppFeignClient {

    @Override
    public String simpleChat(String chatId, String userMessage, String sysMessage) {

        return "ResultUtils.success(null);";
    }

    @Override
    public Flux<String> simpleChatSSE(String chatId, String userMessage, String sysMessage) {
        return Flux.just();
    }
}
