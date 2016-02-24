--
-- PostgreSQL database dump
--

-- Started on 2010-08-24 17:32:08

SET client_encoding = 'WIN1252';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1521 (class 1259 OID 24906)
-- Dependencies: 6
-- Name: application_id_application_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE application_id_application_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.application_id_application_seq OWNER TO postgres;

--
-- TOC entry 1921 (class 0 OID 0)
-- Dependencies: 1521
-- Name: application_id_application_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('application_id_application_seq', 1, true);


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1522 (class 1259 OID 24908)
-- Dependencies: 1821 6
-- Name: application; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE application (
    id_application integer DEFAULT nextval('application_id_application_seq'::regclass) NOT NULL,
    name character varying(30) NOT NULL,
    description text
);


ALTER TABLE public.application OWNER TO postgres;

--
-- TOC entry 1523 (class 1259 OID 24915)
-- Dependencies: 6
-- Name: connector_id_connector_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE connector_id_connector_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.connector_id_connector_seq OWNER TO postgres;

--
-- TOC entry 1922 (class 0 OID 0)
-- Dependencies: 1523
-- Name: connector_id_connector_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('connector_id_connector_seq', 1, true);


--
-- TOC entry 1524 (class 1259 OID 24917)
-- Dependencies: 1822 6
-- Name: connector; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE connector (
    id_connector integer DEFAULT nextval('connector_id_connector_seq'::regclass) NOT NULL,
    id_connector_type integer NOT NULL
);


ALTER TABLE public.connector OWNER TO postgres;

--
-- TOC entry 1525 (class 1259 OID 24921)
-- Dependencies: 6
-- Name: connector_configuration_id_connector_configuration_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE connector_configuration_id_connector_configuration_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.connector_configuration_id_connector_configuration_seq OWNER TO postgres;

--
-- TOC entry 1923 (class 0 OID 0)
-- Dependencies: 1525
-- Name: connector_configuration_id_connector_configuration_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('connector_configuration_id_connector_configuration_seq', 1, true);


--
-- TOC entry 1526 (class 1259 OID 24923)
-- Dependencies: 1823 6
-- Name: connector_configuration; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE connector_configuration (
    id_connector_configuration integer DEFAULT nextval('connector_configuration_id_connector_configuration_seq'::regclass) NOT NULL,
    id_connector_property integer NOT NULL,
    id_connector integer NOT NULL,
    value character varying(500) NOT NULL
);


ALTER TABLE public.connector_configuration OWNER TO postgres;

--
-- TOC entry 1527 (class 1259 OID 24927)
-- Dependencies: 6
-- Name: connector_property_id_connector_property_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE connector_property_id_connector_property_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.connector_property_id_connector_property_seq OWNER TO postgres;

--
-- TOC entry 1924 (class 0 OID 0)
-- Dependencies: 1527
-- Name: connector_property_id_connector_property_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('connector_property_id_connector_property_seq', 8, true);


--
-- TOC entry 1528 (class 1259 OID 24929)
-- Dependencies: 1824 6
-- Name: connector_property; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE connector_property (
    id_connector_property integer DEFAULT nextval('connector_property_id_connector_property_seq'::regclass) NOT NULL,
    name character varying(250) NOT NULL,
    description text
);


ALTER TABLE public.connector_property OWNER TO postgres;

--
-- TOC entry 1529 (class 1259 OID 24936)
-- Dependencies: 6
-- Name: connector_type_id_connector_type_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE connector_type_id_connector_type_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.connector_type_id_connector_type_seq OWNER TO postgres;

--
-- TOC entry 1925 (class 0 OID 0)
-- Dependencies: 1529
-- Name: connector_type_id_connector_type_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('connector_type_id_connector_type_seq', 3, true);


--
-- TOC entry 1530 (class 1259 OID 24938)
-- Dependencies: 1825 6
-- Name: connector_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE connector_type (
    id_connector_type integer DEFAULT nextval('connector_type_id_connector_type_seq'::regclass) NOT NULL,
    clazz character varying(250) NOT NULL,
    name character varying(250) NOT NULL,
    description text
);


