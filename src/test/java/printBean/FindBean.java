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
	@DisplayName("�� �̸����� ��ȸ ")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test // Ÿ���� �������� ��찡 �ֱ� ������ �� �̸����� ��ȸ�ϴ°� ����.
	@DisplayName("�� Ÿ������ ��ȸ") 
	void findBeanByType() {
		MemberService memberSerivce = ac.getBean(MemberService.class);
		Assertions.assertThat(memberSerivce).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("�� ����ü�� ��ȸ")
	void findBeanByName2() {
		MemberService memberSerivce = ac.getBean("memberService", MemberServiceImpl.class);
		Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("�� �̸����� ��ȸX")
	void findBeanByNameX() {
		assertThrows(NoSuchBeanDefinitionException.class,
				() -> ac.getBean("XXX", MemberService.class));
	}

}
