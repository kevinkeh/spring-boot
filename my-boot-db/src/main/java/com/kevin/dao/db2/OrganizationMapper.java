package com.kevin.dao.db2;

import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationMapper extends BaseMapper<Organization,Integer> {
    List<Organization> selectAll();
}