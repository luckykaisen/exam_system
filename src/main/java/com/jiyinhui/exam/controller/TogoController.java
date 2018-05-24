package com.jiyinhui.exam.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TogoController {

    @GetMapping(value = "/create/paper")
    public String togoCreatePaper() {
        return "teacher/createPaper";
    }


    @GetMapping(value = "/toSection")
    public String togoSection(HttpSession session) {
        session.setAttribute("correntMenu", "menu_section");
        return "teacher/section/section";
    }

    @GetMapping(value = "/toModifySection")
    public String toGoModifySection(@RequestParam("id") String id,
                                    @RequestParam("name") String name,
                                    Map<String, Object> map) {
        map.put("id", id);
        map.put("name", name);

        return "teacher/section/modifySection";
    }

    @GetMapping(value = "/toAddSection")
    public String toGoAddSection() {
        return "teacher/section/addSection";
    }

    @GetMapping(value = "/toRank")
    public String toGoRank(HttpSession session) {
        session.setAttribute("correntMenu", "menu_rank");
        return "teacher/rank/examRecord";
    }

    @GetMapping(value = "/toExamRank")
    public String toExamRank(@RequestParam("id") String id, Map<String, Object> map) {
        map.put("id", id);

        return "teacher/rank/showRank";
    }

    @GetMapping(value = "/toOption")
    public String toGoOption(@RequestParam("id") Integer id, Map<String, Object> map) {
        map.put("sectionId", id);
        return "teacher/option/option";
    }


    @GetMapping(value = "/toAddItem")
    public String toGoAddItem(@RequestParam("id") Integer id, Map<String, Object> map) {
        map.put("sectionId", id);

        return "teacher/option/addOption";
    }

    @GetMapping(value = "/toPaper")
    public String toGOPaper(HttpSession session) {
        session.setAttribute("correntMenu", "menu_paper");

        return "teacher/paper/paper";
    }

    @GetMapping(value = "/addPaper")
    public String toGOAddPaper() {
        return "teacher/paper/addPaper";
    }

    @GetMapping(value = "/toExam")
    public String toGoExam(@RequestParam("id") Integer id, Map<String, Object> map) {
        map.put("themeId", id);

        return "student/exam";
    }

    @GetMapping(value = "/exam")
    public String exam(HttpSession session) {
        session.setAttribute("correntMenu", "menu_exam");
        return "student/examRecord";
    }

    @GetMapping(value = "/toShowScore")
    public String toGoShowScore(HttpSession session) {
        session.setAttribute("correntMenu", "menu_score");

        return "student/examHistoryRecord";
    }

    @GetMapping(value = "/toModifyPaper")
    public String toGoModifyPaper(@RequestParam("id") Integer id, Map<String, Object> map) {
        map.put("id", id);

        return "teacher/paper/modifyPaper";
    }

    @GetMapping(value = "/toSubject")
    public String toGoSubject(HttpSession session) {
        session.setAttribute("correntMenu", "menu_subject");

        return "teacher/subject/subject";
    }

    @GetMapping(value = "/toModifySubject")
    public String toGoModifySubject(@RequestParam("id") Integer id, Map<String, Object> map) {
        map.put("id", id);

        return "teacher/subject/modifySubject";
    }

    @GetMapping(value = "/toAddSubject")
    public String toGoAddSubject() {
        return "teacher/subject/addSubject";
    }
}