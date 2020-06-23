package com.manage.manageit.controller;

import com.manage.manageit.dto.PosteDto;
import com.manage.manageit.model.Poste;
import com.manage.manageit.service.PosteService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:54
 */
@RestController
@RequestMapping(path = "/postes")
public class PosteController {

	@Autowired
	private PosteService posteService;

	@Autowired
	private ModelMapper modelMapper;


	@ApiOperation(value = "Ajouter un poste")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<PosteDto> savePoste(@RequestBody PosteDto posteDto) {

		try {
			Poste poste = convertToEntity(posteDto);
			posteService.savePoste(poste);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Liste des postes")
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<List<PosteDto>> findAll() {
		List<PosteDto> result = posteService.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	/**
	 * @param poste
	 * @return PosteDto Object
	 */
	public PosteDto convertToDto(Poste poste) {
		return modelMapper.map(poste, PosteDto.class);
	}

	/**
	 * @param posteDto
	 * @return Poste Entity
	 */
	public Poste convertToEntity(PosteDto posteDto) {
		return modelMapper.map(posteDto, Poste.class);
	}
}
