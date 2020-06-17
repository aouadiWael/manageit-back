package com.manage.manageit.controller;

import com.manage.manageit.dto.PosteDto;
import com.manage.manageit.model.Poste;
import com.manage.manageit.service.PosteService;
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
@RequestMapping(path = "/postes")
public class PosteController {

	@Autowired
	private PosteService posteService;


	@ApiOperation(value = "Ajouter un poste")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<PosteDto> savePoste(@RequestBody Poste poste) {

		try {
			posteService.savePoste(poste);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Liste des postes")
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<List<Poste>> findAll(){
		List<Poste> result = posteService.findAll();
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
