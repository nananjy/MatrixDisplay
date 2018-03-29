package MatrixDisplay;

/**
 * 递归实现矩阵输出
 * @author 作者名
 */
public class MatrixDisplay {

	/**
	 * @param matrix 存放螺旋矩阵
	 * @param x 第一个元素的x坐标
	 * @param y 第一个元素的y坐标
	 * @param start 第一个元素的值
	 * @param n 矩阵的大小(0<n<50)
	 */
	public void matrixDisplay(int matrix[][], int x, int y, int start, int n) {
		int i;//存放数组下标
		if (n <= 0 || n >= 50) {
			System.out.println("矩阵大小不符合要求，返回");
			return;
		}
		if (n == 1) {
			matrix[x][y] = start;
			return;
		}
		//1 存放上边
		for (i = y; i < y + n -1; i++) {
			matrix[x][i] = start++;
		}
		//2 存放右边
		for (i = x; i < x + n -1; i++) {
			matrix[i][y +n-1] = start++;
		}
		//3 存放下边
		for (i = y + n -1 ; i > y; i--) {
			matrix[x +n-1][i] = start++;
		}
		//4 存放左边
		for (i = x + n -1; i > x; i--) {
			matrix[i][y] = start++;
		}
		//5 递归执行
		matrixDisplay(matrix, x +1, y +1, start, n -2);
	}
	
	public static void main(String[] args) {
		int n = 6;
		int matrix[][] = new int[n][n];
		MatrixDisplay matrixDisplay = new MatrixDisplay();
		matrixDisplay.matrixDisplay(matrix, 0, 0, 1, n);
		//输出结果
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
