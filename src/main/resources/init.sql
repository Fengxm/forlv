CREATE TABLE BLOG_INFO(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  TITLE VARCHAR(100),
  ABSTRACTS VARCHAR(512),
  TAGS VARCHAR(100)
);

CREATE TABLE SHIYILVXING_INFO(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  TITLE VARCHAR(200),
  URL VARCHAR(200),
  ACTIVITY_TIME VARCHAR(100),
  APPLICATION_PERIOD VARCHAR(100),
  ADDRESS VARCHAR(100),
  JOIN_NUM_LIMIT VARCHAR(100)
);

CREATE TABLE ACTIVITY_INFO(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  URL VARCHAR(100),
  TITLE VARCHAR(200),
  COST VARCHAR(100),
  TRAVEL_TIME VARCHAR(100),
  JOIN_NUM VARCHAR(100),
  GATHER_ADDRESS VARCHAR(100),
  CREATE_DATE TIMESTAMP(6)
);