package com.vic.demo;


import com.vic.demo.model.User;
import com.vic.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IUserService userService;

	@Test
	public void contextLoads() {
		User u = new User();
		u.setUsername("嗷嗷");
		u.setEmail("aaa.cc");
		u.setPassword("sldfjlsdfjslkdfj");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);
		u.setLastPasswordResetDate(c.getTime());
		userService.saveUser(u);

	}

}
