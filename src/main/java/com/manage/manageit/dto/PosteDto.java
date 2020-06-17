package com.manage.manageit.dto;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:55
 */
@Data
public class PosteDto {

	private Long id;
	private String code;
	private String label;
	private List<EmployeDto> employeDtos;
}
