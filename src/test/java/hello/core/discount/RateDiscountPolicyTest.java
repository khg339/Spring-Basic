package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){ //vip가 맞을 때
        //given
        Member member = new Member(1L, "memberVIP", Grade.Vip); //vip 회원
        //when
        int discount = discountPolicy.discount(member, 10000); //할인가격
        //then
        Assertions.assertThat(discount).isEqualTo(1000); //1000원이랑 같은지 테스트
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){ //vip가 아닐 때
        //given
        Member member = new Member(2L, "memberBisic", Grade.Basic); //vip 회원
        //when
        int discount = discountPolicy.discount(member, 10000); //할인가격
        //then
        Assertions.assertThat(discount).isEqualTo(0); //0원이랑 같은지 테스트
    }

}