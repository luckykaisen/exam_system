package com.jiyinhui.exam.controller.item.api;

import com.jiyinhui.exam.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class OptionVO {
    private Integer id;
    private String name;
    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static List<OptionVO> toVOs(List<Option> options) {
        List<OptionVO> vos = new ArrayList<>();

        for (Option option : options) {
            OptionVO vo = new OptionVO();
            vo.setId(option.getId());
            vo.setName(option.getOption());
            vo.setAnswer(option.getAnswer().getCode());

            vos.add(vo);
        }

        return vos;
    }
}
