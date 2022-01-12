package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { //주문생성
        Member member = memberRepository.findById(memberId); //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인값 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}