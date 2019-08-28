package homework.spring.never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author Evgeny Borisov
 */
@Service
public class DistributionService {
    private Map<String, MailGenerator> map = new HashMap<>();
    @Autowired
    private DBUtils dbUtils;
    public Map<String, MailGenerator> getMap() {
        return map;
    }

    @Autowired
    private void initMap(List<MailGenerator> getGenerator) {
        for ( MailGenerator mailGenerator : getGenerator) {
            map.put(parser(mailGenerator.getClass()), mailGenerator);
        }
    }

    private String parser(Class<? extends MailGenerator> clazz) {
        return Stream.of(clazz.getName().split("MailGenerator")).findFirst().get();
    }

    public void sendMail() {

        String mailCode = dbUtils.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }
        String html = mailGenerator.generateMail();
        send(html);
    }
    private void send(String html) {
        System.out.println("html was sent: " + html);
    }

}



