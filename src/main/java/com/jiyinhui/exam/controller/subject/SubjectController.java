package com.jiyinhui.exam.controller.subject;

import com.jiyinhui.exam.controller.subject.api.CreateSubjectRequest;
import com.jiyinhui.exam.controller.subject.api.ModifySubjectRequest;
import com.jiyinhui.exam.controller.subject.api.SearchSubjectResponse;
import com.jiyinhui.exam.controller.subject.api.SubjectVO;
import com.jiyinhui.exam.controller.user.api.ServiceResponse;
import com.jiyinhui.exam.entity.DisciplineType;
import com.jiyinhui.exam.entity.Subject;
import com.jiyinhui.exam.service.api.ISubjectService;
import com.jiyinhui.exam.utility.ServiceResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @GetMapping(value = "/search")
    public SearchSubjectResponse searchSubjectById(@RequestParam("id") Integer id) {
        Subject subject = subjectService.getSubjectById(id);

        SubjectVO vo = SubjectVO.toVO(subject);
        SearchSubjectResponse response = new SearchSubjectResponse();
        response.setSubject(vo);

        return response;
    }

    @PostMapping(value = "/modify")
    public ServiceResponse modifySubject(@RequestBody ModifySubjectRequest request) {
        Subject subject = new Subject();
        subject.setId(request.getId());
        subject.setName(request.getSubjectName());
        subject.setDisciplineType(DisciplineType.fromCode(request.getDisciplineCode()));

        subjectService.modifySubject(subject);

        return ServiceResponseUtility.success();
    }

    @PostMapping(value = "/create")
    public ServiceResponse createSubject(@RequestBody CreateSubjectRequest request) {
        Subject subject = new Subject();
        subject.setName(request.getSubjectName());
        subject.setDisciplineType(DisciplineType.fromCode(request.getDisciplineCode()));

        subjectService.insertSubject(subject);

        return ServiceResponseUtility.success();
    }

    @GetMapping(value = "/delete")
    public ServiceResponse deleteSubject(@RequestParam("id") Integer id) {
        subjectService.deleteSubjectById(id);

        return ServiceResponseUtility.success();
    }
}
