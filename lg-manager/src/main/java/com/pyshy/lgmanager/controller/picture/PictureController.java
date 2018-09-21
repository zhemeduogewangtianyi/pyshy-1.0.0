package com.pyshy.lgmanager.controller.picture;

import com.alibaba.fastjson.JSONObject;
import com.pyshy.entity.picture.PictureAddParam;
import com.pyshy.entity.picture.PictureParam;
import com.pyshy.entity.picture.PictureVO;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.service.picture.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping(value = "/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/picture/list");
        return mav;
    }

    @RequestMapping(value = "/pageQuery")
    @ResponseBody
    public ResponseResult pageQuery(PictureParam param){
        List<PictureVO> pictureVOS = pictureService.pageQuery(param);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setRows(pictureVOS);
        responseResult.setTotal(pictureService.queryCount(param));
        return responseResult;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView detail(Long id){
        ModelAndView mav = new ModelAndView();
        PictureVO vo = pictureService.pictureDetail(id);
        mav.setViewName("/picture/detail");
        mav.addObject("vo",vo);
        return mav;
    }

    @RequestMapping(value = "/openAdd")
    public ModelAndView openAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/picture/add_picture");
        return mav;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseResult upload(@RequestParam("file") MultipartFile file, @RequestParam("param") String param){

        JSONObject json = JSONObject.parseObject(param);
        PictureAddParam pictureAddParam = json.toJavaObject(PictureAddParam.class);

        ResponseResult result = pictureService.addPicture(file,pictureAddParam);
        return result;
    }



    /**
     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
     * @param request
     * @return
     */

    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
    public@ResponseBody
    String handleFileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream =  null;
                    return"You failed to upload " + i + " => " + e.getMessage();
                }
            } else {
                return"You failed to upload " + i + " because the file was empty.";
            }
        }
        return"upload successful";
    }
}
