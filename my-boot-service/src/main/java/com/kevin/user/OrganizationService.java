package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.OrganizationMapper;
import com.kevin.model.db2.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class OrganizationService extends BaseService<Organization, Integer> {

    @Autowired
    private OrganizationMapper organizationMapper;

    public List<Organization> getAll(){
        return organizationMapper.selectAll();
    }

    @Override
    public BaseMapper<Organization, Integer> getMapper() {
        return organizationMapper;
    }
}
