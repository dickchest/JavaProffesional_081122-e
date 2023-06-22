package javaProfessionalCourse2.lesson31.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

//    @Bean
//    public Cat getCat() {
//        return new Cat();
//    }

    @Bean("dog")
    public Dog getDog() {
        return new Dog();
    }

    @Bean("parrot-kesha")
    public Parrot getParrot() {
        return new Parrot();
    }

    @Bean
    public Cat getCat(Parrot parrot) {
        Cat cat = new Cat();
        cat.setName(parrot.getName() + " - killer");
        return cat;
    }

}
