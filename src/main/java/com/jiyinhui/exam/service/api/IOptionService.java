package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.entity.Option;

import java.util.List;

public interface IOptionService {
    List<Option> searchOptionByItemId(Integer id);
}
