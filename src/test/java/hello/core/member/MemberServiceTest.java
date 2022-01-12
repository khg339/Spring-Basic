package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.Vip);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        /**
        *AssertJ : 자바 테스트를 위한 오픈소스 라이브러리
        *Assertions.assertThat(a).isEqualTo(b)는 두 값이 동일한지 검증시켜준다.
        *값이 같다면 빌드가 되고, 값이 다르다면 오류메세지가 뜬다.
         */
    }
}
