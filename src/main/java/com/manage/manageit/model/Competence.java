package com.manage.manageit.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author Wael AOUADI
 * @create 09/06/2020 23:31
 */
@Entity
@Data
public class Competence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "competence_id")
	private Long id;
	private String code;
	private String nom;
}
