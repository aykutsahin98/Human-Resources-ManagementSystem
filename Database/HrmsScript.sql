-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.cities
(
    id integer NOT NULL,
    city_name character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.departments
(
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(50) NOT NULL,
    website character varying(100) NOT NULL,
    phone_number character varying(10) NOT NULL,
    verification_status boolean NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.job_advertisement
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    job_position_id integer NOT NULL,
    city_id integer NOT NULL,
    job_description character varying(500) NOT NULL,
    min_salary integer,
    max_salary integer,
    number_of_open_positions integer NOT NULL,
    application_deadline character varying(50) NOT NULL,
    is_active boolean NOT NULL,
    creation_date character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_seekers
(
    user_id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    identification_number character varying(11) NOT NULL,
    birth_year integer NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.resume_cover_letter
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    content character varying(300) NOT NULL,
    jobseeker_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_educations
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    jobseeker_id integer,
    school_name character varying(200) NOT NULL,
    department character varying(200) NOT NULL,
    start_date date,
    end_date date,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_experiences
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    jobseeker_id integer,
    workspace_name character varying(200),
    start_date date,
    end_date date,
    "position" character varying(150),
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_images
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    image_url character varying(200),
    jobseeker_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    jobseeker_id integer,
    language_name character varying(220) NOT NULL,
    language_level integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_links
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    jobseeker_id integer,
    github_link character varying(220),
    linkedin_link character varying(220),
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_skills
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    jobseeker_id integer,
    skills_name character varying(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.system_personnel
(
    user_id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    department_id integer,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(250) NOT NULL,
    password character varying(250) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.resume_cover_letter
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.resume_educations
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.resume_experiences
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.resume_images
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.resume_languages
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.resume_links
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.resume_skills
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.system_personnel
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;

END;