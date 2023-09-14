import java.util.*;


class Main {


  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    System.out.println("Hello world!");
    int size = Integer.parseInt(in.nextLine());

    // //double[][] matrix = {
    //   {1.0, 2.0, 6, 6},
    //   {4, 7, 3, 2},
    //   {0, 0, 0, 0},
    //   {1, 2, 2, 9}
    // };

    double[][]matrix = {
      {1, -1, 0},
      {2, 3, 4},
      {0, 1, 2}
    };
    double f = 0;
    for(int i = 0; i < matrix[0].length; i++){
      System.out.println(i);
      f += recurse(matrix, 0, i);
    }
    System.out.println(f);
    in.close();
  }

  public static double recurse(double[][] mat , int r, int c){
    double a = mat[r][c];
    System.out.println("A " + a);
  

    double b = 0;
    a *= Math.pow(-1, r+c);
    for(int i = 1; i < mat[0].length; i++){
      for(int j = 1; j < mat[0].length; j++){
        b += a * mat[i][j];
      }
    }
    double[][] mat1 = new double[mat[0].length - 1][mat[0].length - 1];
    int k = 0;
    for(int i = 0; i < mat[0].length; i++){
      if(i == r){
        i ++;
      }
      int l = 0;
      for(int j = 0; j < mat[0].length; j++){
        if(j == c){
          j++;
        }
        if(k < mat1.length && l < mat1.length){
          mat1[k][l] = mat[i][j]; 
          System.out.print(mat1[k][l] + " ");
        }else if(k > mat1.length){
          System.out.println("ERR K "  + k);
        }else if (l > mat1.length){
          System.out.println("ERR L "  + l);
        }
        //System.out.print(mat1[k][l] + " ");
        //System.out.print("L " + l);
        l++;
      }
      System.out.println();
      k++;
    }
  
    System.out.println();
    if(mat1.length <= 2){
      return a * (mat[0][0] * mat[0][1] - mat[1][0] * mat[1][1]);
    }
    for(int i = 0; i < mat1[0].length && r < mat1[0].length; i++){
      b += recurse(mat1, r, i);    
    }

    return b;
  }
}