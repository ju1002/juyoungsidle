CREATE TABLE TB_USERS (
	USER_NO NUMBER CONSTRAINT PK_USERNO PRIMARY KEY,
	USER_ID VARCHAR2(20) NOT NULL,
	USER_PWD VARCHAR2(20) NOT NULL,
	NICKNAME NVARCHAR2(30),
	SUBSCRIPTION VARCHAR2(20) DEFAULT 'None' CHECK(SUBSCRIPTION IN ('None', 'Basic', 'Standard', 'Premium'))
);
-- 회원번호 시퀀스로 넣기
CREATE SEQUENCE SEQ_NFUSERNO
 START WITH 1
 NOCACHE;
-- 관리자 세명 미리 등록해놓기
INSERT
  INTO
       TB_USERS
VALUES
       (
       SEQ_NFUSERNO.NEXTVAL
     , 'admin01'
     , 'pass01'
     , '관리자1'
     , 'None'
       );
INSERT
  INTO
       TB_USERS
VALUES
       (
       SEQ_NFUSERNO.NEXTVAL
     , 'admin02'
     , 'pass02'
     , '관리자2'
     , 'None'
       );
INSERT
  INTO
       TB_USERS
VALUES
       (
       SEQ_NFUSERNO.NEXTVAL
     , 'admin03'
     , 'pass03'
     , '관리자3'
     , 'None'
       );
-- 마지막 확인용
SELECT
       *
  FROM
       TB_USERS;
COMMIT;

--반응,댓글
SELECT * FROM TB_USERS;








