package br.com.digitalinnovation.abruzzo.project_cities_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EntityScan("br.com.digitalinnovation.abruzzo.project_cities_api.model")
public class ProjectCitiesApiApplication {

    public static void main(String[] args) {
        //executarComandosInicializacao();
        SpringApplication.run(ProjectCitiesApiApplication.class, args);
    }

    private static void executarComandosInicializacao() {
        Path path_this_directory = Paths.get(System.getProperty("user.dir"));
        String diretorio_scripts = String.format("%s/scripts", path_this_directory);
        try {
            String[] comando_parar_postgres_local = {"/etc/init.d/postgres", "stop"};
            executarComandoShell(comando_parar_postgres_local);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi possível interromper o serviço Postgres");
        }
        String cmd_iniciar_docker = String.format("/bin/bash %s/iniciar_docker.sh", diretorio_scripts);
        executarComandoShell(formatarComandoSudoRoot(cmd_iniciar_docker));
        verificaSePostgresqlDockerIsOn();
    }

    private static void verificaSePostgresqlDockerIsOn() {
        String comando = "docker ps";
        String[] comandoFormatado = (String[]) formatarComandoSudoRoot(comando);
        executarComandoShell(comandoFormatado);
    }

    private static String[] formatarComandoSudoRoot(String comando) {
        List<String> comandoComoLista = Arrays.asList(comando.split(" "));
        List<String> listaSudo = new ArrayList<String>();
        listaSudo.add("echo");
        String senhaUsuario = pegaSenhaRootUsuario();
        listaSudo.add(senhaUsuario);
        listaSudo.add("|");
        listaSudo.add("sudo");
        listaSudo.add("-S");
        listaSudo.addAll(comandoComoLista);
        String[] comandoFormatado = (String[]) listaSudo.toArray(new String[0]);
        return comandoFormatado;
    }


    private static void executarComandoShell(String[] comando) {
        Process processo = null;
        System.out.println("Rodando comando como root");
        try {
            processo = Runtime.getRuntime().exec(comando);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imprimirResultadoExecucao(processo);
    }


    public static String pegaSenhaRootUsuario() {
        String senhaRoot = JOptionPane.showInputDialog("Digite a senha root do sistema");
        return senhaRoot;
    }

    public static void imprimirResultadoExecucao(Process processo) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
        String line = "";
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
        }
    }

}