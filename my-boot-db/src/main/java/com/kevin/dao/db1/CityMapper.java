package com.kevin.dao.db1;

import com.kevin.model.db1.City;

/**
 * @author geyh
 * @create 2017-07-26 20:19
 */
public interface CityMapper {

    City selectByPrimaryKey(Integer id);
}
