package cn.ChaosWong.flash.bean.vo.offcialsite;

import lombok.Data;

@Data
public class News {

    private String desc;

    private String url;

    private String src;
    public News(){

    }

    public News(String desc, String url, String src) {
        this.desc = desc;
        this.url = url;
        this.src = src;
    }
}
