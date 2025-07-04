package com.chair.ai.controller;


import com.chair.ai.config.OllamaConfig;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class OllamaChatModelController {

    @Resource
    private OllamaConfig ollamaConfig;

    @GetMapping("/simple/chat")
    public String simpleChat(String chatId, String userMessage, String sysMessage) {
        return ollamaConfig.doQuest(chatId, userMessage, sysMessage);
    }

    @GetMapping("/simple/chat/sse")
    public Flux<String> simpleChatSSE(String chatId, String userMessage, String sysMessage) {
        return ollamaConfig.doStreamSQuest(chatId, userMessage, sysMessage);
    }
}