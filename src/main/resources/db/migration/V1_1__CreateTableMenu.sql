CREATE TABLE menu (
    id bigserial NOT NULL,
    label_menu varchar(255) NOT NULL,
    version varchar(100) NOT NULL,
    is_active bool NULL,
    is_deleted bool NULL,
    CONSTRAINT menu_pkey PRIMARY KEY (id)
);