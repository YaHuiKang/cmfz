/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   varchar(36) not null,
   title                varchar(128),
   href                 varchar(256),
   iconCls              varchar(128),
   parentId             varchar(36),
   primary key (id)
);