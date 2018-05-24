package com.jiyinhui.exam.utility;

import com.jiyinhui.exam.entity.ItemStatus;
import com.jiyinhui.exam.entity.ResourceData;
import com.jiyinhui.exam.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class ResourceDataUtility {

    public static List<ResourceData> fromSubject(List<Subject> subjects) {
        List<ResourceData> resourceDatas = new ArrayList<>();

        for (Subject subject : subjects) {
            ResourceData rd = new ResourceData();
            rd.setLabel(subject.getName());
            rd.setId(subject.getId());

            resourceDatas.add(rd);
        }
        return resourceDatas;
    }

    public static List<ResourceData> fromItemStatus() {
        List<ResourceData> resourceDatas = new ArrayList<>();

        for (ItemStatus is : ItemStatus.values()) {
            ResourceData rd = new ResourceData();
            rd.setLabel(is.getDescription());
            rd.setId(is.getId());

            resourceDatas.add(rd);
        }
        return resourceDatas;
    }
}
