package homework.spring.never_use_switch;


import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateMail() {
            return "<HTML> Welcome new client</HTML>";
    }
}
