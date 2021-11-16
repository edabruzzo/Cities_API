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