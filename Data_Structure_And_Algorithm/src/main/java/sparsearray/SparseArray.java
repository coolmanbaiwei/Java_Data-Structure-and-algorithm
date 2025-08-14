package sparsearray;

/*
    稀疏 sparsearray 数组
 */

public class SparseArray {

        /**
     * 主函数，演示稀疏数组的使用方法。
     * 该函数创建一个二维数组，将其转换为稀疏数组表示，
     * 然后再从稀疏数组恢复为原始二维数组并输出结果。
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {

        // 创建原始二维数组，并初始化部分元素
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[2][4] = 2;

        // 输出原始二维数组
        System.out.println("原始的二维数组>>>>>");
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }

        // 统计原始二维数组中非零元素个数
        int sum = 0;
        for (int[] row : chessArr1){
            for(int data : row){
                if(data != 0){
                    sum ++;
                }
            }
        }

        // 构造稀疏数组：第一行存储原数组行数、列数和非零元素总数
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        // 遍历原始数组，将非零元素的位置和值记录到稀疏数组中
        int count = 0;
        for(int i = 0; i < chessArr1.length; i++){
            for(int j = 0; j < chessArr1[i].length; j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println("稀疏数组>>>>>");
        for(int[] rows: sparseArr){
            System.out.println(rows[0] + "\t" + rows[1] + "\t" + rows[2]);
        }

        // 根据稀疏数组恢复原始二维数组
        int chessArr2[][] =
                new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1; i < sparseArr.length; i ++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]
                    = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println("恢复的二维数组>>>>>");
        for (int[] row : chessArr2){
            for(int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }

    }

}
