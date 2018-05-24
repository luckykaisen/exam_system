package com.jiyinhui.exam.service;

import com.jiyinhui.exam.entity.Option;
import com.jiyinhui.exam.mapper.OptionMapper;
import com.jiyinhui.exam.service.api.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements IOptionService {

    @Autowired
    private OptionMapper optionMapper;


    @Override
    public List<Option> searchOptionByItemId(Integer id) {
        return optionMapper.getOptionByItemPoolId(id);
    }
}
