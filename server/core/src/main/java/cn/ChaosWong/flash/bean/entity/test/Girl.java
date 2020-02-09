package cn.ChaosWong.flash.bean.entity.test;

import cn.ChaosWong.flash.bean.entity.BaseEntity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name="t_test_girl")
@Table(appliesTo = "t_test_girl",comment = "女孩")
public class Girl extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(32) COMMENT '姓名'")
    private String name;
    @Column(columnDefinition = "INT COMMENT '年龄'")
    private Integer age;
    @Column(columnDefinition = "DATE COMMENT '生日'")
    private Date birthday;
    @Column(name = "has_boy_friend",columnDefinition = "TINYINT COMMENT '是否有男朋友'")
    private Boolean hasBoyFriend;
}