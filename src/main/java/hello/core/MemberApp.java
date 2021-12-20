package hello.core;

public class MemberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService memberService = new MemberServiceImpl();
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("find Member : " + findMember.getName());
		System.out.println("new Member : " + member.getName());
	}

}
