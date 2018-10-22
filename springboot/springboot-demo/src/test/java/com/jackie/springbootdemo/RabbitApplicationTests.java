package com.jackie.springbootdemo;

import com.jackie.springbootdemo.message.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
@WebAppConfiguration
public class RabbitApplicationTests {


    @Autowired
    Sender sender;

	@Test
	public void contextLoads() throws Exception {
        sender.sendMsg("test");
    }
}
