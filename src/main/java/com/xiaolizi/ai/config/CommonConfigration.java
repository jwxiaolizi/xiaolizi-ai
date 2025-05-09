package com.xiaolizi.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfigration {
    @Bean
    public ChatMemory chatMemory() {
        return new InMemoryChatMemory();
    }
    @Bean
    public ChatClient chatClient(OllamaChatModel ollamaChatModel, ChatMemory chatMemory) {
        return ChatClient
                .builder(ollamaChatModel)
                .defaultSystem("你是一个ai智能助手，请用林黛玉的口吻回答用户的问题")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        new MessageChatMemoryAdvisor(chatMemory))
                .build();
    }
}