ALTER TABLE public.connector_type OWNER TO postgres;

--
-- TOC entry 1531 (class 1259 OID 24945)
-- Dependencies: 6
-- Name: connector_type_connector_property; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE connector_type_connector_property (
    id_connector_type integer NOT NULL,
    id_connector_property integer NOT NULL
);


ALTER TABLE public.connector_type_connector_property OWNER TO postgres;

--
-- TOC entry 1532 (class 1259 OID 24948)
-- Dependencies: 6
-- Name: control_id_control_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE control_id_control_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.control_id_control_seq OWNER TO postgres;

--
-- TOC entry 1926 (class 0 OID 0)
-- Dependencies: 1532
-- Name: control_id_control_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('control_id_control_seq', 1, true);


--
-- TOC entry 1533 (class 1259 OID 24950)
-- Dependencies: 1826 6
-- Name: control; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE control (
    id_control integer DEFAULT nextval('control_id_control_seq'::regclass) NOT NULL,
    id_parent_control integer,
    id_control_type integer NOT NULL,
    id_screen integer NOT NULL,
    control_name character varying(30) NOT NULL,
	uuid bigint,
    index integer NOT NULL
);


ALTER TABLE public.control OWNER TO postgres;

--
-- TOC entry 1534 (class 1259 OID 24954)
-- Dependencies: 6
-- Name: control_definition_id_control_definition_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE control_definition_id_control_definition_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.control_definition_id_control_definition_seq OWNER TO postgres;

--
-- TOC entry 1927 (class 0 OID 0)
-- Dependencies: 1534
-- Name: control_definition_id_control_definition_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('control_definition_id_control_definition_seq', 1, true);


--
-- TOC entry 1535 (class 1259 OID 24956)
-- Dependencies: 1827 6
-- Name: control_definition; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE control_definition (
    id_control_definition integer DEFAULT nextval('control_definition_id_control_definition_seq'::regclass) NOT NULL,
    id_control integer NOT NULL,
    id_property integer NOT NULL,
    value character varying(50) NOT NULL
);


ALTER TABLE public.control_definition OWNER TO postgres;

--
-- TOC entry 1536 (class 1259 OID 24960)
-- Dependencies: 6
-- Name: control_property_id_property_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE control_property_id_property_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.control_property_id_property_seq OWNER TO postgres;

--
-- TOC entry 1928 (class 0 OID 0)
-- Dependencies: 1536
-- Name: control_property_id_property_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('control_property_id_property_seq', 39, true);


--
-- TOC entry 1537 (class 1259 OID 24962)
-- Dependencies: 1828 6
-- Name: control_property; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE control_property (
    id_property integer DEFAULT nextval('control_property_id_property_seq'::regclass) NOT NULL,
    id_property_type integer NOT NULL,
    id_control_type integer NOT NULL,
    name character varying(30) NOT NULL,
    description text
);


ALTER TABLE public.control_property OWNER TO postgres;

--
-- TOC entry 1538 (class 1259 OID 24969)
-- Dependencies: 6
-- Name: control_type_id_control_type_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE control_type_id_control_type_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.control_type_id_control_type_seq OWNER TO postgres;

--
-- TOC entry 1929 (class 0 OID 0)
-- Dependencies: 1538
-- Name: control_type_id_control_type_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('control_type_id_control_type_seq', 8, true);


--
-- TOC entry 1539 (class 1259 OID 24971)
-- Dependencies: 1829 6
-- Name: control_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE control_type (
    id_control_type integer DEFAULT nextval('control_type_id_control_type_seq'::regclass) NOT NULL,
    type character varying(30) NOT NULL
);


ALTER TABLE public.control_type OWNER TO postgres;

--
-- TOC entry 1540 (class 1259 OID 24975)
-- Dependencies: 6
-- Name: datasource_id_datasource_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE datasource_id_datasource_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.datasource_id_datasource_seq OWNER TO postgres;

