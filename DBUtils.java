package homework.spring.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Component
public class DBUtils {

    private List<String> mailGeneratorsName;
    private Random random = new Random();

    @Autowired
    private void initList(DistributionService distributionService) {
        mailGeneratorsName = new ArrayList<>(distributionService.getMap().keySet());
    }

    public String getMailCode() {
        int size = mailGeneratorsName.size();
        int randomNum = random.nextInt(size);
        return mailGeneratorsName.get(randomNum);
    }
}
