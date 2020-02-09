package cn.ChaosWong.flash.bean.entity.cms;

import cn.ChaosWong.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name="t_cms_dish")
@Table(appliesTo = "t_cms_dish",comment = "菜品")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Dish extends BaseEntity {
    @Column(columnDefinition = "BIGINT COMMENT '分类id'")
    @NotNull(message = "分类不能为空")
    private Long idChannel;
    @Column(columnDefinition = "VARCHAR(128) COMMENT '名称'")
    @NotBlank(message = "名称不能为空")
    private String title;
    @Column(columnDefinition = "TEXT COMMENT '描述'")
    @NotBlank(message = "描述不能为空")
    private String content;
    @Column(columnDefinition = "INT COMMENT '价格'")
    @NotNull(message = "价格不能为空")
    private int price;
    @Column(columnDefinition = "INT COMMENT '库存'")
    @NotNull(message = "库存不能为空")
    private int inventory;
    @Column(columnDefinition = "VARCHAR(64) COMMENT '图片ID'")
    private String img;
}
