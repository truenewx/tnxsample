insert into T_MANAGER (id, username, password, job_no, full_name, top, disabled) values
(1, 'admin', '9ac8fa38a7d92a4e4415b22ad3110994d47a82f4e25e70f36783632cf04425f6','T001', '顶级管理员', 1, 0),
(2, 'normal1', '127080005b0929f96e83a4d9dea1163542aa5e0723974f6b7b0ebae3c5b70b58','G001', '普通管理员1', 0, 0),
(3, 'general1', '523c803b5bc9e9f66e8e43dbee41f62095aa556513974f8c2f0ecae3c5bb0b54','G002', '一般管理员1', 0, 1),
(4, 'cs1', '628880395b6969ffde88f9d18ea146aa29aa5be293974fd2c30e8ae3c5b60bfb','G003', '客服MM1', 0, 0);

insert into T_ROLE (id, role_name, ordinal, permission_string) values
(1, '用户管理者', 1, '["USER_LIST","USER_DISABLE","USER_DETAIL"]'),
(2, '客服', 2, '');

insert into T_MANAGER_R_ROLE (manager_id, role_id) values
(2, 1),
(4, 2);
