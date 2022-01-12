package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{ //회원 저장소 기억

    private static Map<Long, Member> store = new HashMap<>(); //회원을 기억할 공간

    @Override
    public void save(Member member) { //회원 저장
        store.put(member.getId(), member); //hashmap에 회원 아이디를 키로 회원정보 저장
    }

    @Override
    public Member findById(Long memberId) { //아이디로 회원 찾기
        return store.get(memberId); //hashmap에서 동일한 아이디를 가진 회원 찾기
    }
}
