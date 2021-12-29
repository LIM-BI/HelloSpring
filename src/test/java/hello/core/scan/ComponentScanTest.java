package hello.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.MemberService;
import hello.core.order.AutoAppConfig;
import hello.core.order.OrderService;

public class ComponentScanTest {

	@Test
	@DisplayName("컴포넌트 빈 자동등록 확인")
	void basicScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		//DiscountPolicy rateDiscount = ac.getBean(DiscountPolicy.class);
		OrderService orderService = ac.getBean(OrderService.class);
		
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
		Assertions.assertThat(orderService).isInstanceOf(OrderService.class);
		//Assertions.assertThat(rateDiscount).isInstanceOf(DiscountPolicy.class);
	}
}
