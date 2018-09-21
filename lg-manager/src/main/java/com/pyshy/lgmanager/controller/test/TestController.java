package com.pyshy.lgmanager.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.baseEnum.CommonEnum;
import com.pyshy.common.utils.UserContextHelper;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.entity.test.TestPO;
import com.pyshy.entity.test.TestParam;
import com.pyshy.entity.test.TestVO;

import com.pyshy.service.test.TestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/test/list");
        return mav;
    }

    @RequestMapping(value = "/pageQuery")
    @ResponseBody
    public ResponseResult pageQuery(TestParam param){

        List<TestVO> list = service.pageQuery(param);
        ResponseResult result = new ResponseResult();
        result.setRows(list);
        result.setTotal(service.queryCount(param));
        return result;
    }

    @RequestMapping(value = "/openAdd")
    public ModelAndView openAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/test/add_category");
        return mav;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView openDetail(Long id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/test/test_detail");

        TestVO category = service.queryById(id);
        List<TestVO> select = service.queryByParentId(category.getId());

        mav.addObject("category",category);
        mav.addObject("select",select);

        return mav;
    }

    @RequestMapping(value = "/openUpdate")
    @ResponseBody
    public ModelAndView openUpdate(Long id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/test/add_category");
        TestVO vo = service.queryById(id);
        List<TestVO> childrenVO = service.queryByParentId(vo.getId());
        mav.addObject("categoryVO",vo);
        mav.addObject("children",childrenVO);
        return mav;
    }

    @RequestMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseResult save(@RequestBody String jsonParam) {
        ResponseResult responseResult = new ResponseResult();
        JSONObject object = JSONObject.parseObject(jsonParam);
        TestPO param = object.toJavaObject(TestPO.class);

        TestPO categoryParam = new TestPO();
        categoryParam.setState(CommonEnum.INT_0.getCode());
        categoryParam.setCategory(param.getCategory());
        categoryParam.setUpdateName(UserContextHelper.getRealName());
        categoryParam.setUpdateTime(new Date());

        int success = service.insertTest(categoryParam);
        String category = param.getCategory();
        if(StringUtils.isEmpty(category)){
            responseResult.setMessage(BizEnum.CATEGORY_NOT_NULL.getMessage());
            responseResult.setCode(CommonEnum.INT_500.getCode());
            return responseResult;
        }
        TestVO key = service.queryByCategory(category);

        String[] addSelectParam = param.getAddSelect().substring(0,param.getAddSelect().length()-1).split(",");
        String[] errorInfoParam = param.getErrorInfo().substring(0,param.getErrorInfo().length()-1).split(",");

        boolean isOk = insertChildren(addSelectParam,errorInfoParam,key.getId());
        if(!isOk){
            responseResult.setCode(CommonEnum.INT_500.getCode());
            responseResult.setMessage("新增失败");
            return responseResult;
        }

        responseResult.setMessage(BizEnum.SUCCESS.getMessage());
        responseResult.setCode(Integer.parseInt(BizEnum.SUCCESS.getCode()));
        return responseResult;
    }

    @RequestMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseResult update(@RequestBody String jsonParam) {
        ResponseResult responseResult = new ResponseResult();
        JSONObject object = JSONObject.parseObject(jsonParam);
        TestPO param = object.toJavaObject(TestPO.class);

        TestPO categoryParam = new TestPO();
        categoryParam.setState(CommonEnum.INT_0.getCode());
        categoryParam.setCategory(param.getCategory());
        categoryParam.setUpdateName(UserContextHelper.getRealName());
        categoryParam.setUpdateTime(new Date());
        categoryParam.setId(param.getId());
        service.updateCategory(categoryParam);
//        service.updateCategory(categoryParam);

        String category = param.getCategory();
//        TestVO key = service.queryByCategory(category);

        String[] addSelectParam = param.getAddSelect().substring(0,param.getAddSelect().length()-1).split(",");
        String[] errorInfoParam = param.getErrorInfo().substring(0,param.getErrorInfo().length()-1).split(",");
//        String[] childrenId = param.getChildrenId().substring(0,param.getChildrenId().length()-1).split(",");

        service.deleteByParentId(param.getId());

        boolean isOk = insertChildren(addSelectParam,errorInfoParam,param.getId());

        if(!isOk){
            responseResult.setCode(CommonEnum.INT_500.getCode());
            responseResult.setMessage("修改失败");
            return responseResult;
        }

        responseResult.setMessage(BizEnum.SUCCESS.getMessage());
        responseResult.setCode(Integer.parseInt(BizEnum.SUCCESS.getCode()));
        return responseResult;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseResult delete(Long id){
        service.deleteCategory(id);
        service.deleteByParentId(id);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setMessage(BizEnum.SUCCESS.getMessage());
        responseResult.setCode(CommonEnum.INT_200.getCode());
        return responseResult;
    }

    private boolean insertChildren(String[] addSelectParam,String[] errorInfoParam,Long categoryId){
        for(int i = 0 ; i < addSelectParam.length  ; i++){
            TestPO selectParam = new TestPO();

            selectParam.setState(CommonEnum.INT_0.getCode());
            selectParam.setUpdateTime(new Date());
            selectParam.setUpdateName(UserContextHelper.getRealName());
            selectParam.setParentId(categoryId);
            selectParam.setAddSelect(addSelectParam[i]);
            selectParam.setErrorInfo(errorInfoParam[i]);

            int keys = service.insertTest(selectParam);
            if(keys == 0){
                return false;
            }
            System.out.println(selectParam);
        }
        return true;
    }

}
