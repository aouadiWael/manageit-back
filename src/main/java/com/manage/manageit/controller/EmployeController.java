package com.manage.manageit.controller;

import com.manage.manageit.dto.EmployeDto;
import com.manage.manageit.model.Employe;
import com.manage.manageit.service.EmployeService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:54
 */
@RestController
@RequestMapping(path = "/employes")
public class EmployeController {

	@Autowired
	private EmployeService employeService;

	@Autowired
	private ModelMapper modelMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeController.class);


	@ApiOperation(value = "Ajouter un employé")
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<EmployeDto> saveEmploye(@RequestBody EmployeDto employeDto) {
		try {
			Employe employe = convertToEntity(employeDto);
			employeService.saveEmploye(employe);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Chercher un employé par id")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeDto> getEmployeById(@PathVariable("id") Long id) {
		LOGGER.info("Get employé ID : " + id);
		Optional<Employe> result = employeService.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<>(convertToDto(result.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@ApiOperation(value = "Mettre à jour un employé")
	@PutMapping(path = "/employe/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeDto> updateEmploye(@PathVariable("id") Long id,
	                                                @RequestBody EmployeDto employeDto) throws IOException {
		Employe updatedEmploye = employeService.updateEmploye(id, convertToEntity(employeDto));
		return new ResponseEntity<>(convertToDto(updatedEmploye), HttpStatus.OK);

	}


	@ApiOperation(value = "Liste des employés")
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeDto>> findAll() {
		List<EmployeDto> result = employeService.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	/**
	 * @param employe
	 * @return employeDto Object
	 */
	public EmployeDto convertToDto(Employe employe) {
		return modelMapper.map(employe, EmployeDto.class);
	}

	/**
	 * @param employeDto
	 * @return employe Entity
	 */
	public Employe convertToEntity(EmployeDto employeDto) throws IOException {
		Employe employe = modelMapper.map(employeDto, Employe.class);
		/*byte[] image = getImage();
		employe.setPhotoProfil(image);*/

		return employe;
	}


	/*public static byte[] getImage() {
		File file =new File("C:\\Users\\33778\\Desktop\\profile.jpg");
		if(file.exists()){
			try {
				BufferedImage bufferedImage= ImageIO.read(file);
				ByteArrayOutputStream byteOutStream=new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", byteOutStream);
				return byteOutStream.toByteArray();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}*/
}
