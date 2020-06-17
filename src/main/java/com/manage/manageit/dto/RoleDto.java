package com.manage.manageit.dto;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:55
 */
@Data
public class RoleDto {

	@Id
	private Long id;
	private String code;
	private String label;
}
