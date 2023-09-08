use time_attendance;

DELETE from time_record
WHERE date = DATE_SUB(CURDATE(), INTERVAL 2 DAY) OR date = DATE_SUB(CURDATE(), INTERVAL 1 DAY);

DELETE from settlement
WHERE date = DATE_SUB(CURDATE(), INTERVAL 2 DAY) OR date = DATE_SUB(CURDATE(), INTERVAL 1 DAY);

INSERT INTO time_record(USER_ID, DATE, START_WORK, LEAVE_WORK, WORK_STATE, DATE_CREATED, DATE_UPDATED)
VALUES ( 13, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , NULL, '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 46, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 65, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , NULL, '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 27, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 63, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 86, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 84, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 108, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 103, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 133, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 145, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 143, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 172, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 187, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY)),
       ( 183, DATE_SUB(CURDATE(), INTERVAL 2 DAY)
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('08:50:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , CONCAT(DATE_SUB(CURDATE(), INTERVAL 2 DAY), ' ', ADDTIME('17:30:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60)))
       , '미처리', DATE_SUB(CURDATE(), INTERVAL 2 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO settlement(USER_ID, DATE, START_TIME, END_TIME, WORKING_TIME, OVER_TIME, DAY_TYPE, DATE_CREATED, DATE_UPDATED, WORK_GROUP_RECORD_ID)
VALUES (13,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),1)
,(27,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),3)
,(46,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),5)
,(65,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),7)
,(63,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),8)
,(86,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),9)
,(84,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),9)
,(108,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),11)
,(103,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),12)
,(133,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),13)
,(145,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),15)
,(143,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),16)
,(172,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),17)
,(187,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),19)
,(183,DATE_SUB(CURDATE(), INTERVAL 2 DAY),NULL,NULL,'00:00','00:00',NULL,DATE_SUB(CURDATE(), INTERVAL 2 DAY),DATE_SUB(CURDATE(), INTERVAL 2 DAY),20);