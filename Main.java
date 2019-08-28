package homework.spring.never_use_switch;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("homework.spring");
        DistributionService service = applicationContext.getBean(DistributionService.class);
        while (true) {
            try {
                service.sendMail();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(500);
        }
    }
}
