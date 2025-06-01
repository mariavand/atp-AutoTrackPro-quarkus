CREATE TABLE IF NOT EXISTS public.car (
    car_id              bigserial NOT NULL,
    owner_name_surname  text NOT NULL,
    serial_number       text NOT NULL,
    software_version    text NOT NULL,
    model               text NOT NULL,
    tech_comments       text NOT NULL,
    buying_day          date
    edited_by           text NOT NULL NOT NULL,
    last_update_date    date NOT NULL,
    locked_by           text NOT NULL,
    general_comments    text NOT NULL,
    sales_comments      text NOT NULL,
    battery_change_date date NOT NULL,
    payment_status      text NOT NULL,
    final_price         real,
    initial_price       real,
    status              text DEFAULT 'Not Active',,
    brand               text NOT NULL NOT NULL,
    air_conditioning    boolean NOT NULL,
    seats               integer NOT NULL,
    transmission        integer NOT NULL,
    gps                 boolean NOT NULL,
    bluetooth           boolean NOT NULL,
    fuel_type           text NOT NULL,
    year                integer,
    color               text NOT NULL,
    PRIMARY KEY (car_id)
);

CREATE TABLE IF NOT EXISTS public.history (
    history_id          bigserial NOT NULL,
    owner_name_surname  text NOT NULL,
    serial_number       text NOT NULL,
    software_version    text NOT NULL,
    tech_comments       text NOT NULL,
    buying_day          date
    edited_by           text NOT NULL,
    last_update_date    date
    general_comments    text NOT NULL,
    sales_comments      text NOT NULL,
    battery_change_date date
    payment_status      text NOT NULL,
    final_price         real,
    initial_price       real,
    status              text NOT NULL,
    air_conditioning    boolean NOT NULL,
    transmission        integer,
    gps                 boolean NOT NULL,
    bluetooth           boolean NOT NULL,
    fuel_type           text NOT NULL,
    color               text NOT NULL,
    car_car_id          integer NOT NULL,
    PRIMARY KEY (history_id)
);

ALTER TABLE IF EXISTS public.history
    ADD CONSTRAINT car_id FOREIGN KEY (car_id)
    REFERENCES public.car (car_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;



//Inser into car
INSERT INTO car (
    owner_name_surname,
    serial_number,
    software_version,
    model,
    tech_comments,
    buying_day,
    edited_by,
    last_update_date,
    locked_by,
    general_comments,
    sales_comments,
    battery_change_date,
    payment_status,
    final_price,
    initial_price,
    status,
    brand,
    air_conditioning,
    seats,
    transmission,
    gps,
    bluetooth,
    fuel_type,
    year,
    color
) VALUES (
    'Anthony Smith',
    'SN67895',
    'v1.0',
    '308',
    'Needs inspection',
    '2024-07-28',
    'Maria Vandoulaki',
    '2024-07-28 10:00:00',
    '',
    'No issues',
    'Contact customer',
    '2024-01-15',
    'Paid',
    25000.00,
    20000.00,
    'Available',
    'Pegeot',
    TRUE,
    5,
    0,
    TRUE,
    TRUE,
    'Gasoline',
    2023,
    'black'
);