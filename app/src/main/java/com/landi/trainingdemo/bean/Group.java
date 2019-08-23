package com.landi.trainingdemo.bean;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoj on 2019/6/10.
 */

public class Group {
    private int groupId;
    private List<Student> students=new ArrayList<Student>();

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", students=" + students +
                '}';
    }
}
