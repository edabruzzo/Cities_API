package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
public class ControladorBase {

    @RequestMapping(value = "/",method = RequestMethod.GET, produces="text/html")
    public void inicio(Writer writer, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setContentType("text/html");
        writer.append(index());
        writer.flush();
    }

    private String index() {
        return "<!DOCTYPE html>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\"  >\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>API para consultas GEO Espaciais de cidades do Brasiol</title>\n" +
                "</head>\n" +
                "<body><h1 id=\"projeto-digital-innovation-one-cities-api\">Projeto Digital Innovation One Cities API</h1>\n" +
                "<h2 id=\"projeto-entregue-como-requisito-parcial-do-bootcamp-tqi-java-developer\">Projeto entregue como requisito parcial do BootCamp TQI - JAVA DEVELOPER</h2>\n" +
                "<h3 id=\"emmanuel-de-oliveira-abruzzo-novembro-2021\">Emmanuel de Oliveira Abruzzo - Novembro/2021</h3>\n" +
                "<pre><code>Deploy <span class=\"hljs-built_in\">do</span> projeto DIGITAL INNOVATION <span class=\"hljs-literal\">ONE</span> - BOOTCAMP - TQI-JAVA-DEVELOPER - NOV/<span class=\"hljs-number\">2021</span>\n" +
                "</code></pre><h4 id=\"api-spring-rest-para-c-lculo-de-dist-ncia-entre-cidades-com-base-no-raio-da-terra-suporte-a-c-lculo-com-diferentes-m-todos-e-medidas\">API SPRING REST PARA CÁLCULO DE DISTÂNCIA ENTRE CIDADES COM BASE NO RAIO DA TERRA - SUPORTE A CÁLCULO COM DIFERENTES MÉTODOS E MEDIDAS</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/\">https://fierce-atoll-34490.herokuapp.com/</a>    deployed to Heroku<h4 id=\"github-\">GITHUB:</h4>\n" +
                "    </li>\n" +
                "    <li><a href=\"https://github.com/edabruzzo/\">https://github.com/edabruzzo/</a><h4 id=\"linkedin-\">LINKEDIN:</h4>\n" +
                "    </li>\n" +
                "    <li><a href=\"https://www.linkedin.com/in/emmanuel-abruzzo-8ba80a36/\">https://www.linkedin.com/in/emmanuel-abruzzo-8ba80a36/</a><h4 id=\"discord-dio\">DISCORD - DIO</h4>\n" +
                "    </li>\n" +
                "    <li>Discord: <a href=\"https://discord.gg/AWxMaerJ\">https://discord.gg/AWxMaerJ</a><h4 id=\"digital-innovation-one_\">DIGITAL INNOVATION ONE</h4>\n" +
                "    </li>\n" +
                "    <li><a href=\"https://digitalinnovation.one/\">https://digitalinnovation.one/</a></li>\n" +
                "    <li><h4 id=\"video-deploy\">Video deploy</h4>\n" +
                "    </li>\n" +
                "    <li><a href=\"https://youtu.be/6Vd3WYr5r3E\">https://youtu.be/6Vd3WYr5r3E</a></li>\n" +
                "    <li><a href=\"https://youtu.be/MM0CQyWEQ7s\">https://youtu.be/MM0CQyWEQ7s</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"desenvolvimento-developer\">Desenvolvimento #Developer</h4>\n" +
                "<h4 id=\"spring\">Spring</h4>\n" +
                "<h5 id=\"java\">JAVA</h5>\n" +
                "<h4 id=\"digital-innovation-one\">Digital Innovation One</h4>\n" +
                "<h2 id=\"endpoints\">Endpoints</h2>\n" +
                "<h4 id=\"lista-cidades-pr-ximas-de-uma-determinada-cidade-nomecidadefrom-num-determinado-raio-em-kilometros-raiodistancia-\">Lista cidades próximas de uma determinada cidade (nomeCidadeFrom) num determinado raio em kilometros (raioDistancia)</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/distances/Curitiba/100\">https://fierce-atoll-34490.herokuapp.com/distances/Curitiba/100</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/distances/Curitiba/150\">http://localhost:8080/distances/Curitiba/150</a></li>\n" +
                "</ul>\n" +
                "<h3 id=\"diferentes-approachs-requestparam-pathvariable-\">Diferentes approachs (RequestParam / PathVariable)</h3>\n" +
                "<ul>\n" +
                "    <li>No Rest Controller temos sobrecarga de métodos no Backend (mesmo nome e diferentes assinaturas)</li>\n" +
                "</ul>\n" +
                "<h4 id=\"exemplo-dist-ncia-curitiba-salvador\">Exemplo - Distância Curitiba -&gt; Salvador</h4>\n" +
                "<p>616;&quot;Salvador&quot;;5;2927408;&quot;(-12.9717998504639,-38.5010986328125)&quot;;-1.29717998504638e+17;-385010986328125;3849\n" +
                "    2878;&quot;Curitiba&quot;;18;4106902;&quot;(-25.4195003509521,-49.2645988464355)&quot;;-2.5419500350952e+17;-4.92645988464354e+17;7535</p>\n" +
                "<h4 id=\"calcula-dist-ncia-entre-cidades-baseadas-em-pontos-por-idcidade\">Calcula distância entre cidades baseadas em pontos por idCidade</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/distances/by-points?from=616&amp;to=278\">https://fierce-atoll-34490.herokuapp.com/distances/by-points?from=616&amp;to=278</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/distances/by-points?from=616&amp;to=278\">http://localhost:8080/distances/by-points?from=616&amp;to=278</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"calcula-dist-ncia-entre-cidades-baseadas-em-pontos-por-nome\">Calcula distância entre cidades baseadas em pontos por Nome</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/distances/by-points/Curitiba/Salvador\">https://fierce-atoll-34490.herokuapp.com/distances/by-points/Curitiba/Salvador</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/distances/by-points/Curitiba/Salvador\">http://localhost:8080/distances/by-points/Curitiba/Salvador</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"calcula-dist-ncia-entre-cidades-baseadas-em-cube-e-coordenadas-de-latitude-e-longitude\">Calcula distância entre cidades baseadas em Cube e coordenadas de Latitude e Longitude</h4>\n" +
                "<pre><code><span class=\"hljs-attr\">X1</span> = Latitude da cidade <span class=\"hljs-number\">1</span> / Y1 = Longitude cidade <span class=\"hljs-number\">1</span>\n" +
                "<span class=\"hljs-attr\">X2</span> = Latitude da cidade <span class=\"hljs-number\">2</span> / y2 = Longitude cidade <span class=\"hljs-number\">2</span>\n" +
                "</code></pre><ul>\n" +
                "    <li><p><a href=\"https://fierce-atoll-34490.herokuapp.com/distances/by-cube?x1=-25.4195003509521&amp;y1=-49.2645988464355&amp;x2=-2.5419500350952e+17&amp;y2=-4.92645988464354e+17\">https://fierce-atoll-34490.herokuapp.com/distances/by-cube?x1=-25.4195003509521&amp;y1=-49.2645988464355&amp;x2=-2.5419500350952e+17&amp;y2=-4.92645988464354e+17</a></p>\n" +
                "    </li>\n" +
                "    <li><p><a href=\"http://localhost:8080/distances/by-cube?x1=-25.4195003509521&amp;y1=-49.2645988464355&amp;x2=-2.5419500350952e+17&amp;y2=-4.92645988464354e+17\">http://localhost:8080/distances/by-cube?x1=-25.4195003509521&amp;y1=-49.2645988464355&amp;x2=-2.5419500350952e+17&amp;y2=-4.92645988464354e+17</a></p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h4 id=\"calcula-a-dist-ncia-entre-duas-cidades-por-matem-tica-pura-em-tr-s-op-es-de-unidade-de-medida\">Calcula a distância entre duas cidades por Matemática pura em três opções de unidade de medida</h4>\n" +
                "<pre><code>O cálculo é executado utilizando medidas de raio da Terra e fórmulas matemáticas\n" +
                "O parâmetro unidade de medida é opcional e, caso não especificado, será calculada <span class=\"hljs-selector-tag\">a</span> distância <span class=\"hljs-selector-tag\">em</span> KM\n" +
                "</code></pre><h4 id=\"devolve-o-c-lculo-em-km\">Devolve o cálculo em KM</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/distances/calcularPorMatematicaPura/São\">https://fierce-atoll-34490.herokuapp.com/distances/calcularPorMatematicaPura/São</a> Paulo/Curitiba/kilometers</li>\n" +
                "    <li>localhost:8080/distances/calcularPorMatematicaPura/São Paulo/Curitiba/kilometers</li>\n" +
                "</ul>\n" +
                "<h4 id=\"devolve-o-c-lculo-em-uma-das-medidas-suportadas\">Devolve o cálculo em uma das medidas suportadas</h4>\n" +
                "<p>O que permite que o usuário passe o nome do Enum EarthRadius em letra minúscula é o StringToEnumEarthRadiusConverter\n" +
                "    Unidades de medida suportadas: metros ou  kilômetros ou milhas</p>\n" +
                "<ul>\n" +
                "    <li><p><a href=\"https://fierce-atoll-34490.herokuapp.com/distances/calcularPorMatematicaPura/Curitiba/Salvador/{unidadeMedida}\">https://fierce-atoll-34490.herokuapp.com/distances/calcularPorMatematicaPura/Curitiba/Salvador/{unidadeMedida}</a></p>\n" +
                "    </li>\n" +
                "    <li><p><a href=\"http://localhost:8080/distances/calcularPorMatematicaPura/Curitiba/Salvador/unidadeMedida}\">http://localhost:8080/distances/calcularPorMatematicaPura/Curitiba/Salvador/unidadeMedida}</a></p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<p>unidadeMedida={METERS/meters ou  KILOMETERS/kilometers ou MILES/miles}</p>\n" +
                "<h4 id=\"lista-cidades\">Lista Cidades</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/cities\">https://fierce-atoll-34490.herokuapp.com/cities</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/cities\">http://localhost:8080/cities</a></li>\n" +
                "</ul>\n" +
                "<p>Salvador</p>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/cities/616\">https://fierce-atoll-34490.herokuapp.com/cities/616</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/cities/616\">http://localhost:8080/cities/616</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"lista-estados\">Lista Estados</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"http://localhost:8080/states\">http://localhost:8080/states</a></li>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/states\">https://fierce-atoll-34490.herokuapp.com/states</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/states/{id}\">http://localhost:8080/states/{id}</a></li>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/states{id}\">https://fierce-atoll-34490.herokuapp.com/states{id}</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"lista-pa-ses\">Lista Países</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"http://localhost:8080/countries\">http://localhost:8080/countries</a></li>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/states\">https://fierce-atoll-34490.herokuapp.com/states</a></li>\n" +
                "    <li><a href=\"http://localhost:8080/countries/{id}\">http://localhost:8080/countries/{id}</a></li>\n" +
                "    <li><a href=\"https://fierce-atoll-34490.herokuapp.com/states/{id}\">https://fierce-atoll-34490.herokuapp.com/states/{id}</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"explora-o-de-conceitos-de-orienta-o-a-objeto\">EXPLORAÇÃO DE CONCEITOS DE ORIENTAÇÃO A OBJETO</h4>\n" +
                "<pre><code>O projeto explora também o conceito de sobrecarga de métodos e contrutores\n" +
                "Foram declarados métodos com o mesmo nome e assinaturas diferentes na camada de serviço\n" +
                "Foi criada uma <span class=\"hljs-class\"><span class=\"hljs-keyword\">interface</span> <span class=\"hljs-title\">na</span> <span class=\"hljs-title\">camada</span> <span class=\"hljs-title\">servi</span>ç<span class=\"hljs-title\">o</span> <span class=\"hljs-title\">para</span> <span class=\"hljs-title\">estabelecer</span> <span class=\"hljs-title\">um</span> <span class=\"hljs-title\">contrato</span> <span class=\"hljs-title\">entre</span> <span class=\"hljs-title\">a</span> <span class=\"hljs-title\">classe</span> <span class=\"hljs-title\">de</span> <span class=\"hljs-title\">c</span>á<span class=\"hljs-title\">lculo</span> <span class=\"hljs-title\">que</span> <span class=\"hljs-title\">a</span> <span class=\"hljs-title\">implementa</span> </span>\n" +
                "E realizada de fato <span class=\"hljs-keyword\">as</span> operações para cálculo, invocando métodos na camada repositório\n" +
                "\n" +
                "<span class=\"hljs-meta\">@Override</span>\n" +
                "<span class=\"hljs-keyword\">public</span> <span class=\"hljs-built_in\">Double</span> calculaDistanciaEntreCidadesUsandoMatematicaPura(<span class=\"hljs-built_in\">Long</span> idCidade1, <span class=\"hljs-built_in\">Long</span> idCidade2, EarthRadius unit) {\n" +
                "\n" +
                "<span class=\"hljs-meta\">@Override</span>\n" +
                "<span class=\"hljs-keyword\">public</span> <span class=\"hljs-built_in\">Double</span> calculaDistanciaEntreCidadesUsandoMatematicaPura(String nomeCidade1, String nomeCidade2, EarthRadius unit) {\n" +
                "</code></pre><h4 id=\"explora-o-de-declara-o-de-nativenamedqueries-nas-classes-de-entidade-na-camada-modelo\">Exploração de declaração de @NativeNamedQueries nas Classes de Entidade, na camada modelo</h4>\n" +
                "<pre><code>O projeto explora também o conceito de Queries nomeadas declaradas <span class=\"hljs-built_in\">na</span>\n" +
                "Classe de entidade e também Queries declaradas <span class=\"hljs-built_in\">na</span> camada Repository (DAO)\n" +
                "</code></pre><h2 id=\"requirements\">Requirements</h2>\n" +
                "<ul>\n" +
                "    <li>Linux\n" +
                "        Meu sistema já é Ubuntu (release &quot;Bionic&quot;)</li>\n" +
                "    <li>Git</li>\n" +
                "    <li>Java 8</li>\n" +
                "    <li><p>Docker</p>\n" +
                "    </li>\n" +
                "    <li><p>IntelliJ Community ou NetBeans</p>\n" +
                "        <ul>\n" +
                "            <li>Desenvolvido inicialmente no NetBeans e depois migrei para o IntelliJ Idea</li>\n" +
                "            <li>Adorei o IntelliJ, pois já estava muito familiarizado com o PyCharm da JetBrains</li>\n" +
                "            <li>Sempre desenvolvi em NetBeans, mas depois deste BootCamp, começo a considerar migrar para o IntelliJ</li>\n" +
                "        </ul>\n" +
                "    </li>\n" +
                "    <li><p>Heroku CLI</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h2 id=\"database\">DataBase</h2>\n" +
                "<h3 id=\"postgres\">Postgres</h3>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://hub.docker.com/_/postgres\">Postgres Docker Hub</a></li>\n" +
                "</ul>\n" +
                "<pre><code>docker <span class=\"hljs-keyword\">run</span><span class=\"bash\"> --name cities-db <span class=\"hljs-_\">-d</span> -p 5432:5432 <span class=\"hljs-_\">-e</span> POSTGRES_USER=postgres_user_city <span class=\"hljs-_\">-e</span> POSTGRES_PASSWORD=super_password <span class=\"hljs-_\">-e</span> POSTGRES_DB=cities postgres</span>\n" +
                "</code></pre><h3 id=\"populate\">Populate</h3>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL\">data</a></li>\n" +
                "</ul>\n" +
                "<h6 id=\"aten-o-se-voc-possui-o-postgresql-instalado-na-maquina-local-das-duas-uma-\">Atenção ! Se você possui o Postgresql instalado na maquina local das duas uma:</h6>\n" +
                "<ul>\n" +
                "    <li>Terá que parar o serviço do postgres que roda na porta 5432 antes de rodar a imagem docker</li>\n" +
                "</ul>\n" +
                "<pre><code>/etc/init.d/postgres <span class=\"hljs-built_in\">stop</span>\n" +
                "</code></pre><ul>\n" +
                "    <li>Mudar a porta exposta pela imagem para não mapear a 5432 que já estará em uso no seu banco local</li>\n" +
                "</ul>\n" +
                "<h4 id=\"escrevi-um-artigo-na-dio-a-respeito-do-conflito-de-portas-\">Escrevi um artigo na DIO a respeito do conflito de portas:</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://digitalinnovation.one/artigos/avoid-port-conflicts-when-configuring-postgresql-image-from-docker-on-your-local-machine-with-another-postgresql-instance\">https://digitalinnovation.one/artigos/avoid-port-conflicts-when-configuring-postgresql-image-from-docker-on-your-local-machine-with-another-postgresql-instance</a></li>\n" +
                "</ul>\n" +
                "<pre><code><span class=\"hljs-keyword\">cd</span> /home/<span class=\"hljs-variable\">$USER</span>/NetBeansProjects/DigitalOne_2/project_cities_api/scripts/PostgreSQL &amp;&amp;\n" +
                "/etc/init.<span class=\"hljs-keyword\">d</span>/postgresql stop &amp;&amp; sudo docker <span class=\"hljs-keyword\">run</span> -it --<span class=\"hljs-keyword\">rm</span> --<span class=\"hljs-keyword\">net</span>=host -v <span class=\"hljs-variable\">$PWD</span>:/tmp postgres /bin/bash\n" +
                "\n" +
                "<span class=\"hljs-keyword\">cd</span> tmp/ &amp;&amp; <span class=\"hljs-keyword\">for</span> <span class=\"hljs-keyword\">file</span> <span class=\"hljs-keyword\">in</span> *.sql; <span class=\"hljs-keyword\">do</span> psql -<span class=\"hljs-keyword\">U</span> postgres_user_city -<span class=\"hljs-keyword\">h</span> localhost -p 5432 -<span class=\"hljs-keyword\">d</span> cities -f <span class=\"hljs-variable\">$file</span>; done\n" +
                "\n" +
                "psql -<span class=\"hljs-keyword\">h</span> localhost -<span class=\"hljs-keyword\">U</span> postgres_user_city cities\n" +
                "\n" +
                "##### Transportadas para um arquivo changelog <span class=\"hljs-keyword\">de</span> migração *.sql para serem executadas <span class=\"hljs-keyword\">no</span> loop <span class=\"hljs-keyword\">for</span> acima\n" +
                "</code></pre><p>--CREATE EXTENSION cube;\n" +
                "    --CREATE EXTENSION earthdistance;</p>\n" +
                "<pre><code>\n" +
                "<span class=\"hljs-bullet\">* </span>[<span class=\"hljs-string\">Postgres Earth distance</span>](<span class=\"hljs-link\">https://www.postgresql.org/docs/current/earthdistance.html</span>)\n" +
                "<span class=\"hljs-bullet\">* </span>[<span class=\"hljs-string\">earthdistance--1.0--1.1.sql</span>](<span class=\"hljs-link\">https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql</span>)\n" +
                "<span class=\"hljs-bullet\">* </span>[<span class=\"hljs-string\">OPERATOR &lt;@&gt;</span>](<span class=\"hljs-link\">https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql</span>)\n" +
                "<span class=\"hljs-bullet\">* </span>[<span class=\"hljs-string\">postgrescheatsheet</span>](<span class=\"hljs-link\">https://postgrescheatsheet.com/#/tables</span>)\n" +
                "<span class=\"hljs-bullet\">* </span>[<span class=\"hljs-string\">datatype-geometric</span>](<span class=\"hljs-link\">https://www.postgresql.org/docs/current/datatype-geometric.html</span>)\n" +
                "\n" +
                "<span class=\"hljs-section\">### Access</span>\n" +
                "</code></pre><p>docker exec -it cities-db /bin/bash</p>\n" +
                "<p>psql -U postgres_user_city cities</p>\n" +
                "<pre><code>\n" +
                "### Query Earth Distance\n" +
                "\n" +
                "Point\n" +
                "```roomsql\n" +
                "select ((select lat_lon <span class=\"hljs-keyword\">from</span> cidade <span class=\"hljs-keyword\">where</span> id = <span class=\"hljs-number\">4929</span>) &lt;@&gt; (select lat_lon <span class=\"hljs-keyword\">from</span> cidade <span class=\"hljs-keyword\">where</span> id=<span class=\"hljs-number\">5254</span>)) <span class=\"hljs-keyword\">as</span> distance;\n" +
                "</code></pre><h4 id=\"consulta-de-cidades-pr-ximas-de-outra-em-determinado-raio-de-dist-ncia\">Consulta de cidades próximas de outra em determinado raio de distância</h4>\n" +
                "<pre><code class=\"lang-roomsql\"><span class=\"hljs-keyword\">select</span> <span class=\"hljs-keyword\">distinct</span> c2.id, c2.nome, (c1.lat_lon &lt;@&gt; c2.lat_lon) <span class=\"hljs-keyword\">as</span> di\n" +
                "<span class=\"hljs-keyword\">from</span> public.cidade c1\n" +
                "    <span class=\"hljs-keyword\">inner</span> <span class=\"hljs-keyword\">join</span> public.cidade c2\n" +
                "        <span class=\"hljs-keyword\">on</span> (c1.lat_lon &lt;@&gt; c2.lat_lon) &lt; <span class=\"hljs-number\">100</span>\n" +
                "<span class=\"hljs-keyword\">where</span> c1.nome <span class=\"hljs-keyword\">ilike</span> <span class=\"hljs-string\">'São Paulo'</span>;\n" +
                "</code></pre>\n" +
                "<p>Cube</p>\n" +
                "<pre><code class=\"lang-roomsql\">select earth_distance(\n" +
                "    <span class=\"hljs-name\">ll_to_earth</span>(<span class=\"hljs-name\">-21</span>.<span class=\"hljs-number\">95840072631836</span>,<span class=\"hljs-number\">-47.98820114135742</span>),\n" +
                "    ll_to_earth(<span class=\"hljs-name\">-22</span>.<span class=\"hljs-number\">01740074157715</span>,<span class=\"hljs-number\">-47.88600158691406</span>)\n" +
                ") as distance<span class=\"hljs-comment\">;</span>\n" +
                "</code></pre>\n" +
                "<h3 id=\"hibernate-spatial\">Hibernate-spatial</h3>\n" +
                "<pre><code>Criei uma branch <span class=\"hljs-keyword\">e</span> <span class=\"hljs-keyword\">profile</span> específicos apenas para explorar <span class=\"hljs-keyword\">o</span> hibernate-spatial\n" +
                "como alternativa para lidar <span class=\"hljs-keyword\">com</span> tipos Geoespaciais <span class=\"hljs-keyword\">no</span> PostgreSQL, <span class=\"hljs-keyword\">no</span> momento de\n" +
                "mapear entidades <span class=\"hljs-keyword\">e</span> acessar os dados persistidos <span class=\"hljs-keyword\">com</span> tipo Point, Geometry, etc\n" +
                "</code></pre><h2 id=\"spring-boot\">Spring Boot</h2>\n" +
                "<ul>\n" +
                "    <li><p><a href=\"https://start.spring.io/\">https://start.spring.io/</a></p>\n" +
                "    </li>\n" +
                "    <li><p>Java 8</p>\n" +
                "    </li>\n" +
                "    <li>MAVEN Project<ul>\n" +
                "        <li>Devido à minha familiaridade, optei por desenvolver e construir o projeto e gerenciar dependências com Maven</li>\n" +
                "    </ul>\n" +
                "    </li>\n" +
                "    <li>Jar</li>\n" +
                "    <li>Spring Web</li>\n" +
                "    <li>Spring Data JPA</li>\n" +
                "    <li><p>PostgreSQL Driver\n" +
                "        Versão: 42.2.24</p>\n" +
                "        <h3 id=\"spring-data\">Spring Data</h3>\n" +
                "    </li>\n" +
                "    <li><p><a href=\"https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods\">jpa.query-methods</a></p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h3 id=\"properties\">Properties</h3>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html\">appendix-application-properties</a></li>\n" +
                "    <li><a href=\"https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases\">jdbc-database-connectio</a></li>\n" +
                "</ul>\n" +
                "<h3 id=\"types\">Types</h3>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://github.com/vladmihalcea/hibernate-types\">JsonTypes</a></li>\n" +
                "    <li><a href=\"https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html\">UserType</a></li>\n" +
                "</ul>\n" +
                "<h2 id=\"heroku\">Heroku</h2>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku\">DevCenter</a></li>\n" +
                "</ul>\n" +
                "<h2 id=\"code-quality\">Code Quality</h2>\n" +
                "<h3 id=\"pmd\">PMD</h3>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://pmd.github.io/pmd-6.8.0/index.html\">https://pmd.github.io/pmd-6.8.0/index.html</a></li>\n" +
                "</ul>\n" +
                "<h3 id=\"checkstyle\">Checkstyle</h3>\n" +
                "<ul>\n" +
                "    <li><p><a href=\"https://checkstyle.org/\">https://checkstyle.org/</a></p>\n" +
                "    </li>\n" +
                "    <li><p><a href=\"https://checkstyle.org/google_style.html\">https://checkstyle.org/google_style.html</a></p>\n" +
                "    </li>\n" +
                "    <li><p><a href=\"http://google.github.io/styleguide/javaguide.html\">http://google.github.io/styleguide/javaguide.html</a></p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<pre><code>wget https:<span class=\"hljs-regexp\">//</span>raw.githubusercontent.com<span class=\"hljs-regexp\">/checkstyle/</span>checkstyle<span class=\"hljs-regexp\">/master/</span>src<span class=\"hljs-regexp\">/main/</span>resources<span class=\"hljs-regexp\">/google_checks.xml</span>\n" +
                "</code></pre><h3 id=\"outras-refer-ncias-teis\">OUTRAS REFERÊNCIAS ÚTEIS</h3>\n" +
                "<h4 id=\"spring-rest-application\">SPRING REST APPLICATION</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html\">https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html</a></li>\n" +
                "    <li><a href=\"https://spring.io/guides/gs/rest-service/\">https://spring.io/guides/gs/rest-service/</a></li>\n" +
                "    <li><a href=\"https://spring.io/guides\">https://spring.io/guides</a></li>\n" +
                "    <li><a href=\"https://www.tutorialspoint.com/spring/calling_stored_procedure.htm\">https://www.tutorialspoint.com/spring/calling_stored_procedure.htm</a></li>\n" +
                "    <li><a href=\"https://www.tutorialspoint.com/spring_boot/spring_boot_consuming_restful_web_services.htm\">https://www.tutorialspoint.com/spring_boot/spring_boot_consuming_restful_web_services.htm</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"git-pull-request-tutorial\">GIT PULL-REQUEST TUTORIAL</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://www.digitalocean.com/community/tutorials/how-to-create-a-pull-request-on-github\">https://www.digitalocean.com/community/tutorials/how-to-create-a-pull-request-on-github</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"discuss-o-sobre-inje-o-de-depend-ncia\">Discussão sobre injeção de dependência</h4>\n" +
                "<ul>\n" +
                "    <li><p><a href=\"https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html\">https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html</a></p>\n" +
                "    </li>\n" +
                "    <li><p>&quot;O Spring automaticamente fornece a injeção de dependência. Este exemplo não está usando a anotação @Autowired pois não é mais considerado\n" +
                "        uma boa prática para injeção de dependência de atributos obrigatórios. Desde a versão 4 do\n" +
                "        Spring a prática recomendada é o uso de injeção de dependência por construtor\n" +
                "        (as IDEs mais modernas inclusive apresentam um alerta quando fazemos o uso do @Autowired).&quot;</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h4 id=\"shell-java\">SHELL JAVA</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://stackabuse.com/executing-shell-commands-with-java/\">https://stackabuse.com/executing-shell-commands-with-java/</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"string-format\">STRING FORMAT</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://www.javatpoint.com/java-string-format\">https://www.javatpoint.com/java-string-format</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"teste-spring\">TESTE SPRING</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://spring.io/guides/gs/testing-web/\">https://spring.io/guides/gs/testing-web/</a></li>\n" +
                "    <li><a href=\"https://www.baeldung.com/spring-boot-testing\">https://www.baeldung.com/spring-boot-testing</a></li>\n" +
                "    <li><a href=\"https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/\">https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/</a></li>\n" +
                "    <li><a href=\"https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm\">https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm</a></li>\n" +
                "    <li><a href=\"https://www.baeldung.com/spring-mock-rest-template\">https://www.baeldung.com/spring-mock-rest-template</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"geomapping-postgresql-x-hibernate\">GEOMAPPING - POSTGRESQL X HIBERNATE</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://stackoverflow.com/questions/27624940/map-a-postgis-geometry-point-field-with-hibernate-on-spring-boot\">https://stackoverflow.com/questions/27624940/map-a-postgis-geometry-point-field-with-hibernate-on-spring-boot</a></li>\n" +
                "    <li><a href=\"https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#spatial\">https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#spatial</a> </li>\n" +
                "    <li><a href=\"https://www.baeldung.com/hibernate-spatial\">https://www.baeldung.com/hibernate-spatial</a></li>\n" +
                "    <li><a href=\"https://stackoverflow.com/questions/31440496/hibernate-spatial-5-geometrytype\">https://stackoverflow.com/questions/31440496/hibernate-spatial-5-geometrytype</a></li>\n" +
                "    <li><a href=\"https://github.com/Wisienkas/springJpaGeo\">https://github.com/Wisienkas/springJpaGeo</a></li>\n" +
                "    <li><a href=\"https://www.postgresql.org/docs/12/functions-geometry.html\">https://www.postgresql.org/docs/12/functions-geometry.html</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"usando-namedqueries-ou-namednativequeries-com-spring-data\">USANDO NamedQueries ou NamedNativeQueries COM SPRING DATA</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://thorben-janssen.com/spring-data-jpa-named-queries/\">https://thorben-janssen.com/spring-data-jpa-named-queries/</a></li>\n" +
                "    <li><a href=\"https://howtodoinjava.com/jpa/jpa-native-query-example-select/\">https://howtodoinjava.com/jpa/jpa-native-query-example-select/</a></li>\n" +
                "    <li><a href=\"https://zetcode.com/springboot/datajpanamedquery/\">https://zetcode.com/springboot/datajpanamedquery/</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"error-handling-spring\">ERROR HANDLING SPRING</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://www.baeldung.com/exception-handling-for-rest-with-spring\">https://www.baeldung.com/exception-handling-for-rest-with-spring</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"redirection-controllers\">Redirection controllers</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://www.baeldung.com/spring-redirect-and-forward\">https://www.baeldung.com/spring-redirect-and-forward</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"interceptors-spring-x-cdi\">INTERCEPTORS SPRING X CDI</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://rhuanrocha.net/2019/01/06/creating-logger-with-aop-using-cdi-interceptor/\">https://rhuanrocha.net/2019/01/06/creating-logger-with-aop-using-cdi-interceptor/</a></li>\n" +
                "    <li><a href=\"https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm\">https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm</a></li>\n" +
                "    <li><a href=\"https://stackoverflow.com/questions/31082981/spring-boot-adding-http-request-interceptors\">https://stackoverflow.com/questions/31082981/spring-boot-adding-http-request-interceptors</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"conversor-string-para-enum-para-receber-parametro-minusculo\">Conversor String para Enum para Receber parametro Minusculo</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://www.baeldung.com/spring-enum-request-param\">https://www.baeldung.com/spring-enum-request-param</a></li>\n" +
                "    <li><a href=\"https://www.baeldung.com/spring-type-conversions\">https://www.baeldung.com/spring-type-conversions</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"deploy-da-aplica-o-springboot-maven-no-heroku\">Deploy da aplicação Springboot Maven no Heroku</h4>\n" +
                "<pre><code>Usando o <span class=\"hljs-keyword\">plugin</span> Heroku <span class=\"hljs-keyword\">do</span> Maven\n" +
                "</code></pre><pre><code>$ <span class=\"hljs-keyword\">mvn </span>clean dependency:copy-dependencies package heroku:deploy\n" +
                "\n" +
                "[<span class=\"hljs-meta\">INFO</span>] -----&gt; Creating <span class=\"hljs-keyword\">build...\n" +
                "</span>[<span class=\"hljs-meta\">INFO</span>]        - file: /tmp/heroku-deploy14168471124361201653source-<span class=\"hljs-keyword\">blob.tgz\n" +
                "</span>[<span class=\"hljs-meta\">INFO</span>]        - size: <span class=\"hljs-number\">131</span>MB\n" +
                "[<span class=\"hljs-meta\">INFO</span>] -----&gt; Uploading <span class=\"hljs-keyword\">build...\n" +
                "</span>^[[<span class=\"hljs-number\">5</span>F[<span class=\"hljs-meta\">INFO</span>]        - success\n" +
                "[<span class=\"hljs-meta\">INFO</span>] -----&gt; Deploying...\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; <span class=\"hljs-keyword\">Building </span>on the Heroku-<span class=\"hljs-number\">20</span> stack\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; Using <span class=\"hljs-keyword\">buildpack: </span>heroku/jvm\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; heroku-maven-plugin app detected\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; Installing JDK <span class=\"hljs-number\">1</span>.<span class=\"hljs-number\">8</span>... done\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; Discovering process types\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:        Procfile.USANDO_MAVEN declares types -&gt; web\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; Compressing...\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:        Done: <span class=\"hljs-number\">183</span>.<span class=\"hljs-number\">6</span>M\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote: -----&gt; Launching...\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:        Released v30\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:        https://fierce-atoll-<span class=\"hljs-number\">34490</span>.herokuapp.com/ deployed to Heroku\n" +
                "[<span class=\"hljs-meta\">INFO</span>] remote:\n" +
                "[<span class=\"hljs-meta\">INFO</span>] -----&gt; Done\n" +
                "[<span class=\"hljs-meta\">INFO</span>] ------------------------------------------------------------------------\n" +
                "[<span class=\"hljs-meta\">INFO</span>] <span class=\"hljs-keyword\">BUILD </span>SUCCESS\n" +
                "[<span class=\"hljs-meta\">INFO</span>] ------------------------------------------------------------------------\n" +
                "[<span class=\"hljs-meta\">INFO</span>] Total time:  <span class=\"hljs-number\">04</span>:<span class=\"hljs-number\">41</span> min\n" +
                "[<span class=\"hljs-meta\">INFO</span>] Finished at: <span class=\"hljs-number\">2021</span>-<span class=\"hljs-number\">11</span>-<span class=\"hljs-number\">17</span>T09:<span class=\"hljs-number\">53</span>:<span class=\"hljs-number\">40</span>-<span class=\"hljs-number\">03</span>:<span class=\"hljs-number\">00</span>\n" +
                "[<span class=\"hljs-meta\">INFO</span>] ------------------------------------------------------------------------\n" +
                "</code></pre><pre><code>$ heroku logs --tail\n" +
                "\n" +
                "\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:48:12.078750<span class=\"hljs-string\">+00</span>:00 heroku[run.7699]: State changed from up to complete\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:22.000000<span class=\"hljs-string\">+00</span>:00 app[api]: Build started by user emmanuel.oliveira3@gmail.com\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:38.991791<span class=\"hljs-string\">+00</span>:00 app[api]: Release v30 created by user emmanuel.oliveira3@gmail.com\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:38.991791<span class=\"hljs-string\">+00</span>:00 app[api]: Deploy 0.0.1-SNAPSHOT by user emmanuel.oliveira3@gmail.com\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:39.000000<span class=\"hljs-string\">+00</span>:00 app[api]: Build succeeded\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:40.044875<span class=\"hljs-string\">+00</span>:00 heroku[web.1]: State changed from crashed to starting\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:45.766843<span class=\"hljs-string\">+00</span>:00 heroku[web.1]: Starting process with command `java -Dserver.port=22517 -jar -Dspring.profiles.active=heroku target/project_cities_api<span class=\"hljs-string\">-0</span>.0.1-SNAPSHOT.jar`\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:47.956815<span class=\"hljs-string\">+00</span>:00 app[web.1]: Setting JAVA_TOOL_OPTIONS defaults based on dyno size. Custom settings will override them.\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:47.964565<span class=\"hljs-string\">+00</span>:00 app[web.1]: Picked up JAVA_TOOL_OPTIONS: -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF<span class=\"hljs-string\">-8</span>\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282528<span class=\"hljs-string\">+00</span>:00 app[web.1]:\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282650<span class=\"hljs-string\">+00</span>:00 app[web.1]: .   ____          _            __ _ _\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282692<span class=\"hljs-string\">+00</span>:00 app[web.1]: /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282733<span class=\"hljs-string\">+00</span>:00 app[web.1]: ( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282777<span class=\"hljs-string\">+00</span>:00 app[web.1]: \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282815<span class=\"hljs-string\">+00</span>:00 app[web.1]: '  |____| .__|_| |_|_| |_\\__, | / / / /\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.282852<span class=\"hljs-string\">+00</span>:00 app[web.1]: =========|_|==============|___/=/_/_/_/\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.283984<span class=\"hljs-string\">+00</span>:00 app[web.1]: :: Spring Boot ::                (v2.5.6)\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.284012<span class=\"hljs-string\">+00</span>:00 app[web.1]:\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.439824<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:49.437  INFO 4 --- [           main] b.c.d.a.p.ProjectCitiesApiApplication    : Starting ProjectCitiesApiApplication v0.0.1-SNAPSHOT using Java 1.8.0_312-heroku on 6618f368<span class=\"hljs-string\">-20</span>b2<span class=\"hljs-string\">-4544</span><span class=\"hljs-string\">-85</span>a9<span class=\"hljs-string\">-782</span>d23670d34 with PID 4 (/app/target/project_cities_api<span class=\"hljs-string\">-0</span>.0.1-SNAPSHOT.jar started by u9248 in /app)\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:49.440541<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:49.440  INFO 4 --- [           main] b.c.d.a.p.ProjectCitiesApiApplication    : The following profiles are active: heroku\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:50.379161<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:50.378  INFO 4 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:50.468044<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:50.467  INFO 4 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 63 ms. Found 3 JPA repository interfaces.\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.169628<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.169  INFO 4 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 22517 (http)\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.181191<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.181  INFO 4 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.181338<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.181  INFO 4 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.54]\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.235918<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.235  INFO 4 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.236045<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.235  INFO 4 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1713 ms\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.480657<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.479  INFO 4 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.539039<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.538  INFO 4 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.32.Final\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.851441<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.851  INFO 4 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:51.957733<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:51.957  INFO 4 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool<span class=\"hljs-string\">-1</span> - Starting...\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:52.297792<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:52.297  INFO 4 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool<span class=\"hljs-string\">-1</span> - Start completed.\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:52.340627<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:52.340  INFO 4 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:53.089442<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:53.089  INFO 4 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:53.321481<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:53.321  INFO 4 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:54.136065<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:54.135  WARN 4 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:54.789421<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:54.789  INFO 4 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 22517 (http) with context path ''\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:54.801433<span class=\"hljs-string\">+00</span>:00 app[web.1]: 2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span> 12:53:54.801  INFO 4 --- [           main] b.c.d.a.p.ProjectCitiesApiApplication    : Started ProjectCitiesApiApplication in 6.057 seconds (JVM running for 6.837)\n" +
                "2021<span class=\"hljs-string\">-11</span><span class=\"hljs-string\">-17</span>T12:53:55.095750<span class=\"hljs-string\">+00</span>:00 heroku[web.1]: State changed from starting to up\n" +
                "</code></pre><ul>\n" +
                "    <li><a href=\"https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku\">https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku</a></li>\n" +
                "    <li><a href=\"https://stackoverflow.com/questions/32490217/java-web-app-on-heroku-unable-to-access-jarfile\">https://stackoverflow.com/questions/32490217/java-web-app-on-heroku-unable-to-access-jarfile</a></li>\n" +
                "    <li><a href=\"http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html\">http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html</a></li>\n" +
                "    <li><a href=\"https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku\">https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"heroku-db-migrations-on-release-phase\">Heroku DB Migrations on Release Phase</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://devcenter.heroku.com/articles/running-database-migrations-for-java-apps\">https://devcenter.heroku.com/articles/running-database-migrations-for-java-apps</a></li>\n" +
                "    <li><a href=\"https://devcenter.heroku.com/articles/release-phase\">https://devcenter.heroku.com/articles/release-phase</a></li>\n" +
                "</ul>\n" +
                "<h4 id=\"conex-o-banco-de-dados-postgresql-heroku-add-on\">Conexão Banco de Dados PostgreSQL Heroku Add-on</h4>\n" +
                "<ul>\n" +
                "    <li>Heroku configura no ambiente uma variável com URL para conexão ao banco de dados criado na AWS:</li>\n" +
                "</ul>\n" +
                "<pre><code>heroku config\n" +
                "\n" +
                "<span class=\"hljs-section\">=== fierce-atoll-34490 Config Vars</span>\n" +
                "DATABASE<span class=\"hljs-emphasis\">_URL: postgres://qmghvbmblxrlba:f623f1e760b51ab39cfc64a8549e62a1f814346dc203d252e0b5699343b298a8@ec2-3-227-149-67.compute-1.amazonaws.com:5432/d7q52pdubr9p5l</span>\n" +
                "</code></pre><p>Você pode se conectar ao banco via psql utilizando estas credenciais\n" +
                "    e a senha que pode ser vista no seu dashboard no Heroku Dev Center</p>\n" +
                "<pre><code>heroku pg:psql postgresql-clean<span class=\"hljs-string\">-54438</span> --app fierce-atoll<span class=\"hljs-string\">-34490</span>\n" +
                "</code></pre><p>Outro meio de se conectar diretamente com psql com as credenciais de banco e host fornecidas pelo próprio Heroku</p>\n" +
                "<pre><code>$ heroku <span class=\"hljs-string\">pg:</span>info\n" +
                "\n" +
                "=== DATABASE_URL\n" +
                "<span class=\"hljs-string\">Plan:</span>                  Hobby-dev\n" +
                "<span class=\"hljs-string\">Status:</span>                Available\n" +
                "<span class=\"hljs-string\">Connections:</span>           <span class=\"hljs-number\">0</span>/<span class=\"hljs-number\">20</span>\n" +
                "PG <span class=\"hljs-string\">Version:</span>            <span class=\"hljs-number\">13.4</span>\n" +
                "<span class=\"hljs-string\">Created:</span>               <span class=\"hljs-number\">2021</span><span class=\"hljs-number\">-11</span><span class=\"hljs-number\">-17</span> <span class=\"hljs-number\">01</span>:<span class=\"hljs-number\">49</span> UTC\n" +
                "Data <span class=\"hljs-string\">Size:</span>             <span class=\"hljs-number\">9.2</span> MB/<span class=\"hljs-number\">1.00</span> GB (In compliance)\n" +
                "<span class=\"hljs-string\">Tables:</span>                <span class=\"hljs-number\">3</span>\n" +
                "<span class=\"hljs-string\">Rows:</span>                  <span class=\"hljs-number\">5849</span>/<span class=\"hljs-number\">10000</span> (In compliance)\n" +
                "Fork/<span class=\"hljs-string\">Follow:</span>           Unsupported\n" +
                "<span class=\"hljs-string\">Rollback:</span>              Unsupported\n" +
                "Continuous <span class=\"hljs-string\">Protection:</span> Off\n" +
                "Add-<span class=\"hljs-string\">on:</span>                postgresql-clean<span class=\"hljs-number\">-54438</span>\n" +
                "</code></pre><h4 id=\"conversor-markdown-to-html-online\">Conversor MarkDown to HTML online</h4>\n" +
                "<ul>\n" +
                "    <li><a href=\"https://markdowntohtml.com/\">https://markdowntohtml.com/</a></li>\n" +
                "</ul>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }


}