--
-- TOC entry 1930 (class 0 OID 0)
-- Dependencies: 1540
-- Name: datasource_id_datasource_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('datasource_id_datasource_seq', 1, true);


--
-- TOC entry 1541 (class 1259 OID 24977)
-- Dependencies: 1830 6
-- Name: datasource; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE datasource (
    id_datasource integer DEFAULT nextval('datasource_id_datasource_seq'::regclass) NOT NULL,
    id_connector integer,
    id_screen integer NOT NULL,
    name character varying(20) NOT NULL
);


ALTER TABLE public.datasource OWNER TO postgres;

--
-- TOC entry 1542 (class 1259 OID 24981)
-- Dependencies: 6
-- Name: permission_id_permission_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE permission_id_permission_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.permission_id_permission_seq OWNER TO postgres;

--
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 1542
-- Name: permission_id_permission_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('permission_id_permission_seq', 3, true);


--
-- TOC entry 1543 (class 1259 OID 24983)
-- Dependencies: 1831 6
-- Name: permission; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permission (
    id_permission integer DEFAULT nextval('permission_id_permission_seq'::regclass) NOT NULL,
    permission character varying(30) NOT NULL,
    description text
);


ALTER TABLE public.permission OWNER TO postgres;

--
-- TOC entry 1544 (class 1259 OID 24990)
-- Dependencies: 6
-- Name: permissionset_id_permissionset_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE permissionset_id_permissionset_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.permissionset_id_permissionset_seq OWNER TO postgres;

--
-- TOC entry 1932 (class 0 OID 0)
-- Dependencies: 1544
-- Name: permissionset_id_permissionset_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('permissionset_id_permissionset_seq', 1, true);


--
-- TOC entry 1545 (class 1259 OID 24992)
-- Dependencies: 1832 6
-- Name: permissionset; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permissionset (
    id_permissionset integer DEFAULT nextval('permissionset_id_permissionset_seq'::regclass) NOT NULL,
    name character varying(30) NOT NULL,
    description text
);


ALTER TABLE public.permissionset OWNER TO postgres;

--
-- TOC entry 1546 (class 1259 OID 24999)
-- Dependencies: 6
-- Name: permissionsetpermission; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permissionsetpermission (
    id_permissionset integer NOT NULL,
    id_permission integer NOT NULL
);


ALTER TABLE public.permissionsetpermission OWNER TO postgres;

--
-- TOC entry 1547 (class 1259 OID 25002)
-- Dependencies: 6
-- Name: property_type_id_property_type_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE property_type_id_property_type_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.property_type_id_property_type_seq OWNER TO postgres;

--
-- TOC entry 1933 (class 0 OID 0)
-- Dependencies: 1547
-- Name: property_type_id_property_type_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('property_type_id_property_type_seq', 21, true);


--
-- TOC entry 1548 (class 1259 OID 25004)
-- Dependencies: 1833 6
-- Name: property_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE property_type (
    id_property_type integer DEFAULT nextval('property_type_id_property_type_seq'::regclass) NOT NULL,
    type character varying(30) NOT NULL
);


ALTER TABLE public.property_type OWNER TO postgres;

--
-- TOC entry 1549 (class 1259 OID 25008)
-- Dependencies: 6
-- Name: screen_id_screen_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE screen_id_screen_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.screen_id_screen_seq OWNER TO postgres;

--
-- TOC entry 1934 (class 0 OID 0)
-- Dependencies: 1549
-- Name: screen_id_screen_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('screen_id_screen_seq', 1, true);


--
-- TOC entry 1550 (class 1259 OID 25010)
-- Dependencies: 1834 6
-- Name: screen; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE screen (
    id_screen integer DEFAULT nextval('screen_id_screen_seq'::regclass) NOT NULL,
    id_application integer NOT NULL,
    isdefault boolean NOT NULL,
    name character varying(30) NOT NULL,
    description text
);


