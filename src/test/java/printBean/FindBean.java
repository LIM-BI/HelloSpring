package printBean;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.MemberService;
import hello.core.MemberServiceImpl;

public class FindBean {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회 ")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test // 타입이 여러개인 경우가 있기 때문에 빈 이름으로 조회하는게 좋다.
	@DisplayName("빈 타입으로 조회") 
	void findBeanByType() {
		MemberService memberSerivce = ac.getBean(MemberService.class);
		Assertions.assertThat(memberSerivce).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("빈 구현체로 조회")
	void findBeanByName2() {
		MemberService memberSerivce = ac.getBean("memberService", MemberServiceImpl.class);
		Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회X")
	void findBeanByNameX() {
		assertThrows(NoSuchBeanDefinitionException.class,
				() -> ac.getBean("XXX", MemberService.class));
	}

}
