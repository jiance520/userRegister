package com.entity;

import java.util.List;

/**
 * @version 时间：2018年7月26日 上午9:10:14
 *
 */
public interface RegisterMapper {
	List<Register> selectAll();
	int insert(Register register);
	int deleteByPrimaryKey(Integer usidint);
	int updateByPrimaryKey(Register register);
}
