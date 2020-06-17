package com.manage.manageit.controller;

import com.manage.manageit.dto.CompetenceDto;
import com.manage.manageit.model.Competence;
import com.manage.manageit.service.CompetenceService;
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
@RequestMapping(path = "/competences")
public class CompetenceController {

	@Autowired
	private CompetenceService competenceService;


	@ApiOperation(value = "Ajouter une compétence")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<CompetenceDto> saveCompetence(@RequestBody Competence competence) {

		try {
			competenceService.saveCompetence(competence);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
