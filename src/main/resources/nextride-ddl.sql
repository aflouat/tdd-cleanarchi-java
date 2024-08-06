CREATE TABLE rides
(
    id          UUID PRIMARY KEY,
    rider_id    UUID           NOT NULL,
    departure   VARCHAR(255)   NOT NULL,
    arrival     VARCHAR(255)   NOT NULL,
    price       decimal(10, 2) NOT NULL,
    distance    float          NOT NULL,
    wants_uberx boolean        NOT NULL
);
