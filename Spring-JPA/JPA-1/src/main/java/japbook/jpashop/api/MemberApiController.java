package japbook.jpashop.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import japbook.jpashop.domain.Member;
import japbook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * 문제점, 엔티티의 모든 값이 노출되어버린다.
     * @return
     */
    @GetMapping("/api/v1/members")
    public List<Member> membersV1(){
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result membersV2(){
        List<Member> members = memberService.findMembers();
        List<MemberDto> collect = members.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(),collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
    }

    /**
     * 요청값으로 Member 엔티티에 직접 받음.
     *  >엔티티에 프레젠테이션 계층을 위한 로직이 추가된다.
     *  >엔티티에 API 검증을 위한 로직이 들어간다. (@NotEmpty 등등)
     *  >실무에서는 회원 엔티티를 위한 API가 다양하게 만들어지는데, 한 엔티티에 각각의 API를 위한
     * 모든 요청 요구사항을 담기는 어렵다.
     * >엔티티가 변경되면 API 스펙이 변한다.
     * == 결론, API 요청 스펙에 맞추어 별도의 DTO를 파라미터로 받는다.
     * @param member
     * @return
     */
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    /**
     * 등록 V2: 요청 값으로 Member 엔티티 대신에 별도의 DTO를 받는다.
     */
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){
        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);

    }

    /*update - REST API*/
    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2 (@PathVariable("id") Long id,
                                                @RequestBody @Valid UpdateMemberRequest request){

        memberService.update(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getName());
    }

    @Data
    static class UpdateMemberRequest{
        @NotEmpty
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse{
        private Long id;
        private String name;
    }

    @Data
    static class CreateMemberRequest{
        @NotEmpty
        private String name;
    }

    @Data
    static class CreateMemberResponse{
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }
}
