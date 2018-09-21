package com.pyshy.service.picture.impl;

import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.baseEnum.CommonEnum;
import com.pyshy.common.utils.HttpSplicingUtils;
import com.pyshy.common.utils.UserContextHelper;
import com.pyshy.dao.picture.PictureMapper;
import com.pyshy.entity.UploadResult;
import com.pyshy.entity.picture.PictureAddParam;
import com.pyshy.entity.picture.PicturePO;
import com.pyshy.entity.picture.PictureParam;
import com.pyshy.entity.picture.PictureVO;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.service.picture.PictureService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@MapperScan(value = "com.oak.model.dao.picture")
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<PictureVO> pageQuery(PictureParam param) {
        List<PicturePO> pos = pictureMapper.pageQuery(param);
        List<PictureVO> vos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(PicturePO po : pos){
            PictureVO vo = new PictureVO();
            BeanUtils.copyProperties(po,vo);
            vo.setImgUrlAll(HttpSplicingUtils.serverSplicing(vo.getImgUrl()));
            vo.setUpdateTimeStr(sdf.format(vo.getUpdateTime()));
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public Integer queryCount(PictureParam param) {
        return pictureMapper.queryCount(param);
    }

    @Override
    public ResponseResult addPicture(MultipartFile file, PictureAddParam param) {
        UploadResult uploadResult = handleFileUpload(file);

        ResponseResult result = new ResponseResult();
        if(uploadResult.getCode().equals(CommonEnum.INT_500.getCode())){
            result.setCode(uploadResult.getCode());
            result.setMessage(uploadResult.getMessage());
            return result;
        }
        save(param,uploadResult.getImgUrl());
        result.setCode(uploadResult.getCode());
        result.setMessage(uploadResult.getMessage());
        return result;
    }

    @Override
    public PictureVO pictureDetail(Long id) {
        PicturePO po = pictureMapper.pictureDetail(id);
        PictureVO vo = new PictureVO();
        BeanUtils.copyProperties(po,vo);
        vo.setImgUrlAll(HttpSplicingUtils.serverSplicing(vo.getImgUrl()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        vo.setUpdateTimeStr(sdf.format(vo.getUpdateTime()));
        vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
        return vo;
    }

    public void save(PictureAddParam param,String imgUrl){
        PicturePO po = new PicturePO();
        BeanUtils.copyProperties(param,po);
        po.setImgUrl(imgUrl);
        po.setCreateName(UserContextHelper.getRealName());
        po.setCreateTime(new Date());
        po.setUpdateTime(new Date());
        po.setUpdateName(UserContextHelper.getRealName());
        po.setState(CommonEnum.INT_0.getCode());
        pictureMapper.addPicture(po);
    }

    public UploadResult handleFileUpload(MultipartFile file){
        UploadResult result = null;
        String originalFilename = file.getOriginalFilename();

        if(originalFilename.indexOf("\\.") != -1){
            result = new UploadResult();
            result.setCode(CommonEnum.INT_500.getCode());
            result.setMessage(BizEnum.UPLOAD_FORMAT_IS_ERROR.getMessage());
            return result;
        }else{
            if(!originalFilename.split("\\.")[1].toLowerCase().equals("jpg")){
                result = new UploadResult();
                result.setCode(CommonEnum.INT_500.getCode());
                result.setMessage(BizEnum.UPLOAD_FORMAT_IS_ERROR.getMessage());
                return result;
            }
        }

        if(!file.isEmpty()){
            String storageName = UUID.randomUUID().toString();
            try{
                File f = new File(CommonEnum.STRING_SERVER_PORT.getRow() + storageName + "." + "jpg");
                f.createNewFile();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
                bos.write(file.getBytes());
                bos.flush();
                bos.close();
            }catch (FileNotFoundException ex){
                return uploadInfo(result,ex,null,CommonEnum.STRING_NO.getRow());
            }catch (IOException ex){
                ex.printStackTrace();
                return uploadInfo(result,ex,null,CommonEnum.STRING_NO.getRow());
            }catch (Exception ex){
                ex.printStackTrace();
                return uploadInfo(result,ex,null,CommonEnum.STRING_NO.getRow());
            }
            return uploadInfo(result,null,storageName,CommonEnum.STRING_NO.getRow());
        }
        return uploadInfo(result,null,null,CommonEnum.STRING_YES.getRow());
    }


    private UploadResult uploadInfo(UploadResult result,Exception ex,String fileName,String isNull){
        if(ex!=null && isNull.equals(CommonEnum.STRING_NO.getRow())){
            result = new UploadResult();
            result.setCode(CommonEnum.INT_500.getCode());
            result.setMessage(BizEnum.UPLOAD_ERROR.getMessage() + "，" + ex.getMessage());
            return result;
        }else if (ex == null && isNull.equals(CommonEnum.STRING_NO.getRow())){
            result = new UploadResult();
            result.setCode(CommonEnum.INT_200.getCode());
            result.setMessage(BizEnum.UPLOAD_SUCCESS.getMessage());
            result.setImgUrl(fileName+CommonEnum.STRING_IMG_JPG.getRow());
            return result;
        }else{
            result = new UploadResult();
            result.setCode(CommonEnum.INT_500.getCode());
            result.setMessage(BizEnum.UPLOAD_NOT_NULL.getMessage());
            return result;
        }

    }
}
