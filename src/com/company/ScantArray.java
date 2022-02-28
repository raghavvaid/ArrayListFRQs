package com.company;

import java.util.ArrayList;


public class ScantArray {
    /** number of rows and columns in the list */
    private int numRows;
    private int numColumns;

    /** The list of entries representing the non-zero elements of
     * the scant array.  Entries are stored in no particular order.
     */
    private ArrayList<ScantArrayEntry> entries;

    /** constructor */
    public ScantArray(int r, int c){
        numRows = r;
        numColumns = c;
        entries = new ArrayList<ScantArrayEntry>();
    }


    public int getNumRows(){return numRows;}
    public int getNumColumns(){return numColumns;}


    public void addEntry(int row, int col, int val) {
        entries.add(new ScantArrayEntry(row, col, val));
    }

    public int getValueAt(int row, int col){
        int end = 0;
        for (int i = 0; i < entries.size(); i++){
            if (entries.get(i).getRow() == row && entries.get(i).getColumn() == col){
                end = entries.get(i).getValue();
            }
        }
        return end;
    }

    /** Removes a column from the scant array and shifts
     * columns to the right of col one column to the left.
     * (see description in word doc.
     * @param col
     * Precondition:  0 <= col < getNumColumns()
     */
    public void removeColumn(int col){
        int counter = 0;
        while (counter < entries.size()) {
            if (entries.get(counter).getColumn() == col){
                entries.remove(counter);
            }
            else if (entries.get(counter).getColumn() > col){
                entries.set(counter, new ScantArrayEntry(entries.get(counter).getRow(),
                        entries.get(counter).getColumn()-1, entries.get(counter).getValue()));
                counter++;
            }
            else counter++;
        }
        numColumns--;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numColumns; j++){
                s += getValueAt(i,j) + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args){
        ScantArray sa1 = new ScantArray(4,5);
        sa1.addEntry(1,4,4);
        sa1.addEntry(2,0,1);
        sa1.addEntry(3,1,-9);
        sa1.addEntry(1,1,5);

        System.out.println(sa1.getValueAt(2,0));
        System.out.println(sa1.getValueAt(3,1));
        System.out.println(sa1.getValueAt(2,3));
        System.out.println("rows "+ sa1.getNumRows());
        System.out.println("columns "+ sa1.getNumColumns());

        System.out.println(sa1);

        sa1.removeColumn(1);
        System.out.println(sa1);

        /******* please add one more test of your own *******/

        ScantArray sa2 = new ScantArray(3,4);
        sa2.addEntry(3,2,3);
        sa2.addEntry(0,1,10);
        sa2.addEntry(2,4,-2);
        sa2.addEntry(1,3,8);

        System.out.println(sa2.getValueAt(0,0));
        System.out.println(sa2.getValueAt(2,1));
        System.out.println(sa2.getValueAt(1,0));
        System.out.println("rows "+ sa2.getNumRows());
        System.out.println("columns "+ sa2.getNumColumns());

        System.out.println(sa2);

        sa2.removeColumn(1);
        System.out.println(sa2);
    }
}