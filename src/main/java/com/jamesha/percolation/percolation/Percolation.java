package com.jamesha.percolation.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   
	int [][] grid;
	
	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
	   grid = new int[n][n];
	}
   
	// open site (row, col) if it is not open already
	public void open (int row, int col) {
	   grid[row][col] = 1;
	}
   
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		if (grid[row][col] == 1) {
			return true;
		}
		
		return false;
	}
   
	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		return true;
	}
   
	// number of open sites
	public int numberOfOpenSites() {
		return 0;
	}
   
	// number of open sites
	public boolean percolates() {
	   return true;
	}
}
