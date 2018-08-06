DROP PROCEDURE IF EXISTS getStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE getStatisticalDataManagers()
BEGIN
	SELECT
		idStatisticalDataManager,
	  	filePath, 
 		total, 
	  	max, 
	  	min,
        fileContent
	FROM
		StatisticalDataManager;
END //
DELIMITER ;

call getStatisticalDataManagers();

DROP PROCEDURE IF EXISTS saveStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE saveStatisticalDataManagers
(
	IN pFilePath VARCHAR(260),
	IN pTotal BIGINT,
	IN pMax BIGINT,
	IN pMin BIGINT,
    IN pFileContent LONGTEXT
)
BEGIN
	INSERT INTO StatisticalDataManager
	(
	  	filePath, 
 		total, 
	  	max, 
	  	min,
        fileContent
	) 
	VALUES
	(
		pFilePath,
		pTotal,
		pMax,
		pMin,
        pFileContent
	);
    
    SELECT last_insert_id() as id;
END //
DELIMITER ;

call saveStatisticalDataManagers('files/data/MyFile3.txt', 15, 5, 1, '1,2,3,4,5');

DROP PROCEDURE IF EXISTS updateStatisticalDataManagers;
DELIMITER //
CREATE PROCEDURE updateStatisticalDataManagers
(
	IN pIdStatisticalDataManager BIGINT,
	IN pFilePath VARCHAR(260),
	IN pTotal BIGINT,
	IN pMax BIGINT,
	IN pMin BIGINT,
    IN pFileContent LONGTEXT
)
BEGIN
	UPDATE 
		StatisticalDataManager
	SET
		filePath = pFilePath,
		total = pTotal,
		max = pMax,
		min = pMin,
        fileContent = pFileContent
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

call deleteStatisticalDataManagers(1);

select * from statisticaldatamanager;