--
-- Estrutura da tabela "cidade"
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP TABLE IF EXISTS "cidade" CASCADE;

--
-- Estrutura da tabela "cidade"
--

CREATE TABLE public.cidade (
    id bigint NOT NULL,
    nome character varying(120),
    uf integer,
    ibge integer,
    lat_lon point,
    latitude double precision,
    longitude double precision,
    cod_tom smallint DEFAULT 0
);


COMMENT ON COLUMN public.cidade.cod_tom
  IS 'Código TOM (SEFAZ)';
  

ALTER TABLE public.cidade OWNER TO postgres;

--
-- Name: cidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE IF NOT EXISTS  public.cidade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cidade_id_seq OWNER TO postgres;

--
-- Name: cidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cidade_id_seq OWNED BY public.cidade.id;


--
-- Name: cidade id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade ALTER COLUMN id SET DEFAULT nextval('public.cidade_id_seq'::regclass);

--
-- Name: cidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cidade_id_seq', 1, false);


--
-- Name: cidade cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);


--
-- Estrutura da tabela "estado"
--

DROP TABLE IF EXISTS "estado" CASCADE;

CREATE TABLE estado (
  id     bigserial NOT NULL,
  nome   varchar(60),
  uf  varchar(2),
  ibge   integer,
  pais   integer,
  ddd    json,
  /* Keys */
  CONSTRAINT estado_pkey
    PRIMARY KEY (id)
);

COMMENT ON TABLE estado
  IS 'Unidades Federativas';


ALTER SEQUENCE estado_id_seq
  RESTART 99;

--
-- Estrutura da tabela "pais"
--

DROP TABLE IF EXISTS "pais" CASCADE;
CREATE TABLE pais (
  id       bigserial NOT NULL,
  nome     varchar(60),
  nome_pt  varchar(60),
  sigla     varchar(2),
  bacen    integer,
  /* Keys */
  CONSTRAINT pais_pkey
    PRIMARY KEY (id)
);

COMMENT ON TABLE pais
  IS 'Países e Nações';

COMMENT ON COLUMN pais.sigla
  IS 'ISO 3166-1 Alpha2';


CREATE EXTENSION IF NOT EXISTS cube;
CREATE EXTENSION IF NOT EXISTS earthdistance;

--BY_POINT
/*

--Consulta de cidades próximas de outra em determinado raio de distância

select distinct c2.id, c2.nome, (c1.lat_lon <@> c2.lat_lon) as di
from public.cidade c1
	inner join public.cidade c2
		on (c1.lat_lon <@> c2.lat_lon) < 100
where c1.nome ilike 'Salvador';




WITH DIST as (SELECT ((select lat_lon from cidade where nome ilike 'São Paulo')
<@> (select lat_lon from cidade where id=c.id)) x (distancia double precision))
select distinct c.nome, DIST from public.cidade c

WHERE DIST.distancia < 100;



*/
--BY_CUBE
--Cube
/*

select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742),
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;

*/

