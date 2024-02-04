package pl.wit.edu.demo;

import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DiscordConfiguration {

    @Value("${wit.discord.token}")
    private String token;

    @Bean
    DiscordApi getDiscordApi() {
        try {
            log.info("Discord login attempt");
            return new DiscordApiBuilder()
                    .setToken(token)
                    .addIntents(Intent.MESSAGE_CONTENT)
                    .login()
                    .join();
        } catch (Exception e) {
            log.error("Error during Discord login", e);
            throw new RuntimeException("Error during Discord login", e);
        }
    }


}
