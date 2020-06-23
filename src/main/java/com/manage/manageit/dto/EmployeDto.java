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
	private String adresse;
	private String tel;
	private Date dateDebutExp;
	private PosteDto poste;
	private RoleDto role;
}
