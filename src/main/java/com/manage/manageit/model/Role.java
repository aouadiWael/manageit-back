package com.manage.manageit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:40
 */

@Entity
@Data
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;
	private String code;
	private String label;
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<Employe> employes;
}
