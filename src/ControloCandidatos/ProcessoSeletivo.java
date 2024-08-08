package ControloCandidatos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Felipe", "Laura", "Isaac", "Mirian", "Eloah"};
        SelecaoCandidatos();
        for (String candidato : candidatos)
            EntrandoEmContato(candidato);
    } static void EntrandoEmContato(String candidato){
        int tentivas = 1;
        boolean continuartentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuartentando = !atendeu;
            if (continuartentando){
                tentivas++;
            }else {
                System.out.println("Contato realizado com sucesso");
            }

        }while(continuartentando && tentivas<3);

        if(atendeu)
            System.out.println("Entramos em contato com o candidato "+ candidato + " na "+tentivas+"ª tentativa.");
        else
            System.out.println("Não foi possivel contactar o candidato "+ candidato);
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void ImprimirCandidatos(){
        String [] candidatos = {"Felipe", "Laura", "Isaac", "Mirian", "Eloah"};
        for (int i =0; i < candidatos.length; i++){
            System.out.println("O candidato nº "+ (i+1) + " foi "+ candidatos[i]);
        }
    }

    static void SelecaoCandidatos(){
        String [] candidatos = {"Felipe", "Isabela", "Rui", "Laura", "Geal", "Issac", "Mirian", "Eloah"};

        int candidatoselecionado = 0;
        int candidatoatual = 0;
        double salariobase = 2000.0;
        while(candidatoselecionado < 5 && candidatoatual < candidatos.length){
            String candidato = candidatos[candidatoatual];
            double valorpretendido = SalarioPretendido();
            System.out.println("O candidato "+ candidato + " Solicitou este valor de salario " + valorpretendido);
            if (salariobase >= valorpretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatoselecionado++;
            }
            candidatoatual++;
        }

    }
    static double SalarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void AnalisarCandidato(double salarioPretendido){
        double salariobase = 2000.0;
        if(salariobase < salarioPretendido){
            System.out.println("Ligar para o candidato");
        }
        else if (salariobase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else {
            System.out.println("Esperar proposta de outros candidatos");
        }
    }
}