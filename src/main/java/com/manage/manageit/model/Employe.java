package com.manage.manageit.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Wael AOUADI
 * @create 09/06/2020 23:51
 */


@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class Employe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employe_id")
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
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] photoProfil;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poste_id")
	private Poste poste;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;

}
