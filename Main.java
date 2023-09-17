import java.util.*;


class Main {


  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    System.out.println("Determinant Solver");
    int size = Integer.parseInt(in.nextLine());

    Random rand = new Random();
    double[][] matrix = new double[size][size];
    for(int i = 0; i < size; i++){

      for(int j = 0; j < size; j++){
        matrix[i][j] = rand.nextDouble() * (double)rand.nextInt(1000);
        System.out.print(" | " + matrix[i][j] + " | ");
      }
      System.out.println();
    }
    // double[][] matrix = {
    //   {1.0, 2.0, 6, 6},
    //   {4, 7, 3, 2},
    //   {0, 0, 0, 0},
    //   {1, 2, 2, 9}
    // };

    // double[][]matrix = {
    //   {1, 1, -5},
    //   {3, -1, 4},
    //   {-4, 4, 3}
    // };

    // double[][] matrix = {
    //   {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
    //   {4, 5.6, 7, 114, -4, 6, 9.1, 7.4, 2.4, 11},
    //   {6.32, 2.54, 9.78, 4.56, 12.3, 5, 7, 9, 19, 2.56},
    //   {9.23, 4, 5.3, 56.52082, -24.2, 2.3, -55, 4, -5, -9, -10},
    //   {4, 5, 6, 7, 8, 4, 2, 3, 5, 6},
    //   {5, 6, 7, 8, 9, 10, 1, 2, 3, 4},
    //   {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10},
    //   {23.4, 2.3, 2.4, 4.32, 32.4, 43.2, 8.9, -6, -2, -0.11},
    //   {10, 9, 8, 7, 6, 5, 3, 4, 2, 1},
    //   {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1},
    // };
    double f = 0;
    for(int i = 0; i < matrix[0].length; i++){
      System.out.println(((double)i)/(matrix[0].length - 1) * 100 + " percent complete");
      f += recurse(matrix, 0, i);
      //System.out.println("running: " + f);
    }
    System.out.println("determinant " + f);
    in.close();
  }

  public static double recurse(double[][] mat , int r, int c){
    double a = mat[r][c];
    // System.out.println("A " + a);
  

    double b = 0;
    a *= Math.pow(-1, r+c);
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
          // System.out.print(mat1[k][l] + " ");
        }else if(k > mat1.length){
          // System.out.println("ERR K "  + k);
        }else if (l > mat1.length){
          // System.out.println("ERR L "  + l);
        }
        //System.out.print(mat1[k][l] + " ");
        //System.out.print("L " + l);
        l++;
      }
      // System.out.println();
      k++;
    }
  
    // System.out.println();
    if(mat1.length <= 2){
      // System.out.println("B2 " + a * (mat1[0][0] * mat1[1][1] - mat1[1][0] * mat1[0][1]));
      return a * (mat1[0][0] * mat1[1][1] - mat1[1][0] * mat1[0][1]);
    }
    for(int i = 0; i < mat1[0].length && r < mat1[0].length; i++){
      // System.out.println("Running B " + b);
      b += recurse(mat1, r, i);    
    }
    // System.out.println("B" + b);
    return b;
  }
}