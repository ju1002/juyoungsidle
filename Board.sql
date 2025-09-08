CREATE SEQUENCE SEQ_NUM

START WITH 1

INCREMENT 
	   BY
	      1;



CREATE TABLE TB_CONTENTS(
  						CONTENTS_NUM NUMBER PRIMARY KEY --PK
					  , TITLE NVARCHAR2 (30) NOT NULL
					  , GANRE NVARCHAR2 (30) NOT NULL
					  , DIRECTOR NVARCHAR2 (20) NOT NULL
					  ,	LEVEL_NUM  NUMBER 
					  
);

SELECT
		* 
  FROM 
		TB_CONTENTS;

INSERT
  INTO
	   TB_CONTENTS
  VALUES (
  		  SEQ_NUM.NEXTVAL
  		, '케데헌'
  		, '판타지'
  		, '크리스 아펠한스'
  		, 1 
  );
INSERT
  INTO
	   TB_CONTENTS
  VALUES (
  		  SEQ_NUM.NEXTVAL
  		, '오징어게임3'
  		, '스릴러'
  		, '황동혁'
  		, 2  
        );
UPDATE 
       TB_CONTENTS
   SET
      TITLE ='오징어게임1'
  WHERE 
       CONTENTS_NUM = 2;
  	   UPDATE 
       TB_CONTENTS
   SET
      TITLE ='오징어게임2'
  WHERE 
       CONTENTS_NUM = 3;
UPDATE 
       TB_CONTENTS
   SET
      LEVEL_NUM = 3
  WHERE 
     CONTENTS_NUM = 2;
COMMIT;
SELECT
       *
  FROM 
       TB_CONTENTS;

