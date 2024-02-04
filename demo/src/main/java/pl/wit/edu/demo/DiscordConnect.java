package pl.wit.edu.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class DiscordConnect {
    private final DiscordApi api;
    @EventListener(value = ApplicationReadyEvent.class)
    void printConnectionUrl(){
        log.info(
                api.createBotInvite()
        );
    }
}
