package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISubjectService {
    List<Subject> getAllSubject();

    void modifySubject(@Param("subject") Subject subject);

    void insertSubject(@Param("subject") Subject subject);

    void deleteSubjectById(Integer id);

    Subject getSubjectById(Integer id);
}
