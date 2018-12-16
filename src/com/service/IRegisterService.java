package com.service;

import java.util.List;

import com.entity.Register;

/**
 * @version 时间：2018年7月26日 上午10:11:45
 *
 */
public interface IRegisterService {
	List<Register> selectAll();
	int insert(Register register);
	int deleteByPrimaryKey(Integer usidint);
	int updateByPrimaryKey(Register register);
}
