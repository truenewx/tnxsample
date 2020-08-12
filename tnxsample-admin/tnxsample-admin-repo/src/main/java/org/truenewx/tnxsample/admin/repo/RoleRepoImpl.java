package org.truenewx.tnxsample.admin.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.truenewx.tnxsample.admin.model.entity.Role;

@Repository
public class RoleRepoImpl implements RoleRepox {
    
    @Override
    public List<Role> findByNameContainingOrderByOrdinal(String name) {
        return null;
    }

}
