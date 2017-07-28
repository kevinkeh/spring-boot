package com.kevin.dao.db2;


import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper extends BaseMapper<Log,Integer> {
    void deleteBatch(List<Integer> idList);

    int selectTotalCount(Log log);

    List<Log> searchLogList(Log log);

    int getTotalCount();

}