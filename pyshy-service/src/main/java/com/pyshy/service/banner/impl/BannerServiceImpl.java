package com.pyshy.service.banner.impl;

import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.baseEnum.CommonEnum;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.common.utils.UserContextHelper;
import com.pyshy.dao.banner.BannerMapper;
import com.pyshy.entity.banner.BannerAddParam;
import com.pyshy.entity.banner.BannerPO;
import com.pyshy.entity.banner.BannerParam;
import com.pyshy.entity.banner.BannerVO;
import com.pyshy.service.banner.BannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper mapper;


    @Override
    public List<BannerVO> pageQuery(BannerParam param) {
        List<BannerPO> bannerPOS = mapper.pageQuery(param);
        List<BannerVO> bannerVOS = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (BannerPO pos : bannerPOS) {
            BannerVO vo = new BannerVO();
            BeanUtils.copyProperties(pos, vo);
            byte[] buffer = (byte[]) vo.getPicture();
            vo.setUpdateTimeStr(sdf.format(vo.getUpdateTime()));
            vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
            bannerVOS.add(vo);
        }

            return bannerVOS;
        }

        @Override
        public Integer queryCount (BannerParam param){
            return mapper.queryCount(param);
        }

        @Override
        public ResponseResult addBanner (MultipartFile file, BannerAddParam param){
            BannerPO po = new BannerPO();
            try {
                InputStream in = file.getInputStream();
                FileInputStream fis = (FileInputStream) in;
                try {
                    BufferedImage image = ImageIO.read(file.getInputStream());
                    if (image != null) {//如果image=null 表示上传的不是图片格式
                        System.out.println(image.getWidth());//获取图片宽度，单位px
                        System.out.println(image.getHeight());//获取图片高度，单位px
                    } else {
                        System.out.println("这不是图片");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] data = new byte[1024];
                byte[] buff = null;
                int len;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int n;
                while ((n = fis.read(b)) != -1) {
                    bos.write(b, 0, n);
                }
                fis.close();
                bos.close();
                buff = bos.toByteArray();

                BeanUtils.copyProperties(param, po);
                po.setPicture(buff);
                po.setCreateName(UserContextHelper.getRealName());
                po.setCreateTime(new Date());
                po.setUpdateTime(new Date());
                po.setUpdateName(UserContextHelper.getRealName());
                po.setState(CommonEnum.INT_0.getCode());
                Long i = mapper.addBanner(po);
                ResponseResult result = new ResponseResult();
                if (i != null) {
                    result.setCode(CommonEnum.INT_200.getCode());
                    result.setMessage(BizEnum.SUCCESS.getMessage());
                    return result;
                } else {
                    result.setCode(CommonEnum.INT_500.getCode());
                    result.setMessage(BizEnum.UPLOAD_ERROR.getMessage());
                    return result;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        public BannerVO bannerDetail (Long id){
            BannerPO bannerPO = mapper.bannerDetail(id);
            BannerVO vo = new BannerVO();
            BeanUtils.copyProperties(bannerPO, vo);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            vo.setUpdateTimeStr(sdf.format(vo.getUpdateTime()));
            vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
            return vo;
        }
    }
