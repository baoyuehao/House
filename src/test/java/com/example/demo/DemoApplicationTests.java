package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private final static Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	private UserService userService;

//	@Test
//	public void contextLoads() {
//		User user = userService.findUserByUid(2);
//		logger.info(user.toString());
//	}

}