ALTER TABLE public.screen OWNER TO postgres;

--
-- TOC entry 1551 (class 1259 OID 25017)
-- Dependencies: 6
-- Name: user_profile_id_user_profile_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_profile_id_user_profile_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.user_profile_id_user_profile_seq OWNER TO postgres;

--
-- TOC entry 1935 (class 0 OID 0)
-- Dependencies: 1551
-- Name: user_profile_id_user_profile_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_profile_id_user_profile_seq', 1, true);


--
-- TOC entry 1552 (class 1259 OID 25019)
-- Dependencies: 1835 6
-- Name: user_profile; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_profile (
    id_user_profile integer DEFAULT nextval('user_profile_id_user_profile_seq'::regclass) NOT NULL,
    id_user integer NOT NULL,
    id_permissionset integer,
    id_application integer
);


ALTER TABLE public.user_profile OWNER TO postgres;

--
-- TOC entry 1553 (class 1259 OID 25023)
-- Dependencies: 6
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_user_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.users_id_user_seq OWNER TO postgres;

--
-- TOC entry 1936 (class 0 OID 0)
-- Dependencies: 1553
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_user_seq', 2, true);


--
-- TOC entry 1554 (class 1259 OID 25025)
-- Dependencies: 1836 6
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id_user integer DEFAULT nextval('users_id_user_seq'::regclass) NOT NULL,
    username character varying(20) NOT NULL,
    password character varying(30) NOT NULL,
    fullname character varying(30) NOT NULL,
    description text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 1899 (class 0 OID 24908)
-- Dependencies: 1522
-- Data for Name: application; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1900 (class 0 OID 24917)
-- Dependencies: 1524
-- Data for Name: connector; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1901 (class 0 OID 24923)
-- Dependencies: 1526
-- Data for Name: connector_configuration; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1902 (class 0 OID 24929)
-- Dependencies: 1528
-- Data for Name: connector_property; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO connector_property (id_connector_property, name, description) VALUES (1, 'server', 'description');
INSERT INTO connector_property (id_connector_property, name, description) VALUES (2, 'sid', 'description');
INSERT INTO connector_property (id_connector_property, name, description) VALUES (3, 'user', 'description');
INSERT INTO connector_property (id_connector_property, name, description) VALUES (4, 'pass', 'description');
INSERT INTO connector_property (id_connector_property, name, description) VALUES (5, 'port', 'description');
INSERT INTO connector_property (id_connector_property, name, description) VALUES (6, 'db', 'description');
INSERT INTO connector_property (id_connector_property, name, description) VALUES (7, 'sql', 'description');


--
-- TOC entry 1903 (class 0 OID 24938)
-- Dependencies: 1530
-- Data for Name: connector_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO connector_type (id_connector_type, clazz, name, description) VALUES (1, 'com.gazoomobile.mfw.connector.db.oracle.OracleConnector', 'Oracle Connector', 'Oracle connector for platform');
INSERT INTO connector_type (id_connector_type, clazz, name, description) VALUES (2, 'com.gazoomobile.mfw.connector.db.postgres.PostgresConnector', 'Postgres Connector', 'Postgres connector for platform');


--
-- TOC entry 1904 (class 0 OID 24945)
-- Dependencies: 1531
-- Data for Name: connector_type_connector_property; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 1);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 2);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 3);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 4);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 5);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 7);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (1, 6);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (2, 1);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (2, 3);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (2, 4);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (2, 5);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (2, 7);
INSERT INTO connector_type_connector_property (id_connector_type, id_connector_property) VALUES (2, 6);


