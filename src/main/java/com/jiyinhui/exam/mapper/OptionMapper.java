package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.Option;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OptionMapper {
    void createOption(@Param("option") Option option);

    List<Option> getOptionByItemPoolId(@Param("id") Integer id);

}
