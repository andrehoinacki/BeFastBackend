insert into todo(id, username,description,target_date,is_done)
values(10001, 'in28minutes', 'Learn JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10002, 'in28minutes', 'Learn Data JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10003, 'in28minutes', 'Learn Microservices', sysdate(), false);

/** INSERT ROLES */
INSERT INTO `befast`.`role` (`id`, `nome`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `befast`.`role` (`id`, `nome`) VALUES ('2', 'ROLE_RESPONSAVEL');
INSERT INTO `befast`.`role` (`id`, `nome`) VALUES ('3', 'ROLE_ALUNO');
INSERT INTO `befast`.`role` (`id`, `nome`) VALUES ('4', 'ROLE_FUNCIONARIO');

/** INSERT USUÁRIOS */
INSERT INTO befast.usuario VALUES (1, "Administrador", "admin", "admin", 1);
INSERT INTO befast.usuario VALUES (2, "Caixa", "caixa", "caixa", 4);

/** INSERT CATEGORIAS */
INSERT INTO `befast`.`categoria` (`id`, `nome`) VALUES ('1', 'Salgado');
INSERT INTO `befast`.`categoria` (`id`, `nome`) VALUES ('2', 'Doce');
INSERT INTO `befast`.`categoria` (`id`, `nome`) VALUES ('3', 'Bebida');

/** INSERT RESTRIÇÕES */
INSERT INTO `befast`.`restricao` (`id`, `nome`) VALUES ('1', 'LACTOSE');
INSERT INTO `befast`.`restricao` (`id`, `nome`) VALUES ('2', 'GLUTEN');
INSERT INTO `befast`.`restricao` (`id`, `nome`) VALUES ('3', 'CALORICA');