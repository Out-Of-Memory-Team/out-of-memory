CREATE TABLE IF NOT EXISTS oom.tag
(
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Tag_pkey" PRIMARY KEY (name)
)

    TABLESPACE pg_default;

ALTER TABLE oom.tag
    OWNER to postgres;