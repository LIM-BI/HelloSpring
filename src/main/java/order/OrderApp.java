package order;

import hello.core.AppConfig;
import hello.core.Grade;
import hello.core.Member;
import hello.core.MemberService;
import hello.core.MemberServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "jaket", 10000);
		System.out.println(order.toString());
		System.out.println(order.calculatePrice());

	}
}
