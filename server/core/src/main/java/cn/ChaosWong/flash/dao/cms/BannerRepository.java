
package cn.ChaosWong.flash.dao.cms;

import cn.ChaosWong.flash.bean.entity.cms.Banner;
import cn.ChaosWong.flash.dao.BaseRepository;

import java.util.List;

public interface BannerRepository extends BaseRepository<Banner,Long> {

    List<Banner> findAllByType(String type);
}
