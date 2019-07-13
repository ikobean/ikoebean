variable msg varchar2(300);
exec PROC_LOGIN('APPE', 'abc1234',:msg);
print msg;

