public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int col0=1;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        col0=0;
                    }
                }
            }
        }

        // Triversing
        for(int i=1;i<row;row++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        //  Now First Row and Col
        if(matrix[0][0]==0){
            for(int i=0;i<col;i++){
                matrix[0][i]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }

        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
}