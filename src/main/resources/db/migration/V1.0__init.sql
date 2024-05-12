create table if not exists CommitInfo
(
    id        bigint auto_increment,
    committer varchar(255),
    new_column varchar(255),
    primary key (id)
);

create table if not exists CommitSha
(
    id               bigint auto_increment,
    commit_date      timestamp(6),
    commit_url        varchar(255),
    sha1             varchar(255),
    commit_author_id bigint,
    primary key (id)
);

create table if not exists RepositoryInfo
(
    id        bigint auto_increment,
    owner_name varchar(255),
    repo_name  varchar(255),
    primary key (id)
);

alter table CommitSha
    add constraint FKevhl13yji8uw8i2jsbmttl7mb
        foreign key (commit_author_id)
            references CommitInfo(id)

