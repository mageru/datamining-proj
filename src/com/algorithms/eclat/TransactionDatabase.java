package com.algorithms.eclat;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a transaction database 
 */
public class TransactionDatabase {

    // The list of items in this database
    private final Set<Integer> items = new HashSet<Integer>();
    // the list of transactions
    private final List<List<Integer>> transactions = new ArrayList<List<Integer>>();

    /**
     * Method to add a new transaction to this database.
     *
     * @param transaction the transaction to be added
     */
    public void addTransaction(List<Integer> transaction) {
        transactions.add(transaction);
        items.addAll(transaction);
    }

    /**
     * Method to load a file containing a transaction database into memory
     *
     * @param path the path of the file
     * @throws java.io.IOException exception if error reading the file
     */
    public void loadFile(String path) throws IOException {
        String thisLine; // variable to read each line
        BufferedReader myInput = null; // object to read the file
        try {
            FileInputStream fin = new FileInputStream(new File(path));
            myInput = new BufferedReader(new InputStreamReader(fin));
            // for each line
            while ((thisLine = myInput.readLine()) != null) {
                // if the line is not a comment, is not empty or is not other
                // kind of metadata
                if (thisLine.isEmpty() == false &&
                        thisLine.charAt(0) != '#' && thisLine.charAt(0) != '%'
                        && thisLine.charAt(0) != '@') {
                    // split the line according to spaces and then
                    // call "addTransaction" to process this line.
                    addTransaction(thisLine.split(" "));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (myInput != null) {
                myInput.close();
            }
        }
    }

    private void addTransaction(String itemsString[]) {
        // create an empty transaction
        List<Integer> itemset = new ArrayList<Integer>();
        // for each item in this line
        for (String attribute : itemsString) {
            // convert from string to int
        	int item = Integer.parseInt(attribute);
        	//int item = Integer.parseInt(attribute);
            // add the item to the current transaction
            itemset.add(item);
            // add the item to the set of all items in this database
            items.add(item);
        }
        // add the transactions to the list of all transactions in this database.
        transactions.add(itemset);
    }

    /**
     * Method to print the content of the transaction database to the console.
     */
    public void printDatabase() {
        System.out
                .println("===================  TRANSACTION DATABASE ===================");
        int count = 0;
        // for each transaction
        for (List<Integer> itemset : transactions) { // pour chaque objet
            System.out.print("0" + count + ":  ");
            print(itemset); // print the transaction
            System.out.println("");
            count++;
        }
    }

    /**
     * Method to print a transaction to System.out.
     *
     * @param itemset a transaction
     */
    private void print(List<Integer> itemset) {
        StringBuffer r = new StringBuffer();
        // for each item in this transaction
        for (Integer item : itemset) {
            // append the item to the stringbuffer
            r.append(item.toString());
            r.append(' ');
        }
        System.out.println(r); // print to System.out
    }

    /**
     * Get the number of transactions in this transaction database.
     *
     * @return the number of transactions.
     */
    public int size() {
        return transactions.size();
    }

    /**
     * Get the list of transactions in this database
     *
     * @return A list of transactions (a transaction is a list of Integer).
     */
    public List<List<Integer>> getTransactions() {
        return transactions;
    }

    /**
     * Get the set of items contained in this database.
     *
     * @return The set of items.
     */
    public Set<Integer> getItems() {
        return items;
    }
}