package com.kevin.web;

import com.kevin.dao.db1.CityMapper;
import com.kevin.util.Clog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author geyh
 * @create 2017-07-26 19:07
 */
@RestController
public class MyController {

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("/")
    public String hello() {
        String cityName = cityMapper.selectByPrimaryKey(347).getCityname();
        Clog.error("cityName:" + cityName);
        return cityName;
    }

}
