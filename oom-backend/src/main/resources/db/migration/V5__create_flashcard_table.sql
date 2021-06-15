CREATE TABLE IF NOT EXISTS oom.flashcard
(
    front text COLLATE pg_catalog."default" NOT NULL,
    back text COLLATE pg_catalog."default" NOT NULL,
    index integer NOT NULL,
    cardId uuid NOT NULL,
    deckId uuid NOT NULL,
    CONSTRAINT "PK_Card" PRIMARY KEY (cardId),
    CONSTRAINT "FK_Deck" FOREIGN KEY (deckId)
        REFERENCES oom.deck (deckId) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE oom.flashcard
    OWNER to oom;