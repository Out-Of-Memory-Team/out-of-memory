CREATE TABLE IF NOT EXISTS oom.deck
(
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    deckId uuid NOT NULL,
    maintainer uuid,
    visibility integer NOT NULL,
    CONSTRAINT "PK_Deck" PRIMARY KEY (deckId),
    CONSTRAINT "FK_User" FOREIGN KEY (maintainer)
        REFERENCES oom.appuser (userId) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE oom.deck
    OWNER to oom;