package com.jamesha.percolation.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   
	private int [][] open;
	private static int numberOfOpenSites;
	private WeightedQuickUnionUF wqu;
	private int gridSize;
	
	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		wqu = new WeightedQuickUnionUF(n * n + 2);
		open = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				open[i][j] = 0;
			}
		}

		numberOfOpenSites = n * n;
		gridSize = n;
		
		for (int i = 0; i < gridSize; i++) {
			wqu.union(0, i + 1);
			wqu.union(gridSize * gridSize + 1, gridSize * gridSize - i);
		}
	}

	// open site (row, col) if it is not open already
	public void open (int row, int col) {
		if (open[row-1][col-1] == 0) {
			open[row-1][col-1] = 1;
			numberOfOpenSites--;
		}
		
		if (row > 1 && isOpen(row - 1, col)) {
			wqu.union((row - 1) * gridSize + col, (row - 2) * gridSize + col);
		}
		
		if (row < gridSize && isOpen(row + 1, col)) {
			wqu.union((row - 1) * gridSize + col, (row) * gridSize + col);
		}
		
		if (col > 1 && isOpen(row, col - 1)) {
			wqu.union((row - 1) * gridSize + col, (row - 1) * gridSize + col - 1);
		}
		
		if (col < gridSize && isOpen(row, col + 1)) {
			wqu.union((row - 1) * gridSize + col, (row - 1) * gridSize + col + 1);
		}
		
	}
   
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return open[row-1][col-1] == 1;
	}
   
	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		return wqu.connected(0, (row - 1) * gridSize + col);
	}
   
	// number of open sites
	public static int numberOfOpenSites() {
		return numberOfOpenSites;
	}
   
	// number of open sites
	public boolean percolates() {
	   return wqu.connected(0, gridSize * gridSize + 1);
	}
	
	public static void main(final String[] args) {

		Percolation p = new Percolation(4);
		 p.open(4, 1);
		 p.open(3, 1);
		 p.open(2, 2);
		 p.open(1, 1);
		 p.open(1, 4);
		 p.open(2, 4);
		 System.out.println(p.wqu.connected(16, 8));
		 p.open(4, 4);
		 System.out.println(p.wqu.find(3));
        System.out.println("Does it percolates? " + p.percolates());

	}
}
