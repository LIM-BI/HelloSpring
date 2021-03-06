package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.Member;
import hello.core.MemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	private final DiscountPolicy discountPolicy;
	
	@Autowired	
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
