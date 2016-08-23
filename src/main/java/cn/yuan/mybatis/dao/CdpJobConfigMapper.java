package cn.yuan.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import cn.yuan.mybatis.entity.CdpJobConfig;
import cn.yuan.mybatis.util.MyMapper;

public interface CdpJobConfigMapper extends MyMapper<CdpJobConfig> {
	CdpJobConfig selectByCode(@Param("code")String code);
}
