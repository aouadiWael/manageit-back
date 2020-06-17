package com.manage.manageit.service.impl;

import com.manage.manageit.model.Competence;
import com.manage.manageit.repository.CompetenceRepository;
import com.manage.manageit.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:46
 */
@Service
public class CompetenceServiceImpl implements CompetenceService {

	@Autowired
	private CompetenceRepository competenceRepository;


	@Override
	public Competence saveCompetence(Competence competence) {
		return competenceRepository.save(competence);
	}
}
