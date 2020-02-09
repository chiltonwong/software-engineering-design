package cn.ChaosWong.flash.service.cms;

import cn.ChaosWong.flash.bean.entity.cms.Banner;
import cn.ChaosWong.flash.bean.enumeration.cms.BannerTypeEnum;
import cn.ChaosWong.flash.bean.vo.offcialsite.BannerVo;
import cn.ChaosWong.flash.dao.cms.BannerRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService extends BaseService<Banner,Long,BannerRepository> {
    @Autowired
    private BannerRepository bannerRepository;


    public BannerVo queryIndexBanner(){
    return queryBanner(BannerTypeEnum.INDEX.getValue());
    }

    public BannerVo queryBanner(String type){
        BannerVo banner = new BannerVo();
        List<cn.ChaosWong.flash.bean.entity.cms.Banner> bannerList = bannerRepository.findAllByType(type);
        banner.setIndex(0);
        banner.setList(bannerList);
        return  banner;
    }
}
