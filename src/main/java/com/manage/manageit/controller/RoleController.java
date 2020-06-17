package com.manage.manageit.controller;

import com.manage.manageit.dto.RoleDto;
import com.manage.manageit.model.Role;
import com.manage.manageit.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:54
 */
@RestController
@RequestMapping(path = "/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;


	@ApiOperation(value = "Ajouter un rôle")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<RoleDto> saveRole(@RequestBody Role role) {

		try {
			roleService.saveRole(role);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
