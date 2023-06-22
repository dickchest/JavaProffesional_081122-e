package javaProfessionalCourse2.lesson31.messageExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public Message printMessage() {
        return new Message();
    }

}
