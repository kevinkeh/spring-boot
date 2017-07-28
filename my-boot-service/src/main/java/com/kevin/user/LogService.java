package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.LogMapper;
import com.kevin.model.db2.Log;
import com.kevin.persistence.Page;
import com.kevin.persistence.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class LogService extends BaseService<Log,Integer> {

	@Autowired
	private LogMapper logMapper;
	/**
	 * 批量删除日志
	 * @param idList
	 */
	public void deleteLog(List<Integer> idList)
	{
		logMapper.deleteBatch(idList);
	}

	public Page<Log> search(Page<Log> logPage, List<PropertyFilter> filters ){
		logPage.setResult(super.search(logPage.getFrom(),logPage.getTo()));
		logPage.setTotalCount(logMapper.getTotalCount());
		return logPage;
	}

	@Override
	public BaseMapper<Log, Integer> getMapper() {
		return logMapper;
	}


	/**
	 * 多条件分页查询（carsdvendordb）
	 * @param page
	 * @param filters
	 * @return
	 */
	@Transactional(value = "osdvcTransactionManager")
	public Page<Log> searchByDto(Page<Log> page , List<PropertyFilter> filters, Log log){
		page.setResult(searchAirportList(log,page));
		page.setTotalCount(logMapper.selectTotalCount(log));
		return page;
	}

	/**
	 * 根据条件分页查询
	 * @param log
	 * @param page
	 * @return
	 */
	public List<Log> searchAirportList(Log log, Page<Log> page){
		log.setFrom(page.getFrom());
		log.setTo(page.getTo());
		return  logMapper.searchLogList(log);
	}

}
