SELECT  DISTINCT ROWNUM,
               EMP_ID ID1, EMP_NAME NAME1, 

                EMP_ID ID2, EMP_NAME NAME2,
                EMP_ID ID3, EMP_NAME NAME3,
                EMP_ID ID4, EMP_NAME NAME4,
                EMP_ID ID5, EMP_NAME NAME5,
                EMP_NAME
FROM TEMP
WHERE ROWNUM <=4
