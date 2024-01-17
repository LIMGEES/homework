package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	@Autowired
    private QuestionRepository questionRepository;
	
	@Test
	void testJpa() {
		 Optional<Question> oq = this.questionRepository.findById(1);
	        if(oq.isPresent()) {
	            Question q = oq.get();
	            assertEquals("sbb가 무엇인가요?", q.getSubject());
	            System.out.println(q.toString());
	        }
	}

}
