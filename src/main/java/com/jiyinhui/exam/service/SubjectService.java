package com.jiyinhui.exam.service;

import com.jiyinhui.exam.entity.Subject;
import com.jiyinhui.exam.mapper.SubjectMapper;
import com.jiyinhui.exam.service.api.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> getAllSubject() {
        return subjectMapper.getAllSubject();
    }

    @Override
    @Transactional
    public void modifySubject(Subject subject) {
        subjectMapper.modifySubject(subject);
    }

    @Override
    @Transactional
    public void insertSubject(Subject subject) {
        subjectMapper.insertSubject(subject);
    }

    @Override
    @Transactional
    public void deleteSubjectById(Integer id) {
        subjectMapper.deleteSubjectById(id);
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectMapper.getSubjectById(id);
    }
}
