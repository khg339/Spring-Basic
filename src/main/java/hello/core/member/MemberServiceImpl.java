package hello.core.member;

public class MemberServiceImpl implements MemberService{

   private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) { //회원가입
        memberRepository.save(member); //회원 저장소에 멤버 저장
    }

    @Override
    public Member findMember(Long memberId) { //아이디로 회원 찾기
        return memberRepository.findById(memberId); //회원 저장소에 아이디로 회원 찾기
    }
}
