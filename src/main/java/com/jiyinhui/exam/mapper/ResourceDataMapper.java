package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceDataMapper {
    List<Subject> getAllSubject();
}
