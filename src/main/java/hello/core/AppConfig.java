package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 구성정보
public class AppConfig {

    @Bean //스프링컨테이너에 등록
    public MemoryMemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy getDiscountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(getMemoryMemberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemoryMemberRepository(),  getDiscountPolicy());
    }

}
