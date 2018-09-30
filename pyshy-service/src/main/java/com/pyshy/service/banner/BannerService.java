package com.pyshy.service.banner;

import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.entity.banner.BannerAddParam;
import com.pyshy.entity.banner.BannerParam;
import com.pyshy.entity.banner.BannerVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {

    public List<BannerVO> pageQuery(BannerParam param);

    public Integer queryCount(BannerParam param);

    public ResponseResult addBanner(MultipartFile file, BannerAddParam param);

    public BannerVO bannerDetail(Long id);

}
