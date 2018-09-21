package com.pyshy.service.picture;

import com.pyshy.entity.picture.PictureAddParam;
import com.pyshy.entity.picture.PictureParam;
import com.pyshy.entity.picture.PictureVO;
import com.pyshy.common.responseResult.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
    public List<PictureVO> pageQuery(PictureParam param);

    public Integer queryCount(PictureParam param);

    public ResponseResult addPicture(MultipartFile file, PictureAddParam param);

    public PictureVO pictureDetail(Long id);

}
