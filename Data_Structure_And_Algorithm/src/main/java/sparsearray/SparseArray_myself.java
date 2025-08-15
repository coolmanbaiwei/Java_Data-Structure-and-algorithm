package sparsearray;

public class SparseArray_myself {
    public static void main(String[] args) {
        int chessArr[][] = new int[10][10];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 3;
        chessArr[2][5] = 4;
        chessArr[7][2] = 5;

        for(int[] row : chessArr){
            for(int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for(int[] row : chessArr){
            for (int data : row){
                if(data != 0){
                    sum++;
                }
            }
        }

        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

        int count = 0;
        for(int i = 0; i < chessArr.length; i++){
            for(int j = 0; j < chessArr[0].length; j++){
                if(chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        for(int[] row : sparseArr){
            for(int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for ( int i = 1; i < sparseArr.length; i++){
            for ( int j = 0; j < sparseArr[0].length; j++){
                if (sparseArr[i][j] != 0){
                    chessArr2[sparseArr[i][0]][sparseArr[i][1]]
                            = sparseArr[i][2];
                }
            }
        }


        System.out.println("恢复的二维数组>>>>>");
        for(int[] row : chessArr2){
            for(int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }

    }
}
