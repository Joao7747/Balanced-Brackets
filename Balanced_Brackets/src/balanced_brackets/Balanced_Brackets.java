package balanced_brackets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * j Dell
 */
public class Balanced_Brackets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String response = "";
        int qtde = 0;
        int qtdeLinhas = 0;
        String analise = "";
        String[] vetor = new String[20];
        String linha = "";
        
        try {
            FileReader arq = new FileReader("prog.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            
            

            while (linha != null) {

                linha = lerArq.readLine();
                response = linha;
                
                int aux = -1;
                String letra = "";
                int tamanho = response.length();
                
                while (tamanho != aux) {
                    aux = response.length();
                    
                    if(aux != 0){
                    letra = response.substring(aux - 1);
}
                    if (letra.equals("[") && letra.equals("]") && letra.equals("{") && letra.equals("}") && letra.equals("(") && letra.equals(")")) {
                        response.replace(letra, "");
                    }

                    response = response.replace("()", "");
                    response = response.replace("[]", "");
                    response = response.replace("{}", "");
                    
                    tamanho = response.length();

                }

                if (response.length() == 0) {
                    analise = "OK";
                } else {
                    analise = "INVÁLIDO";
                }

                vetor[qtdeLinhas] = linha + " -> " + analise;
                qtdeLinhas++;
            }
            
            arq.close();

        } catch (Exception e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        try {

            FileWriter fw = new FileWriter("prog-check.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            String textoSaida = "";
            
            for(int i = 0; i<= qtdeLinhas - 1; i++)
            {
                
               textoSaida = textoSaida + vetor[i] + System.lineSeparator();
            
            }
                
            bw.write(textoSaida);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
