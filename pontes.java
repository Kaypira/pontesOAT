import java.util.*;

public class KonigsbergSolver {
    private static final int Numero_Bairros = 4;
    private static final String[] BAIRROS = {"Parque Estrela Dalva 1", "Parque Estrela Dalva 2", "Parque Estrela Dalva 3", "Parque Estrela Dalva 4"};

    private static int[][] grafo = {
        {0, 1, 1, 0},
        {1, 0, 0, 1},
        {1, 0, 0, 1},
        {0, 1, 1, 0}
    };

    private static List<String> caminho = new ArrayList<>();

    public static void main(String[] args) {
        encontrarCaminho(0);
        
        System.out.println("Caminho encontrado:");
        for (String bairro : caminho) {
            System.out.print(bairro + " -> ");
        }
        System.out.println("Fim");
    }

    private static void encontrarCaminho(int bairroAtual) {
        caminho.add(BAIRROS[bairroAtual]);
        
        if (caminho.size() == Numero_Bairros) {
            return;
        }
        
        for (int i = 0; i < Numero_Bairros; i++) {
            if (grafo[bairroAtual][i] == 1) {
                grafo[bairroAtual][i] = 0;
                grafo[i][bairroAtual] = 0;
                
                encontrarCaminho(i);
                
                if (caminho.size() == Numero_Bairros) {
                    return;
                }
                
                grafo[bairroAtual][i] = 1;
                grafo[i][bairroAtual] = 1;
            }
        }
        
        caminho.remove(caminho.size() - 1);
    }
}