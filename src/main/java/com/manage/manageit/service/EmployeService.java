package com.manage.manageit.service;

import com.manage.manageit.model.Employe;

import java.util.List;
import java.util.Optional;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:45
 */
public interface EmployeService {
	Employe saveEmploye(Employe employe);

	List<Employe> findAll();

	Optional<Employe> findById(Long id);

	Employe updateEmploye(Long id, Employe employe);
}
