package jdbcExample.model.dao;

import jdbcExample.model.entity.Role;

public interface RoleDao extends DefaultDao<Role>{

    Role getByName(String name);
}
