import com.chair.auth.ChairAuthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import static com.chair.auth.config.TokenConfig.SALT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChairAuthApplication.class)
public class AuthTest {
    @Test
    public void test() {
        String s = DigestUtils.md5DigestAsHex((SALT + "999").getBytes());
        System.out.println(s);
    }
}