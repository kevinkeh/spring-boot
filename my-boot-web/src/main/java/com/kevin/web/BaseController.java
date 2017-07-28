package com.kevin.web;

import com.kevin.persistence.Page;
import com.kevin.util.DateUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础控制器
 * 其他控制器继承此控制器获得日期字段类型转换和防止XSS攻击的功能
 * Created by zmxie on 2017/7/28.
 */
public class BaseController {
    //成功
    protected static final int RESULT_CODE_SUCCESS = 1;
    //失败
    protected static final int RESULT_CODE_FAILURE = 0;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });

        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });

        // Timestamp 类型转换
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Date date = DateUtils.parseDate(text);
                setValue(date==null?null:new Timestamp(date.getTime()));
            }
        });
    }

    /**
     * 用来获取当前登录用户
     * @return 当前登录用户
     */
   /* public User getCurUser() {
        return UserUtil.getCurrentUser();
    }*/

    protected Map<String,Object> getResult(Integer code, String message, Object obj) {
        Map<String,Object> result = new HashMap<>();
        result.put("code", code);
        result.put("message",message);
        result.put("data",obj);
        return result;
    }

    /**
     * 获取Bootstrap分页数据
     * @param page
     * @return map对象
     */
    public <T> Map<String, Object> getBootstrapData(Page<T> page){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", page.getResult());
        map.put("total", page.getTotalCount());

        Map<String, Object> rootMap = new HashMap<String, Object>();
        rootMap.put("message", "查询成功");
        rootMap.put("data", map);
        rootMap.put("code",1);
        return rootMap;
    }
}
