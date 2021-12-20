package discount;

import hello.core.Member;

public interface DiscountPolicy {
	
	/**
	 * 
	 * @return 할인 대상 금액
	 */
	public int discount(Member member, int price);
}
