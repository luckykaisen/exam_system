package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper {
    List<Subject> getAllSubject();

    void modifySubject(@Param("subject") Subject subject);

    void insertSubject(@Param("subject")Subject subject);

    void deleteSubjectById(@Param("id") Integer id);

    Subject getSubjectById(@Param("id")Integer id);
}
