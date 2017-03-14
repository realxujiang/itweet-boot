package cn.itweet.modules.admin.user.repository;

import cn.itweet.ItweetBootApplication;
import cn.itweet.modules.admin.user.entry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 14/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItweetBootApplication.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testExample() throws Exception {
        User user = userRepository.findByUserName("priya");
        System.out.println(user.toString());
    }
}
