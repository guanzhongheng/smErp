package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TProdplanExe;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TProdplanExeMapper {

    int insertBatch(@Param("list") List<TProdplanExe> prodplanExes);
}
