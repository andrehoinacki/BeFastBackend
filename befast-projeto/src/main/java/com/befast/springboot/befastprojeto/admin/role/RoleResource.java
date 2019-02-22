
package com.befast.springboot.befastprojeto.admin.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/admin/role")
public class RoleResource {
	@Autowired
	RoleService roleService;

	@GetMapping(value = "", produces = "application/json")
    public List<Role> list() throws Exception {
        return roleService.list();
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public Role getByNome(@PathVariable String nome) throws Exception {
        return roleService.getByNome(nome);
    }
}