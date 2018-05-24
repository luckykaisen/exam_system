package com.jiyinhui.exam.controller.examination.paper.api;

import com.jiyinhui.exam.entity.Bool;
import com.jiyinhui.exam.entity.ExaminationPaperAnswer;
import com.jiyinhui.exam.entity.ExaminationPaperOption;
import com.jiyinhui.exam.entity.Option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExaminationPaperItemVO {
    private Integer itemId;
    private String itemName;
    private String code;
    private String right;
    private List<OptionAnswerVO> options;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<OptionAnswerVO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionAnswerVO> options) {
        this.options = options;
    }

    /**
     *
     * @param examinationPaperOption : 试卷中的题目
     * @param answer : 学生的答案
     * @param options : 该题目的选项
     * @return
     */
    public static ExaminationPaperItemVO toVO(ExaminationPaperOption examinationPaperOption, List<ExaminationPaperAnswer> answer, List<Option> options) {
        ExaminationPaperItemVO vo = new ExaminationPaperItemVO();

        vo.setItemId(examinationPaperOption.getItemPool().getId());
        vo.setItemName(examinationPaperOption.getItemPool().getTopic());
        vo.setCode(examinationPaperOption.getItemPool().getItemStatus().getCode());



        // 学生所选择的id
        List<Integer> answerIds = new ArrayList<>();
        for (ExaminationPaperAnswer a : answer) {
            answerIds.add(a.getOption().getId());
        }

        List<Integer> correctIds = new ArrayList<>();

        List<OptionAnswerVO> answers = new ArrayList<>();
        for (Option option : options) {
            OptionAnswerVO answerVO = new OptionAnswerVO();
            answerVO.setId(option.getId());
            answerVO.setName(option.getOption());
            answerVO.setAnswer(option.getAnswer().getCode());
            // 包含说明选择了该题
            if (answerIds.contains(option.getId())) {
                answerVO.setChoice(Bool.Y.getCode());
            } else {
                answerVO.setChoice(Bool.N.getCode());
            }

            if (Bool.Y.equals(option.getAnswer())) {
                correctIds.add(option.getId());
            }
            answers.add(answerVO);
        }

        if (answerIds.containsAll(correctIds) && correctIds.containsAll(answerIds)) {
            vo.setCode(Bool.Y.getCode());
        } else {
            vo.setCode(Bool.N.getCode());
        }
        vo.setOptions(answers);

        return vo;
    }
}
