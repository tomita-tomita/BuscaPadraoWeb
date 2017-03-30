/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Main {

    // busca char em vetor e retorna indice
    public static int get_char_ref(char[] vet, char ref) {
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == ref) {
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref(String[] vet, String ref) {
        for (int i = 0; i < vet.length; i++) {
            if (vet[i].equals(ref)) {
                return i;
            }
        }
        return -1;
    }

    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz, int estado_atual, char simbolo) {
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1) {
            return matriz[estado_atual][simbol_indice];
        } else {
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://www.lifewire.com/10-0-0-1-818065");
        crw.getListaRecursos().add("https://ptic2874.wordpress.com/4-ipv4/");
        crw.getListaRecursos().add("https://pt.wikipedia.org/wiki/Endere%C3%A7o_IP");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        for (int j = 0; j < listaCodigos.size(); j++) {
            String codigoHTML = listaCodigos.get(j);
                   
            //mapa do alfabeto
            char[] alfabeto = new char[11];
            alfabeto[0] = '0';
            alfabeto[1] = '1';
            alfabeto[2] = '2';
            alfabeto[3] = '3';
            alfabeto[4] = '4';
            alfabeto[5] = '5';
            alfabeto[6] = '6';
            alfabeto[7] = '7';
            alfabeto[8] = '8';
            alfabeto[9] = '9';
            alfabeto[10] = '.';

            //mapa de estados
            String[] estados = new String[16];
            estados[0] = "q0";  //[0..9]
            estados[1] = "q1";  //[0..9]
            estados[2] = "q2";  //[0..9]
            estados[3] = "q3";  //.     
            estados[4] = "q4";  //[0..9]
            estados[5] = "q5";  //[0..9]
            estados[6] = "q6";  //[0..9]
            estados[7] = "q7";  //.
            estados[8] = "q8";  //[0..9]
            estados[9] = "q9";  //[0..9]
            estados[10] = "q10"; //[0..9]
            estados[11] = "q11"; //.
            estados[12] = "q12"; //[0..9]
            estados[13] = "q13"; //[0..9]
            estados[14] = "q14"; //[0..9]
            estados[15] = "q15"; //[0..9]

            String estado_inicial = "q0";

            //estados finais
            String[] estados_finais = new String[3];
            estados_finais[0] = "q13";
            estados_finais[1] = "q14";
            estados_finais[2] = "q15";

            //tabela de transição de AFD para reconhecimento números de dois dígitos
            int[][] matriz = new int[16][11];
            //transições de q0
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q1");
            matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '.')] = -1;
            //transições de q1
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q2");
            matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q4");
            //transições de q2
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q3");
            matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q4");
            //transições de q3
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '0')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '1')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '2')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '3')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '4')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '5')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '6')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '7')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '8')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '9')] = -1;
            matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q4");
            //transições de q4
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q5");
            matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '.')] = -1;
            //transições de q5
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q6");
            matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q8");
            //transições de q6
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q7");
            matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q8");
            //transições de q7
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '0')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '1')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '2')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '3')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '4')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '5')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '6')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '7')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '8')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '9')] = -1;
            matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q8");
            //transições de q8
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q9");
            matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '.')] = -1;
            //transições de q9
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q10");
            matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q12");
            //transições de q10
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q11");
            matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q12");
            //transições de q11
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '0')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '1')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '2')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '3')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '4')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '5')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '6')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '7')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '8')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '9')] = -1;
            matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q12");
            //transições de q12
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q13");
            matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '.')] = -1;
            //transições de q13
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '.')] = -1;
            //transições de q14
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q14");
            matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '.')] = -1;

            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '0')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '1')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '2')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '3')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '4')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '5')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '6')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '7')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '8')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '9')] = -1;
            matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '.')] = -1;

            int estado = get_string_ref(estados, estado_inicial);
            int estado_anterior = -1;
            ArrayList<String> palavras_reconhecidas = new ArrayList();

            String palavra = "";

            //varre o código-fonte de um código
            for (int i = 0; i < codigoHTML.length(); i++) {

                estado_anterior = estado;
                estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
                //se o não há transição
                if (estado == -1) {
                    //pega estado inicial
                    estado = get_string_ref(estados, estado_inicial);
                    // se o estado anterior foi um estado final
                    if (get_string_ref(estados_finais, estados[estado_anterior]) != -1) {
                        //se a palavra não é vazia adiciona palavra reconhecida
                        if (!palavra.equals("")) {
                            palavras_reconhecidas.add(palavra);
                        }
                        // se ao analisar este caracter não houve transição
                        // teste-o novamente, considerando que o estado seja inicial
                        i--;
                    }
                    //zera palavra
                    palavra = "";

                } else {
                    //se houver transição válida, adiciona caracter a palavra
                    palavra += codigoHTML.charAt(i);
                }
            }

            //foreach no Java para exibir todas as palavras reconhecidas
            for (String p : palavras_reconhecidas) {
                System.out.println(p);
            }
        }

    }

}
