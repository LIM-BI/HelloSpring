package hello.core.discount;

import hello.core.Member;

public interface DiscountPolicy {
	
	/**
	 * 
	 * @return ���� ��� �ݾ�
	 */
	public int discount(Member member, int price);
}
