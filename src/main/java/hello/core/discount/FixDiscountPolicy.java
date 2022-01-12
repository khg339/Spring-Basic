package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;


public class FixDiscountPolicy implements DiscountPolicy{

    private int  discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.Vip){ //vip면 고정값 할인
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
