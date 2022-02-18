public class Exercise08Final {
    public static void main(String[] args) {
        int arr [][] = {{1, 7, 5, 0},
                        {2, 8, 4, 0},
                        {3, 8, 6, 0},
                        {4, 9, 7, 0},
                        {5, 4, 2, 0}};

        double best = 0;
        double regBest = 0;
        double avg = 0;

        for (int i=0; i<5; i++) {
                do {
                    int examAvg = arr[(i)][1];
                    int projAvg = arr[(i)][2];

                    double finalGrade = (double) examAvg * 0.6 + (double) projAvg * 0.4;
                    avg += finalGrade;

                    if (finalGrade > best) {
                        best = finalGrade;
                        regBest = i;
                    }

                    i++;

                } while (i<5);
            }
        System.out.println("Matrícula número: "+((int)regBest+1));
        System.out.println("Média das provas: "+arr[(int)regBest][1]);
        System.out.println("Média dos trabalhos: "+arr[(int)regBest][2]);
        System.out.println("\nNota final: "+best);

        System.out.println("\nMédia geral: "+avg/5);


        }
    }