package com.manage.manageit.service.impl;

import com.manage.manageit.model.Poste;
import com.manage.manageit.repository.PosteRepository;
import com.manage.manageit.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:46
 */
@Service
public class PosteServiceImpl implements PosteService {

	@Autowired
	private PosteRepository posteRepository;

	@Override
	public Poste savePoste(Poste poste) {
		return posteRepository.save(poste);
	}

	@Override
	public List<Poste> findAll() {
		return posteRepository.findAll();
	}
}
