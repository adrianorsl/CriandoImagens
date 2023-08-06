import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class main {
	
	public static String Pbm(int linha, int coluna) throws IOException {	
		String textoLinha = "";
		String cabecario = "";
		Random gerador = new Random();
		int t = 0;
		//Cria o arquivo e define a pasta de origem do arquivo
		FileWriter arq = new FileWriter("/home/adriano/Imagens/PDI/P1.pbm");
	    PrintWriter gravarArq = new PrintWriter(arq);
		cabecario += "P1\n";
		cabecario += linha+" "+coluna+"\n";
		//Grava o cabeçario
		gravarArq.printf(cabecario);
		linha -= 1;
		coluna -= 1;
		//Gera as colunas
		for(int i = 0; i < coluna; i++) {
			//Gera as linhas com números aleatorios de 0 a 15 
			for(int y = 0; y < linha; y++) {
				t = gerador.nextInt(2);
				textoLinha += t;
				textoLinha += " ";
			}
			textoLinha += "\n";
			//Grava as linhas no arquivo
			gravarArq.printf(textoLinha);	
		}
		arq.close();
		return "Imagen P1 criada";
	}
	
	public static String Pgm(int linha, int coluna) throws IOException {	
		String textoLinha = "";
		String cabecario = "";
		Random gerador = new Random();
		int t = 0;
		//Cria o arquivo e define a pasta de origem do arquivo
		FileWriter arq = new FileWriter("/home/adriano/Imagens/PDI/P2.pgm");
	    PrintWriter gravarArq = new PrintWriter(arq);
		cabecario += "P2\n";
		cabecario += linha+" "+coluna+"\n";
		cabecario += "15\n";
		//Grava o cabeçario
		gravarArq.printf(cabecario);
		linha -= 1;
		coluna -= 1;
		//Gera as colunas 
		for(int i = 0; i < coluna; i++) {
			//Gera as linhas com números aleatorios de 0 a 15 
			for(int y = 0; y < linha; y++) {
				t = gerador.nextInt(16);
				textoLinha += t;
				textoLinha += " ";
			}
			textoLinha += "\n";
			//Grava as linhas no arquivo
			gravarArq.printf(textoLinha);	
		}
		arq.close();
		return "Imagen P2 criada";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		//Chama as funções definindo a quantidade de linhas e colunas
		Pbm(100, 100);
		Pgm(100, 100);
		
	}
}
