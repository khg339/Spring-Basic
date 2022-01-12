package hello.core.member;

public interface MemberRepository { //회원 저장소 인터페이스

    void save(Member member); //회원 저장

    Member findById(Long memberId);// 아이디로 회원 찾기
}
