package com.manage.manageit.controller;

import com.manage.manageit.dto.EmployeDto;
import com.manage.manageit.model.Employe;
import com.manage.manageit.service.EmployeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:54
 */
@RestController
@RequestMapping(path = "/employes")
public class EmployeController {

	@Autowired
	private EmployeService employeService;


	@ApiOperation(value = "Ajouter un employé")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<EmployeDto> saveRole(@RequestBody Employe employe) {

		try {
			employeService.saveEmploye(employe);
		} catch (Exception ex) {
			System.out.println(ex);
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}


	@ApiOperation(value = "Liste des employés")
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<List<Employe>> findAll() {
		List<Employe> result = employeService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
