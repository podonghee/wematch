create table AC_USER
(
    USER_SEQ          int auto_increment comment '고객 고유  ID'
        primary key,
    USER_NAME         varchar(20) not null comment '고객 명',
    USER_TEL          varchar(20) null comment '고객 전화번호',
    INSERT_DATE       datetime    not null comment '고객 등록일자',
    USER_TOS_YN       char        not null comment '이용약관여부',
    USER_ESTIMATE_YN  char        not null comment '견적요청을 위한 제 3자제공동의여부',
    USER_MARKETING_YN char        not null comment '마케팅 여부',
    USE_YN            char        not null
);

create table MOVING_CENTER
(
    MC_SEQ         int auto_increment comment '이사업체 ID'
        primary key,
    MC_NAME        varchar(100) not null comment '이사업체명',
    MC_OWNER       varchar(30)  not null comment '이사업체 대표자',
    MC_TEL         varchar(20)  null comment '이사업체 전화번호',
    MC_ADDR        varchar(300) null comment '이사업체 주소',
    MC_REGI_NUMBER varchar(20)  null comment '이사업체 사업자등록번호',
    MC_REGI_DATE   datetime     null comment '이사업체 사업자등록일',
    MC_EMPL_CNT    varchar(20)  null comment '이사업체 직원 수',
    MC_MATCHING_YN char         not null comment '이사업체 매칭여부',
    INSERT_DATE    timestamp    not null comment '등록일자',
    USE_YN         char         not null comment '사용여부'
)
    comment '이사업체 정보테이블';

create table MOVING_CENTER_CAR
(
    MC_CAR_SEQ    int auto_increment comment '차량 고유 ID'
        primary key,
    MC_SEQ        int         not null comment '이사업체 차량 ID',
    MC_CAR_WEIGHT varchar(10) not null comment '이사업체 차량 무게',
    MC_CAR_CNT    varchar(20) not null comment '이사업체 차량 개수',
    constraint MOVING_CENTER_CAR_MOVING_CENTER_MC_SEQ_fk
        foreign key (MC_SEQ) references MOVING_CENTER (MC_SEQ)
);

create table MOVING_REQ_INFO
(
    MV_REQ_SEQ         int auto_increment comment '이사신청접수정보 ID'
        primary key,
    MV_REQ_START_ADDR  varchar(100) not null,
    MV_REQ_END_ADDR    varchar(100) not null comment '도착점 주소',
    MV_REQ_START_FLOOR varchar(10)  not null comment '출발지 층수',
    MV_REQ_END_FLOOR   varchar(10)  not null comment '도착지 층수 ',
    MV_INSERT_DATE     datetime     not null comment '이사일자',
    MV_STORAGE_YN      char         not null comment '보관이사여부',
    USER_SEQ           int          not null,
    constraint MOVING_REQ_INFO_AC_USER_USER_SEQ_fk
        foreign key (USER_SEQ) references AC_USER (USER_SEQ)
)
    comment '이사 신청접수 여부';

create table MOVING_CENTER_REQ_MAPPING
(
    MM_SEQ     int auto_increment comment '이사업체와 이사신청접수에 대한 매핑 UID'
        primary key,
    MC_SEQ     int  not null comment '이사업체 UID',
    MV_REQ_SEQ int  not null comment '이사신청 UID',
    STATUS     char not null comment '상태값 매핑이 되어서 진행초기 ~ 진행중 ~ 완료 프로세스 상태',
    constraint MOVING_CENTER_REQ_MAPPING_MV_REQ_SEQ_uindex
        unique (MV_REQ_SEQ),
    constraint MOVING_CENTER_REQ_MAPPING_MOVING_CENTER_MC_SEQ_fk
        foreign key (MC_SEQ) references MOVING_CENTER (MC_SEQ),
    constraint MOVING_CENTER_REQ_MAPPING_MOVING_REQ_INFO_MV_REQ_SEQ_fk
        foreign key (MV_REQ_SEQ) references MOVING_REQ_INFO (MV_REQ_SEQ)
);

create table AC_USER_FEEDBACK_HIST
(
    HIST_SEQ            int auto_increment comment '고객 피드백 PID'
        primary key,
    MM_SEQ              int           not null comment '업체 와 이사신청에 대한 매핑 고유ID',
    KINDES              char          not null comment '이사종류',
    DISC_YN             char          not null comment '정보공개 동의여부',
    PROFESSIONAL_RATING varchar(10)   not null comment '전문적 만족도',
    PRICE_RATING        varchar(10)   not null comment '가격 만족도',
    KINDNESS_RATING     varchar(10)   not null comment '친절만족도',
    REVISIT_YN          char          not null comment '재방문 의사',
    CONTRACT_PRICE      varchar(10)   not null comment '계약가격',
    MOVE_DATE           datetime      not null comment '이사일',
    FEEDBACK_DATE       datetime      not null comment '피드백 일자',
    FEEDBACK_DESC       varchar(4000) not null comment '피드백내용',
    constraint AC_USER_FEEDBACK_HIST_MOVING_CENTER_REQ_MAPPING_MM_SEQ_fk
        foreign key (MM_SEQ) references MOVING_CENTER_REQ_MAPPING (MM_SEQ)
);

