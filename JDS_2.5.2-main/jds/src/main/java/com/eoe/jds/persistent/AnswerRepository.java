package com.eoe.jds.persistent;

import com.eoe.jds.entity.Answer;
import com.eoe.jds.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}

