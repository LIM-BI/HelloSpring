package order;

import hello.core.Grade;
import hello.core.Member;
import hello.core.MemberService;
import hello.core.MemberServiceImpl;

public class OrderApp {
	
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "jaket", 10000);
		
		System.out.println(order.toString());
		System.out.println(order.calculatePrice());
		
	}
}
