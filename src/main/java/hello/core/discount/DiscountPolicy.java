package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 대상별 할인값
     */

    int discount(Member member, int price);
}
