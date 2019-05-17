package com.allinjava.bootaction;

import com.allinjava.bootaction.service.UserService;
import com.allinjava.bootaction.util.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootactionApplicationTests {

	@Test
	public void contextLoads() {
		MethodValidationPostProcessor bean = SpringContextUtil.getBean(MethodValidationPostProcessor.class);
		UserService bean2 = SpringContextUtil.getBean(UserService.class);
		System.out.println(bean2);

	}

}
