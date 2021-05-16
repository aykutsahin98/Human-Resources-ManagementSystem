-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.activation_code_for_employers
(
    id integer NOT NULL,
    employer_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.activation_code_for_job_seekers
(
    id integer NOT NULL,
    job_seeker_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.activation_codes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    activation_code character varying(40) NOT NULL,
    is_confimed boolean NOT NULL,
    confimed_time date,
    PRIMARY KEY (id)
);

CREATE TABLE public.employer_activation_by_system_personels
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    confirmed_system_personel_id integer NOT NULL,
    is_confimed boolean NOT NULL,
    confirmed_time date,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    id integer NOT NULL,
    company_name character varying(50) NOT NULL,
    web_address character varying(50) NOT NULL,
    phone_number character varying(12) NOT NULL,
    is_activated boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_seekers
(
    id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    identity_number character varying(11) NOT NULL,
    birth_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_titles
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_name character varying(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.system_personels
(
    id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.activation_code_for_employers
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.activation_code_for_employers
    ADD FOREIGN KEY (id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.activation_code_for_job_seekers
    ADD FOREIGN KEY (id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.activation_code_for_job_seekers
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seekers (id)
    NOT VALID;


ALTER TABLE public.employer_activation_by_system_personels
    ADD FOREIGN KEY (confirmed_system_personel_id)
    REFERENCES public.system_personels (id)
    NOT VALID;


ALTER TABLE public.employer_activation_by_system_personels
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.system_personels
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;

END;