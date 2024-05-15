create table if not exists commit_info
(
    id        bigint auto_increment,
    committer varchar(255),
    new_column varchar(255),
    primary key (id)
);

create table if not exists commit_sha
(
    id               bigint auto_increment,
    commit_date      timestamp(6),
    commit_url        varchar(255),
    sha1             varchar(255),
    commit_author_id bigint,
    primary key (id)
);

create table if not exists repository_info
(
    id        bigint auto_increment,
    owner_name varchar(255),
    repo_name  varchar(255),
    primary key (id)
);

alter table commit_sha
    add constraint FKevhl13yji8uw8i2jsbmttl7mb
        foreign key (commit_author_id)
            references Commit_info(id)

