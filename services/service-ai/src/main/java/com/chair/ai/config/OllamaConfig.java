package com.chair.ai.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;
import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY;

@Component
public class OllamaConfig {

    private static final Logger log = LoggerFactory.getLogger(OllamaConfig.class);

    private final ChatClient chatClient;


    public OllamaConfig(ChatModel ollamaModel) {
        // 初始化基于内存的对话记忆
        ChatMemory chatMemory = new InMemoryChatMemory();
        this.chatClient = ChatClient.builder(ollamaModel)
                .defaultSystem("你是一个AI助手，请根据用户输入回答问题")
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(chatMemory)
                ).build();
    }

    public String doQuest(String chatId, String userMessage, String sysMessage) {
        ChatResponse chatResponse = this.chatClient.prompt()
                .advisors(a -> a
                        .param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)
                        .param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 10))
                .user(userMessage)
                .system(sysMessage)
                .call()
                .chatResponse();
        String text = chatResponse.getResult().getOutput().getText();
        log.info("ollama response: {}", text);
        return text;
    }

    public Flux<String> doStreamSQuest(String chatId, String userMessage, String sysMessage) {
        return this.chatClient.prompt()
                .advisors(a -> a
                        .param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)
                        .param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 10))
                .user(userMessage)
                .system(sysMessage)
                .stream()
                .content();
    }
}


