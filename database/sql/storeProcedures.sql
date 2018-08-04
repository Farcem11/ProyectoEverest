DROP PROCEDURE IF EXISTS getStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE getStatisticalDataManagers()
BEGIN
	SELECT 
		fileName,
	  	filePath, 
 		total, 
	  	max, 
	  	min,
        numbers
	FROM
		StatisticalDataManager;
END //
DELIMITER ;

call getStatisticalDataManagers();

DROP PROCEDURE IF EXISTS createStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE createStatisticalDataManagers
(
	IN pFileName VARCHAR(100),
	IN pFilePath VARCHAR(260),
	IN pTotal BIGINT,
	IN pMax BIGINT,
	IN pMin BIGINT,
    IN pNumbers LONGTEXT
)
BEGIN
	INSERT INTO StatisticalDataManager
	(
		fileName,
	  	filePath, 
 		total, 
	  	max, 
	  	min,
        numbers
	) 
	VALUES
	(
		pFileName,
		pFilePath,
		pTotal,
		pMax,
		pMin,
        pNumbers
	);
END //
DELIMITER ;

call createStatisticalDataManagers('MyFile.txt', 'files/', 15, 5, 1, '1,2,3,4,5');

DROP PROCEDURE IF EXISTS editStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE editStatisticalDataManagers
(
	IN pOldFileName VARCHAR(100),
	IN pNewFileName VARCHAR(100),
	IN pFilePath VARCHAR(260),
	IN pTotal BIGINT,
	IN pMax BIGINT,
	IN pMin BIGINT,
    IN pNumbers LONGTEXT
)
BEGIN
	UPDATE 
		StatisticalDataManager
	SET
		fileName = pNewFileName,
		filePath = pFilePath,
		total = pTotal,
		max = pMax,
		min = pMin,
        numbers = pNumbers
	WHERE 
		fileName = pOldFileName;
END //
DELIMITER ;

call editStatisticalDataManagers('MyFile.txt', 'NewFile.txt', 'files/', 40, 6, 10, '6,7,8,9,10');

select * from statisticaldatamanager;
