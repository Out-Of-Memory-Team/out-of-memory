CREATE TABLE IF NOT EXISTS oom.collaborator
(
    deckId uuid NOT NULL,
    userId uuid NOT NULL,
    CONSTRAINT "PK_Collaborator" PRIMARY KEY (deckId, userId),
    CONSTRAINT "FK_Deck" FOREIGN KEY (deckId)
        REFERENCES oom.deck (deckId) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "FK_User" FOREIGN KEY (userId)
        REFERENCES oom.appuser (userId) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE oom.collaborator
    OWNER to oom;