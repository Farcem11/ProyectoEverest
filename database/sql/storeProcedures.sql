DROP PROCEDURE IF EXISTS getStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE getStatisticalDataManagers()
BEGIN
	SELECT
		idStatisticalDataManager,
	  	name, 
 		total, 
	  	max, 
	  	min,
        numbers
	FROM
		StatisticalDataManager;
END //
DELIMITER ;

call getStatisticalDataManagers();

DROP PROCEDURE IF EXISTS saveStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE saveStatisticalDataManagers
(
	IN pName VARCHAR(100),
	IN pTotal FLOAT,
	IN pMax FLOAT,
	IN pMin FLOAT,
    IN pNumbers LONGTEXT
)
BEGIN
	INSERT INTO StatisticalDataManager
	(
	  	name, 
 		total, 
	  	max, 
	  	min,
        numbers
	) 
	VALUES
	(
		pName,
		pTotal,
		pMax,
		pMin,
        pNumbers
	);
    
    SELECT last_insert_id() as id;
END //
DELIMITER ;

call saveStatisticalDataManagers('Numbers', 15, 5, 1, '1,2,3,4,5');

DROP PROCEDURE IF EXISTS updateStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE updateStatisticalDataManagers
(
	IN pIdStatisticalDataManager BIGINT,
	IN pName VARCHAR(260),
	IN pTotal FLOAT,
	IN pMax FLOAT,
	IN pMin FLOAT,
    IN pNumbers LONGTEXT
)
BEGIN
	UPDATE 
		StatisticalDataManager
	SET
		name = pName,
		total = pTotal,
		max = pMax,
		min = pMin,
        numbers = pNumbers
	WHERE 
		pIdStatisticalDataManager = idStatisticalDataManager;
END //
DELIMITER ;

call updateStatisticalDataManagers(31, 'files/data/MyFile.txt', 40, 6, 10, '6,7,8,9,10');

DROP PROCEDURE IF EXISTS deleteStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE deleteStatisticalDataManagers(IN pIdStatisticalDataManager BIGINT)
BEGIN
	DELETE FROM 
		StatisticalDataManager
	WHERE 
		pIdStatisticalDataManager = idStatisticalDataManager;
END //
DELIMITER ;

call deleteStatisticalDataManagers(4);

select * from statisticaldatamanager;