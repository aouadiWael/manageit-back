package com.manage.manageit.service;

import com.manage.manageit.model.Poste;

import java.util.List;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:45
 */
public interface PosteService {
	Poste savePoste(Poste poste);

	List<Poste> findAll();
}
