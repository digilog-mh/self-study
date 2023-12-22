package japbook.jpashop.service;

import japbook.jpashop.domain.Member;
import japbook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor; //final이 붙은 변수에 의해 자동 생성자 주입 생성.
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /*커맨드와 쿼리 분리를 위해 return을 void로 설정.
    * Member를 return할 시에 update 커맨드와 조회 쿼리가 동시에 일어남.
    * 해당 Member는 영속성이 끊겼기에 이후 update 관련으로 사용에 의미가 없음.*/
    @Transactional
    public void update(Long id, String name){
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
