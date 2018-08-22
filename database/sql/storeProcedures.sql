DROP PROCEDURE IF EXISTS getStatisticalsData;
DELIMITER //
CREATE PROCEDURE getStatisticalsData()
BEGIN
	SELECT
		idStatisticalData,
	  	name, 
 		total, 
	  	max, 
	  	min,
        numbers
	FROM
		StatisticalData;
END //
DELIMITER ;

call getStatisticalsData();

DROP PROCEDURE IF EXISTS saveStatisticalData;
DELIMITER //
CREATE PROCEDURE saveStatisticalData
(
	IN pName VARCHAR(100),
	IN pTotal FLOAT,
	IN pMax FLOAT,
	IN pMin FLOAT,
    IN pNumbers LONGTEXT
)
BEGIN
	INSERT INTO StatisticalData
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

call saveStatisticalData('Numbers', 15, 5, 1, '1,2,3,4,5');

DROP PROCEDURE IF EXISTS updateStatisticalData;
DELIMITER //
CREATE PROCEDURE updateStatisticalData
(
	IN pIdStatisticalData BIGINT,
	IN pName VARCHAR(260),
	IN pTotal FLOAT,
	IN pMax FLOAT,
	IN pMin FLOAT,
    IN pNumbers LONGTEXT
)
BEGIN
	UPDATE 
		StatisticalData
	SET
		name = pName,
		total = pTotal,
		max = pMax,
		min = pMin,
        numbers = pNumbers
	WHERE 
		pIdStatisticalData = idStatisticalData;
END //
DELIMITER ;

call updateStatisticalData(1170, 'MyFile', 40, 6, 10, '6,7,8,9,10');

DROP PROCEDURE IF EXISTS deleteStatisticalData;
DELIMITER //
CREATE PROCEDURE deleteStatisticalData(IN pIdStatisticalDataManager BIGINT)
BEGIN
	DELETE FROM 
		StatisticalData
	WHERE 
		pIdStatisticalData = idStatisticalData;
END //
DELIMITER ;

call deleteStatisticalData(1171);

select * from statisticaldata;