package com.jiyinhui.exam.controller.resource;

import com.jiyinhui.exam.entity.ResourceData;
import com.jiyinhui.exam.entity.Subject;
import com.jiyinhui.exam.service.api.ISubjectService;
import com.jiyinhui.exam.utility.ResourceDataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/resource/service")
public class ResourceDataController {

    @Autowired
    private ISubjectService subjectService;

    /**
     * 学科下拉菜单
     * @return
     */
    @GetMapping(value = "/subject")
    public List<ResourceData> getSubject() {
        List<Subject> subjects = subjectService.getAllSubject();

        return ResourceDataUtility.fromSubject(subjects);
    }

    /**
     * 题型(选择、判断、多选)
     * @return
     */
    @GetMapping(value = "/item/status")
    public List<ResourceData> getItemStatus() {
        return ResourceDataUtility.fromItemStatus();
    }
}
