package com.pyshy.service.test;

import com.pyshy.entity.test.TestPO;
import com.pyshy.entity.test.TestParam;
import com.pyshy.entity.test.TestVO;

import java.util.List;

public interface TestService {

    public List<TestVO> pageQuery(TestParam param);

    public Integer queryCount(TestParam param);

    public TestVO queryByCategory(String category);

    public TestVO queryById(Long id);

    public List<TestVO> queryByParentId(Long parentId);

    public int insertTest(TestPO param);

    public void updateCategory(TestPO param);

    public void updateSelect(TestPO param);

    public void deleteCategory(Long id);

    public void deleteByParentId(Long parentId);

    public void deleteById(Long id);

}
