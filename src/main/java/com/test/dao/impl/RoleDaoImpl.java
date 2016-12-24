package com.test.dao.impl;

import com.test.dao.RoleDao;
import com.test.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {
    @Override
    public Role findById(Long id) {
        Role role = getCurrentSession().get(Role.class, id);
        return role;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        List<Role> roles = (List<Role>) getCurrentSession().createQuery("from Role").list();
        return roles;
    }
}
