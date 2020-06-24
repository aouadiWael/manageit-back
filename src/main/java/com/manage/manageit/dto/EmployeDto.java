package com.manage.manageit.dto;

import com.manage.manageit.model.Poste;
import com.manage.manageit.model.Role;
import lombok.Data;

import java.util.Date;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:55
 */
@Data
public class EmployeDto {

	private Long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String mail;
	private String tel;
	private Date dateDebutExp;
	private int numRue;
	private String rue;
	private int codePostal;
	private String complementAdresse;
	private String ville;
	private String pays;
	private String nationalite;
	private PosteDto poste;
	private RoleDto role;
}
