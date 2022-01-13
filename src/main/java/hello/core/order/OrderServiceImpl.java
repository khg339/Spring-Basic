package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; //인터페이스에만 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { //주문생성
        Member member = memberRepository.findById(memberId); //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인값 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
