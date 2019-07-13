exec proc_mkaddrtb_del('testt');

select * from mkaddrtb where id = 'test'

select 1 from mkaddrtb where id='test'

select nvl((select 1 from mkaddrtb where id='apple'),0) from dual

variable msg varchar2(100)
exec proc_mkaddrtb_del('apple',:msg);
print msg;