--
-- TOC entry 1905 (class 0 OID 24950)
-- Dependencies: 1533
-- Data for Name: control; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1906 (class 0 OID 24956)
-- Dependencies: 1535
-- Data for Name: control_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1907 (class 0 OID 24962)
-- Dependencies: 1537
-- Data for Name: control_property; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (1, 20, 1, 'id', 'textbox.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (2, 20, 2, 'id', 'listbox.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (3, 20, 3, 'id', 'linkbutton.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (4, 20, 3, 'ref', 'linkbutton.ref');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (5, 20, 4, 'id', 'label.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (6, 20, 5, 'id', 'horizontallayout.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (10, 20, 7, 'id', 'edit.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (11, 20, 8, 'id', 'combobox.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (12, 20, 8, 'selected', 'combobox.selected');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (13, 20, 9, 'id', 'checkbox.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (14, 20, 9, 'selected', 'checkbox.selected');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (15, 20, 10, 'id', 'button.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (16, 20, 11, 'id', 'table.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (17, 20, 12, 'id', 'verticallayout.id');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (19, 20, 13, 'value', 'option.value');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (20, 20, 13, 'selected', 'option.selected');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (21, 20, 14, 'background', 'row.background');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (22, 17, 15, 'colspan', 'column.colspan');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (23, 20, 1, 'stringvalue', 'textbox.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (25, 20, 2, 'stringvalue', 'listbox.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (26, 20, 3, 'stringvalue', 'linkbutton.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (27, 20, 4, 'stringvalue', 'label.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (28, 20, 5, 'stringvalue', 'horizontallayout.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (30, 20, 7, 'stringvalue', 'edit.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (31, 20, 8, 'stringvalue', 'combobox.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (32, 20, 9, 'stringvalue', 'checkbox.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (33, 20, 10, 'stringvalue', 'button.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (34, 20, 11, 'stringvalue', 'table.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (35, 20, 12, 'stringvalue', 'verticallayout.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (36, 20, 13, 'stringvalue', 'option.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (37, 20, 14, 'stringvalue', 'row.stringvalue');
INSERT INTO control_property (id_property, id_property_type, id_control_type, name, description) VALUES (38, 20, 15, 'stringvalue', 'column.stringvalue');


--
-- TOC entry 1908 (class 0 OID 24971)
-- Dependencies: 1539
-- Data for Name: control_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO control_type (id_control_type, type) VALUES (1, 'textbox');
INSERT INTO control_type (id_control_type, type) VALUES (2, 'listbox');
INSERT INTO control_type (id_control_type, type) VALUES (3, 'linkbutton');
INSERT INTO control_type (id_control_type, type) VALUES (4, 'label');
INSERT INTO control_type (id_control_type, type) VALUES (5, 'horizontallayout');
INSERT INTO control_type (id_control_type, type) VALUES (7, 'edit');
INSERT INTO control_type (id_control_type, type) VALUES (8, 'combobox');
INSERT INTO control_type (id_control_type, type) VALUES (9, 'checkbox');
INSERT INTO control_type (id_control_type, type) VALUES (10, 'button');
INSERT INTO control_type (id_control_type, type) VALUES (11, 'table');
INSERT INTO control_type (id_control_type, type) VALUES (12, 'verticallayout');
INSERT INTO control_type (id_control_type, type) VALUES (13, 'option');
INSERT INTO control_type (id_control_type, type) VALUES (14, 'row');
INSERT INTO control_type (id_control_type, type) VALUES (15, 'column');


--
-- TOC entry 1909 (class 0 OID 24977)
-- Dependencies: 1541
-- Data for Name: datasource; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1910 (class 0 OID 24983)
-- Dependencies: 1543
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permission (id_permission, permission, description) VALUES (1, 'READ', 'read permission');
INSERT INTO permission (id_permission, permission, description) VALUES (2, 'WRITE', 'write permission');
INSERT INTO permission (id_permission, permission, description) VALUES (3, 'EXEC', 'execute permission');


--
-- TOC entry 1911 (class 0 OID 24992)
-- Dependencies: 1545
-- Data for Name: permissionset; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permissionset (id_permissionset, name, description) VALUES (1, 'Admin', 'Administrador');


--
-- TOC entry 1912 (class 0 OID 24999)
-- Dependencies: 1546
-- Data for Name: permissionsetpermission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permissionsetpermission (id_permissionset, id_permission) VALUES (1, 2);
INSERT INTO permissionsetpermission (id_permissionset, id_permission) VALUES (1, 1);
INSERT INTO permissionsetpermission (id_permissionset, id_permission) VALUES (1, 3);


--
-- TOC entry 1913 (class 0 OID 25004)
-- Dependencies: 1548
-- Data for Name: property_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO property_type (id_property_type, type) VALUES (16, 'INT');
INSERT INTO property_type (id_property_type, type) VALUES (17, 'INTEGER');
INSERT INTO property_type (id_property_type, type) VALUES (18, 'BOOL');
INSERT INTO property_type (id_property_type, type) VALUES (19, 'BOOLEAN');
INSERT INTO property_type (id_property_type, type) VALUES (20, 'STRING');
INSERT INTO property_type (id_property_type, type) VALUES (21, 'LONG');


--
-- TOC entry 1914 (class 0 OID 25010)
-- Dependencies: 1550
-- Data for Name: screen; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1915 (class 0 OID 25019)
-- Dependencies: 1552
-- Data for Name: user_profile; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1916 (class 0 OID 25025)
-- Dependencies: 1554
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id_user, username, password, fullname, description) VALUES (2, 'admin', 'admin', 'admin', 'admin');


--
-- TOC entry 1838 (class 2606 OID 25033)
-- Dependencies: 1522 1522
-- Name: PK1; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY application
    ADD CONSTRAINT "PK1" PRIMARY KEY (id_application);


--
-- TOC entry 1866 (class 2606 OID 25035)
-- Dependencies: 1545 1545
-- Name: PK13; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permissionset
    ADD CONSTRAINT "PK13" PRIMARY KEY (id_permissionset);


--
-- TOC entry 1868 (class 2606 OID 25037)
-- Dependencies: 1546 1546 1546
-- Name: PK14; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permissionsetpermission
    ADD CONSTRAINT "PK14" PRIMARY KEY (id_permissionset, id_permission);


--
-- TOC entry 1872 (class 2606 OID 25039)
-- Dependencies: 1550 1550
-- Name: PK2; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY screen
    ADD CONSTRAINT "PK2" PRIMARY KEY (id_screen);


--
-- TOC entry 1852 (class 2606 OID 25041)
-- Dependencies: 1533 1533
-- Name: PK21; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control
    ADD CONSTRAINT "PK21" PRIMARY KEY (id_control);


--
-- TOC entry 1874 (class 2606 OID 25043)
-- Dependencies: 1552 1552
-- Name: PK27; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT "PK27" PRIMARY KEY (id_user_profile);


--
-- TOC entry 1860 (class 2606 OID 25045)
-- Dependencies: 1539 1539
-- Name: PK28; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control_type
    ADD CONSTRAINT "PK28" PRIMARY KEY (id_control_type);


--
-- TOC entry 1858 (class 2606 OID 25047)
-- Dependencies: 1537 1537
-- Name: PK3; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control_property
    ADD CONSTRAINT "PK3" PRIMARY KEY (id_property);


--
-- TOC entry 1842 (class 2606 OID 25049)
-- Dependencies: 1526 1526
-- Name: PK34; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY connector_configuration
    ADD CONSTRAINT "PK34" PRIMARY KEY (id_connector_configuration);


--
-- TOC entry 1848 (class 2606 OID 25051)
-- Dependencies: 1530 1530
-- Name: PK37; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY connector_type
    ADD CONSTRAINT "PK37" PRIMARY KEY (id_connector_type);


--
-- TOC entry 1850 (class 2606 OID 25053)
-- Dependencies: 1531 1531 1531
-- Name: PK38; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY connector_type_connector_property
    ADD CONSTRAINT "PK38" PRIMARY KEY (id_connector_type, id_connector_property);


--
-- TOC entry 1854 (class 2606 OID 25055)
-- Dependencies: 1535 1535
-- Name: PK4; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control_definition
    ADD CONSTRAINT "PK4" PRIMARY KEY (id_control_definition);


--
-- TOC entry 1864 (class 2606 OID 25057)
-- Dependencies: 1543 1543
-- Name: PK6; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permission
    ADD CONSTRAINT "PK6" PRIMARY KEY (id_permission);


--
-- TOC entry 1878 (class 2606 OID 25059)
-- Dependencies: 1554 1554
-- Name: PK7; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT "PK7" PRIMARY KEY (id_user);


--
-- TOC entry 1870 (class 2606 OID 25061)
-- Dependencies: 1548 1548
-- Name: PK8; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY property_type
    ADD CONSTRAINT "PK8" PRIMARY KEY (id_property_type);


--
-- TOC entry 1844 (class 2606 OID 25063)
-- Dependencies: 1526 1526 1526
-- Name: connector_configuration_keys; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY connector_configuration
    ADD CONSTRAINT connector_configuration_keys UNIQUE (id_connector_property, id_connector);


--
-- TOC entry 1856 (class 2606 OID 25065)
-- Dependencies: 1535 1535 1535
-- Name: control_definition-keys; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY control_definition
    ADD CONSTRAINT "control_definition-keys" UNIQUE (id_control, id_property);


--
-- TOC entry 1840 (class 2606 OID 25067)
-- Dependencies: 1524 1524
-- Name: pk18; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY connector
    ADD CONSTRAINT pk18 PRIMARY KEY (id_connector);


--
-- TOC entry 1846 (class 2606 OID 25069)
-- Dependencies: 1528 1528
-- Name: pk29; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY connector_property
    ADD CONSTRAINT pk29 PRIMARY KEY (id_connector_property);


--
-- TOC entry 1862 (class 2606 OID 25071)
-- Dependencies: 1541 1541
-- Name: pk5; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY datasource
    ADD CONSTRAINT pk5 PRIMARY KEY (id_datasource);


--
-- TOC entry 1876 (class 2606 OID 25073)
-- Dependencies: 1552 1552 1552 1552
-- Name: user_profile_keys; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT user_profile_keys UNIQUE (id_user, id_permissionset, id_application);


--
-- TOC entry 1895 (class 2606 OID 25074)
-- Dependencies: 1837 1550 1522
-- Name: Refapplication1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY screen
    ADD CONSTRAINT "Refapplication1" FOREIGN KEY (id_application) REFERENCES application(id_application);


--
-- TOC entry 1896 (class 2606 OID 25079)
-- Dependencies: 1837 1552 1522
-- Name: Refapplication53; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT "Refapplication53" FOREIGN KEY (id_application) REFERENCES application(id_application);


--
-- TOC entry 1891 (class 2606 OID 25084)
-- Dependencies: 1839 1524 1541
-- Name: Refconnector43; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datasource
    ADD CONSTRAINT "Refconnector43" FOREIGN KEY (id_connector) REFERENCES connector(id_connector);


--
-- TOC entry 1880 (class 2606 OID 25089)
-- Dependencies: 1839 1524 1526
-- Name: Refconnector64; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connector_configuration
    ADD CONSTRAINT "Refconnector64" FOREIGN KEY (id_connector) REFERENCES connector(id_connector);


--
-- TOC entry 1881 (class 2606 OID 25094)
-- Dependencies: 1528 1845 1526
-- Name: Refconnector_property62; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connector_configuration
    ADD CONSTRAINT "Refconnector_property62" FOREIGN KEY (id_connector_property) REFERENCES connector_property(id_connector_property);


--
-- TOC entry 1882 (class 2606 OID 25099)
-- Dependencies: 1845 1531 1528
-- Name: Refconnector_property72; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connector_type_connector_property
    ADD CONSTRAINT "Refconnector_property72" FOREIGN KEY (id_connector_property) REFERENCES connector_property(id_connector_property);


--
-- TOC entry 1879 (class 2606 OID 25104)
-- Dependencies: 1847 1524 1530
-- Name: Refconnector_type70; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connector
    ADD CONSTRAINT "Refconnector_type70" FOREIGN KEY (id_connector_type) REFERENCES connector_type(id_connector_type);


--
-- TOC entry 1883 (class 2606 OID 25109)
-- Dependencies: 1847 1530 1531
-- Name: Refconnector_type71; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connector_type_connector_property
    ADD CONSTRAINT "Refconnector_type71" FOREIGN KEY (id_connector_type) REFERENCES connector_type(id_connector_type);


--
-- TOC entry 1887 (class 2606 OID 25114)
-- Dependencies: 1851 1533 1535
-- Name: Refcontrol34; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control_definition
    ADD CONSTRAINT "Refcontrol34" FOREIGN KEY (id_control) REFERENCES control(id_control);


--
-- TOC entry 1884 (class 2606 OID 25119)
-- Dependencies: 1533 1851 1533
-- Name: Refcontrol59; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control
    ADD CONSTRAINT "Refcontrol59" FOREIGN KEY (id_parent_control) REFERENCES control(id_control);


--
-- TOC entry 1888 (class 2606 OID 25124)
-- Dependencies: 1857 1535 1537
-- Name: Refcontrol_property35; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control_definition
    ADD CONSTRAINT "Refcontrol_property35" FOREIGN KEY (id_property) REFERENCES control_property(id_property);


--
-- TOC entry 1889 (class 2606 OID 25129)
-- Dependencies: 1859 1537 1539
-- Name: Refcontrol_type57; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control_property
    ADD CONSTRAINT "Refcontrol_type57" FOREIGN KEY (id_control_type) REFERENCES control_type(id_control_type);


--
-- TOC entry 1885 (class 2606 OID 25134)
-- Dependencies: 1533 1859 1539
-- Name: Refcontrol_type74; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control
    ADD CONSTRAINT "Refcontrol_type74" FOREIGN KEY (id_control_type) REFERENCES control_type(id_control_type);


--
-- TOC entry 1893 (class 2606 OID 25139)
-- Dependencies: 1863 1546 1543
-- Name: Refpermission18; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permissionsetpermission
    ADD CONSTRAINT "Refpermission18" FOREIGN KEY (id_permission) REFERENCES permission(id_permission);


--
-- TOC entry 1894 (class 2606 OID 25144)
-- Dependencies: 1865 1545 1546
-- Name: Refpermissionset17; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permissionsetpermission
    ADD CONSTRAINT "Refpermissionset17" FOREIGN KEY (id_permissionset) REFERENCES permissionset(id_permissionset);


--
-- TOC entry 1897 (class 2606 OID 25149)
-- Dependencies: 1552 1545 1865
-- Name: Refpermissionset47; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT "Refpermissionset47" FOREIGN KEY (id_permissionset) REFERENCES permissionset(id_permissionset);


--
-- TOC entry 1890 (class 2606 OID 25154)
-- Dependencies: 1537 1869 1548
-- Name: Refproperty_type6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control_property
    ADD CONSTRAINT "Refproperty_type6" FOREIGN KEY (id_property_type) REFERENCES property_type(id_property_type);


--
-- TOC entry 1892 (class 2606 OID 25159)
-- Dependencies: 1871 1550 1541
-- Name: Refscreen52; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datasource
    ADD CONSTRAINT "Refscreen52" FOREIGN KEY (id_screen) REFERENCES screen(id_screen);


--
-- TOC entry 1886 (class 2606 OID 25164)
-- Dependencies: 1871 1550 1533
-- Name: Refscreen54; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY control
    ADD CONSTRAINT "Refscreen54" FOREIGN KEY (id_screen) REFERENCES screen(id_screen);


--
-- TOC entry 1898 (class 2606 OID 25169)
-- Dependencies: 1552 1554 1877
-- Name: Refusers45; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT "Refusers45" FOREIGN KEY (id_user) REFERENCES users(id_user);


--
-- TOC entry 1920 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-08-24 17:32:09

--
-- PostgreSQL database dump complete
--

