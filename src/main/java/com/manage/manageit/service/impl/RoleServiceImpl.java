package com.manage.manageit.service.impl;

import com.manage.manageit.model.Role;
import com.manage.manageit.repository.RoleRepository;
import com.manage.manageit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Wael AOUADI
 * @create 08/06/2020 23:46
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
}
