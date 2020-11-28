CREATE TABLE IF NOT EXISTS oom.decktags
(
    name text COLLATE pg_catalog."default" NOT NULL,
    deckId uuid NOT NULL,
    CONSTRAINT "PK_decktags" PRIMARY KEY (deckId, name),
    CONSTRAINT "FK_Deck" FOREIGN KEY (deckId)
        REFERENCES oom.deck (deckId) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "FK_Tag" FOREIGN KEY (name)
        REFERENCES oom.tag (name) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE oom.decktags
    OWNER to postgres;