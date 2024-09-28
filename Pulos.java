public class Pulos {
    public static void main(String[] args) {
        int tam = args[0].length();

        if(args[0].contains("000") || args[0].charAt(0) != 'm' || args[0].charAt(tam-1) != 'm') {
            System.out.println("0");
            return;
        }

        System.out.println(caminhoRec(args[0], false));

        int vet[][] = new int[tam][tam];
        for (int i=0; i<tam; i++) {
            for(int j=0; j<tam; j++) {
                vet[i][j] = -1;
            }
        }
        System.out.println(caminhoRecMem(args[0], false, vet, tam-1));

        System.out.println(caminhoVet(args[0]));
    }

    public static int caminhoRec(String a, boolean rep) {
        int tam = a.length()-1;

        if(a.charAt(tam) == '0' || tam < 0) return 0;
        if(a.charAt(tam) == 'm' && tam == 0) return 1;

        int res1 = tam >= 1 ? caminhoRec(a.substring(0, tam), false) : 0;
        int res2 = tam >= 2 ? caminhoRec(a.substring(0, tam - 1), false) : 0;
        int res3 = tam >= 3 && !rep ? caminhoRec(a.substring(0, tam - 2), true) : 0;

        return res1 + res2 + res3;
    }

    public static int caminhoRecMem(String a, boolean rep, int[][] vet, int tam) {
        int pulo3 = rep ? 1 : 0;
        if (tam < 0 || a.charAt(tam) == '0') return 0;
        if (tam == 0 && a.charAt(tam) == 'm') return 1;
        if (vet[tam][pulo3] != -1) return vet[tam][pulo3];
    
        int res1 = caminhoRecMem(a, false, vet, tam - 1);
        int res2 = tam >= 2 ? caminhoRecMem(a, false, vet, tam - 2) : 0;
        int res3 = tam >= 3 && !rep ? caminhoRecMem(a, true, vet, tam - 3) : 0;
    
        vet[tam][pulo3] = res1 + res2 + res3;
    
        return vet[tam][pulo3];
    }

    public static int caminhoVet(String a) {
        int tam = a.length();

        int[] vet = new int[tam];
        int[] vet2 = new int[tam];
        vet[0] = 1;
        vet2[0] = 0; 
    
        for (int i = 1; i < tam; i++) {
            if (a.charAt(i) == '0') continue;
    
            if (i >= 1 && a.charAt(i - 1) != '0') {
                vet[i] += vet[i - 1]; 
                vet[i] += vet2[i - 1]; // veio de um pulo de 3
            }
            if (i >= 2 && a.charAt(i - 2) != '0') {
                vet[i] += vet[i - 2]; 
                vet[i] += vet2[i - 2]; // veio de um pulo de 3
            }

            if (i >= 3 && a.charAt(i - 3) != '0') {
                vet2[i] += vet[i - 3]; // veio de um pulo de 1 ou 2
            }
        }
    
        /*
        for(int i=0; i<tam; i++) {
            System.out.println("Vetor 1 | Posicao " +i +" = " +vet[i]);
        }

        System.out.println("\n");

        for(int i=0; i<tam; i++) {
            System.out.println("Vetor 2 | Posicao " +i +" = " +vet2[i]);
        }

        m11111m (vet1 + vet2)
        
        m        = 0 (1 + 0)
        m1       = 1 (1 + 0)
        m11      = 11 | 2 (2 + 0)
        m111     = 111 | 12 | 21 | 3 (3 + 1)
        m1111    = 1111 | 112 | 121 | 211 | 22 | 13 | 31 (6 + 1)
        m11111   = 11111 | 1112 | 1121 | 1211 | 2111 | 221 | 212 | 122 | 113 | 131 | 311 | 23 | 32 (11 + 2)
        m11111m  = 111111 | 11112 | 11121 | 11211 | 12111 | 21111 | 2211 | 1221 | 1122 | 2121 | 2112 | 1212 | 222 | 1113 | 1131 | 1311 | 3111 | 321 | 312 | 231 | 213 | 123 | 132 | 33 (20 + 3)
        
        System.out.println("Vetor 1 = " +vet[tam-1]);
        System.out.println("Vetor 2 = " +vet2[tam-1]);
        */

        return vet[tam - 1] + vet2[tam - 1];
    }
}