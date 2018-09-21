package com.pyshy.service.test.impl;

import com.pyshy.dao.test.TestMapper;
import com.pyshy.entity.test.TestPO;
import com.pyshy.entity.test.TestParam;
import com.pyshy.entity.test.TestVO;
import com.pyshy.service.test.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@MapperScan(value = "com.oak.model.dao.test")
public class TestServiceImpl implements TestService {

    @Resource
    @Qualifier("testMapper")
    private TestMapper testMapper;

    @Override
    public List<TestVO> pageQuery(TestParam param) {
        List<TestVO> result = testMapper.pageQuery(param);
        for(TestVO vo : result){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(vo.getUpdateTime() != null){
                String timeStr = sdf.format(vo.getUpdateTime());
                vo.setUpdateStr(timeStr);
            }
        }
        return result;
    }

    @Override
    public Integer queryCount(TestParam param) {
        return testMapper.queryCount(param);
    }

    @Override
    public TestVO queryByCategory(String category) {
        return testMapper.queryByCategory(category);
    }

    @Override
    public TestVO queryById(Long id) {
        TestVO vo = testMapper.queryById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        vo.setUpdateStr(sdf.format(vo.getUpdateTime()));
        return vo;
    }

    @Override
    public List<TestVO> queryByParentId(Long parentId) {
        List<TestVO> vos = testMapper.queryByParentId(parentId);
        for(TestVO vo : vos){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            vo.setUpdateStr(sdf.format(vo.getUpdateTime()));
        }
        return vos;
    }

    @Override
    public int insertTest(TestPO param) {
        return testMapper.insertTest(param);
    }


    @Override
    public void updateCategory(TestPO param) {
        testMapper.updateCategory(param);
    }

    @Override
    public void updateSelect(TestPO param) {
        testMapper.updateSelect(param);
    }

    @Override
    public void deleteCategory(Long id) {
        testMapper.deleteCategory(id);
    }

    @Override
    public void deleteByParentId(Long parentId) {
        testMapper.deleteByParentId(parentId);
    }

    @Override
    public void deleteById(Long id) {
        testMapper.deleteById(id);
    }
}
