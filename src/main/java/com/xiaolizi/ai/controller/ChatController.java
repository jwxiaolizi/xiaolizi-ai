package com.xiaolizi.ai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

/**
 * @author l4784
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {
    private final ChatClient chatClient;
    @RequestMapping(value = "/chat",produces = "text/html;charset=UTF-8")
    public Flux<String> chat(@RequestParam String prompt,
                             @RequestParam String chatId) {
        return chatClient.prompt()
                            .user(prompt)
                            .advisors(advisors -> advisors.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId))
                            .stream()
                            .content();
    }
}
