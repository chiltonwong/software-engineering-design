package cn.ChaosWong.flash.bean.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String account;
    private String password;
    private String name;
    private Long deptId;
    private List<Long> roleList;
    private String deptName;
    private List<String> roleNames;
    private List<String> roleCodes;
    private Set<String> urls;
    private Set<String> permissions;

}
