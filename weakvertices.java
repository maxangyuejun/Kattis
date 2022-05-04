import java.util.*;
import java.io.*;

public class weakvertices {
	public static void main (String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);
		while (io.hasMoreTokens()) {
        int numVertices = io.getInt();
        while (numVertices != -1) {
        	int[][] matrix = new int[numVertices][numVertices];
        	boolean[] triangleCheck = new boolean[numVertices];

        	for (int row=0; row<numVertices; row++) {
        		for (int col=0; col<numVertices; col++) {
        			matrix[row][col] = io.getInt();
        		}
        	}
        	
        	for (int r=0; r<numVertices; r++) {
        		for (int c=0; c<numVertices; c++) {
        			if (matrix[r][c] == 1) {
        				for (int a=c+1; a<numVertices; a++) {
        					if (matrix[r][a] == 1) {
        						if (matrix[c][a] == 1) {
        							triangleCheck[r] = true; 
        						}
        					}
        				}
        			}
        			if (triangleCheck[r] == true) {
        				break;
        			}
        		}
        	}

        	for (int i=0; i<numVertices; i++) {
        		if (triangleCheck[i] == false) {
        			io.print(i + " ");
        		}
        	}

        	io.println();
        	numVertices = io.getInt();
        }

        io.close();
	}
}