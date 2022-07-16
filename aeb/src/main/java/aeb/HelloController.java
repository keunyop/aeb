package aeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@Autowired MemberRepository memberRepository;

	@GetMapping("hello")
	@Transactional
	public String Hello(Model model) {
		
		Member member = new Member();
		member.setUsername("kevin");
		
		// when
		memberRepository.save(member);
		
		
		model.addAttribute("data", "hello!!!");
		return "hello";
	}

}
