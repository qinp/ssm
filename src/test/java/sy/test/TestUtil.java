package sy.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import sy.model.User;
import sy.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestUtil {
	
	private static final Logger logger = Logger.getLogger(TestUtil.class);
	
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@Test
	public void test(){
		User user = userService.getUserById(1);
		logger.info(JSON.toJSONStringWithDateFormat(user, "yyyyMMdd hh:mm:ss"));
	}
}
