package sj.backtrack;

/**
 * Created by steven on 18-4-1 上午11:37
 * shijia0620@126.com
 *
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class N_MatrixhasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        char[][] matrixs = transToMatrix(matrix,rows,cols);
        boolean[][] flagMatrix = new boolean[rows][cols];
        for(int row = 0; row<rows;row++){
            for(int col = 0; col<cols; col++){
                if(isMatch(matrixs,flagMatrix,row,col,str,0))
                    return true;
            }
        }
        return false;
    }

    public boolean isMatch(char[][] matrix,boolean[][] flag,int row, int col,char[] str,int index){
        //todo 必须先检查其合法性
        if(row<0 || row>=matrix.length || col<0 || col>=matrix[0].length || index>=str.length || flag[row][col]) return false;
        if(matrix[row][col]==str[index] && index==str.length-1) return true;
        if(matrix[row][col] != str[index]) return false;
        else {
            flag[row][col] = true;
            boolean flagUp=false,flagDown=false,flagLeft=false,flagRight=false;
            flagUp = isMatch(matrix,flag,row-1,col,str,index+1);
            flagDown = isMatch(matrix,flag,row+1,col,str,index+1);
            flagLeft = isMatch(matrix,flag,row,col-1,str,index+1);
            flagRight = isMatch(matrix,flag,row,col+1,str,index+1);
            flag[row][col] = false;
            return (flagDown || flagUp || flagLeft || flagRight);
        }
    }
    public char[][] transToMatrix(char[] string, int rows, int cols){
        char[][] matrix = new char[rows][cols];
        int count = 0;
        for(int row = 0; row<rows; row++){
            for (int col = 0; col<cols; col++){
                matrix[row][col] = string[count++];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        N_MatrixhasPath a = new N_MatrixhasPath();
        System.out.println(a.hasPath("ABCESFCSADEE".toCharArray(),3,4,"SEE".toCharArray() ));
    }
}
