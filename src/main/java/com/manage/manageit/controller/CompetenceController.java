package com.manage.manageit.controller;

import com.manage.manageit.dto.CompetenceDto;
import com.manage.manageit.model.Competence;
import com.manage.manageit.service.CompetenceService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;


	@ApiOperation(value = "Ajouter une compétence")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<CompetenceDto> saveCompetence(@RequestBody CompetenceDto competenceDto) {

		try {
			Competence competence = convertToEntity(competenceDto);
			competenceService.saveCompetence(competence);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * @param competence
	 * @return competenceDto Object
	 */
	public CompetenceDto convertToDto(Competence competence) {
		return modelMapper.map(competence, CompetenceDto.class);
	}

	/**
	 * @param competenceDto
	 * @return Competence Entity
	 */
	public Competence convertToEntity(CompetenceDto competenceDto) {
		return modelMapper.map(competenceDto, Competence.class);
	}
}
