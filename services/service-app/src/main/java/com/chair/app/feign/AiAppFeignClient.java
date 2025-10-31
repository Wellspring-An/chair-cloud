package com.chair.app.feign;

import com.chair.app.feign.fallback.AiAppFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@FeignClient(name = "service-ai",contextId = "ai-service-app", fallback = AiAppFeignClientFallback.class)
public interface AiAppFeignClient {

    // mvc注解的两套使用逻辑
    // 1、标注在Controller上，表示该Controller下的所有方法都是调用远程服务(接收请求)
    // 2、标注在方法上，表示该方法调用远程服务(发送请求)

    @GetMapping("/ai/simple/chat")
    String simpleChat(@RequestParam("chatId") String chatId, @RequestParam("userMessage") String userMessage, @RequestParam("sysMessage") String sysMessage);

    @GetMapping("/ai/simple/chat/sse")
    Flux<String> simpleChatSSE(@RequestParam("chatId") String chatId, @RequestParam("userMessage") String userMessage, @RequestParam("sysMessage") String sysMessage);
}
