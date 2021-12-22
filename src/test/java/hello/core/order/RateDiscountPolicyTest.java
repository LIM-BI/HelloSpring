package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import discount.RateDiscountPolicy;
import hello.core.Grade;
import hello.core.Member;

public class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP�� 10% ������ ����Ǿ�� �Ѵ�.")
	void vip_o() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP ȸ���� �ƴѰ�� ������ ����Ǹ� �ȵȴ�.")
	void vip_x() {
		//given
		Member member = new Member(1L, "memberA", Grade.BASIC);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		Assertions.assertThat(discount).isEqualTo(0);
	}
}
