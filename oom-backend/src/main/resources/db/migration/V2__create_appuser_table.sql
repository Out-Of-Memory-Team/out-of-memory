CREATE TABLE IF NOT EXISTS oom.appuser
(
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    firstname character varying(50) COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(50) COLLATE pg_catalog."default",
    password character varying(50) COLLATE pg_catalog."default",
    accountNonExpired boolean,
    accountNonLocked boolean,
    credentialsNonExpired boolean,
    enabled boolean,
    role character varying(50) COLLATE pg_catalog."default" NOT NULL,
    userId uuid NOT NULL,
    CONSTRAINT "PK_User" PRIMARY KEY (userId)
)

    TABLESPACE pg_default;

ALTER TABLE oom.appuser
    OWNER to oom;