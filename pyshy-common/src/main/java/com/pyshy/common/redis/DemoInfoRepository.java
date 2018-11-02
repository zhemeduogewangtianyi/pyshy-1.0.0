package com.pyshy.common.redis;

import com.pyshy.entity.DemoInfo;
import org.springframework.data.repository.CrudRepository;

public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long> {
}
