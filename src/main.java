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
			textoLinha = "";
		}
		arq.close();
		return "Imagen P1 criada";
	}
	
	public static String Pgm(int linha, int coluna, String nome) throws IOException {	
		String textoLinha = "";
		String cabecario = "";
		Random gerador = new Random();
		int t = 0;
		//Cria o arquivo e define a pasta de origem do arquivo
		FileWriter arq = new FileWriter("/home/adriano/Imagens/PDI/"+nome+".pgm");
	    PrintWriter gravarArq = new PrintWriter(arq);
		cabecario += "P2\n";
		cabecario += linha+" "+coluna+"\n";
		cabecario += "15\n";
		//Grava o cabeçario
		gravarArq.printf(cabecario);
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
			textoLinha = "";
		}
		arq.close();
		return "Imagen P2 criada";
	}
	
	public static String Ppm(int linha, int coluna, int intensidade, String nome) throws IOException {	
		String textoLinha = "";
		String cabecario = "";
		Random gerador = new Random();
		int t = 0;
		int rgb = 3;
		//Cria o arquivo e define a pasta de origem do arquivo
		FileWriter arq = new FileWriter("/home/adriano/Imagens/PDI/"+nome+".ppm");
	    PrintWriter gravarArq = new PrintWriter(arq);
		cabecario += "P3\n";
		cabecario += linha+" "+coluna+"\n";
		cabecario += intensidade+"\n";
		//Grava o cabeçario
		gravarArq.printf(cabecario);
		intensidade += 1;
		//Gera as colunas 
		for(int i = 0; i < coluna; i++) {
			//Gera as linhas com números aleatorios de 0 a 255 
			for(int y = 0; y < linha; y++) {
				for (int v = 0; v < rgb; v++) {
					t = gerador.nextInt(intensidade);
					textoLinha += t;
					textoLinha += " ";
				}
			}
			textoLinha += "\n";
			//Grava as linhas no arquivo
			gravarArq.printf(textoLinha);
			textoLinha = "";
		}
		arq.close();
		return "Imagen P3 criada";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		//Chama as funções definindo a quantidade de linhas e colunas
		Pbm(100, 100);
		Pgm(100, 100, "pgm");
		Ppm(100, 100, 15, "ppm100");
		Ppm(1000, 1000, 255, "ppm1000");
		Ppm(10, 10, 255, "ppm10");
		
	}
}
