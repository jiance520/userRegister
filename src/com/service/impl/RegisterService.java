package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Register;
import com.entity.RegisterMapper;
import com.service.IRegisterService;

/**
 * @version 时间：2018年7月26日 上午10:12:34
 *
 */
@Service("registerService")
public class RegisterService implements IRegisterService {
	private RegisterMapper registerMapper;

	public RegisterMapper getRegisterMapper() {
		return registerMapper;
	}
	@Autowired
	public void setRegisterMapper(RegisterMapper registerMapper) {
		this.registerMapper = registerMapper;
	}
	@Override
	public List<Register> selectAll() {
		return  registerMapper.selectAll();
	}
	@Override
	public int insert(Register register) {
		return registerMapper.insert(register);
	}
	@Override
	public int deleteByPrimaryKey(Integer usidint){
		return  registerMapper.deleteByPrimaryKey(usidint);
	}
	@Override
	public int updateByPrimaryKey(Register register) {
		return updateByPrimaryKey(register);
	}
	
}
