package com.pyshy.dao.banner;

import com.pyshy.entity.banner.BannerPO;
import com.pyshy.entity.banner.BannerParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "bannerMapper")
public interface BannerMapper {

    public List<BannerPO> pageQuery(BannerParam param);

    public Integer queryCount(BannerParam param);

    public Long addBanner(BannerPO po);

    public BannerPO bannerDetail(Long id);

    public void bannerDelete(Long id);

    public Long updateBanner(BannerPO po);

    public void bannerStop(Long id);

    public void bannerEnable(Long id);

}
