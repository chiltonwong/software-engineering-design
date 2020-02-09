package cn.ChaosWong.flash.bean.vo.node;

import cn.ChaosWong.flash.bean.entity.system.Dept;

import java.util.ArrayList;
import java.util.List;


public class DeptNode extends Dept {

    private List<DeptNode> children = new ArrayList<>(10);

    public List<DeptNode> getChildren() {
        return children;
    }

    public void setChildren(List<DeptNode> children) {
        this.children = children;
    }
}
