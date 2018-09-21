package com.pyshy.dao.test;

import com.pyshy.entity.test.TestPO;
import com.pyshy.entity.test.TestParam;
import com.pyshy.entity.test.TestVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "testMapper")
public interface TestMapper {

    public List<TestVO> pageQuery(TestParam param);

    public Integer queryCount(TestParam param);

    public TestVO queryByCategory(String category);

    public int insertTest(TestPO param);

    public void updateCategory(TestPO param);

    public void updateSelect(TestPO param);

    public void deleteCategory(Long id);

    public void deleteByParentId(Long parentId);

    public TestVO queryById(Long id);

    public List<TestVO> queryByParentId(Long parentId);

    public void deleteById(Long id);

}
