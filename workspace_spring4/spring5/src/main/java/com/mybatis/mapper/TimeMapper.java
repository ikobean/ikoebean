package com.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT sysdate from dual")
	public String getTime();
	
}
