package aeb;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired MemberRepository memberRepository;

	@Test
	@Transactional
	@Rollback(false)
	void testMember() {
		// given
		Member member = new Member();
		member.setUsername("kevin");
		
		// when
		Long savedId = memberRepository.save(member);
		Member findedMember = memberRepository.find(savedId);
		
		// then
		Assertions.assertThat(findedMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findedMember.getUsername()).isEqualTo(member.getUsername());
	}

}
