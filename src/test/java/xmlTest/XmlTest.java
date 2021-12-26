package xmlTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.MemberService;

public class XmlTest {

	@Test
	void xmlTest() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
