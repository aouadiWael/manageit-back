package com.manage.manageit.service.impl;

import com.manage.manageit.model.Employe;
import com.manage.manageit.repository.EmployeRepository;
import com.manage.manageit.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:46
 */
@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepository employeRepository;


	@Override
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}

	@Override
	public Optional<Employe> findById(Long id) {
		return employeRepository.findById(id);
	}

	@Override
	public Employe updateEmploye(Long id, Employe employe) {
		if (employeRepository.findById(id).isPresent()) {
			Employe updatedEmploye = employeRepository.save(employe);

			return updatedEmploye;
		}
		return null;
	}
}
