package com.algorithms.eclat;


import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;


public class Itemset {
    /**
     * the items
     */
    public Set<Integer> itemset = new HashSet<Integer>();
    /**
     * the list of transaction/sequence ids containing this itemset
     */
    public Set<Integer> tidset = new HashSet<Integer>();

    /**
     * Get this itemset as a string.
     */
    public String toString() {
        StringBuffer r = new StringBuffer();
        for (Integer attribute : itemset) {

            r.append(attribute.toString());

            r.append(' ');
        }
        return r.toString();
    }

    /**
     * print this itemset to System.out.
     */
    public void print() {
        System.out.print(toString());
    }

    /**
     * Get the relative support of this itemset as a string
     *
     * @param nbObject the number of transactions in the database where this itemset was found
     * @return the relative support of the itemset as a string
     */
    public String getRelativeSupportAsString(int nbObject) {
        // get the relative support
        double frequence = getRelativeSupport(nbObject);
        // convert it to a string with two decimals
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(5);
        return format.format(frequence);
    }

    /**
     * Get the relative support of this itemset
     *
     * @param nbObject the number of transactions/sequences in the database where the itemset was found
     * @return the relative support as a double (percentage)
     */
    public double getRelativeSupport(int nbObject) {
        return ((double) tidset.size()) / ((double) nbObject);
    }

    /**
     * Get the support of this itemset
     *
     * @return the support of this itemset
     */
    public int getAbsoluteSupport() {
        return tidset.size();
    }

    /**
     * Get the number of items in this itemset
     *
     * @return the size of this itemset
     */
    public int size() {
        return itemset.size();
    }

    /**
     * Check if this itemset contains a given item
     *
     * @param item the given item
     * @return true if contained
     */
    public boolean contains(Integer item) {
        return itemset.contains(item);
    }

    /**
     * This method returns the set of items in this itemset.
     *
     * @return A set of Integers.
     */
    public Set<Integer> getItems() {
        return itemset;
    }

    /**
     * This class returns a new itemset that is the union of this itemset
     * and another given itemset.
     *
     * @param itemset a given itemset.
     * @return the union.
     */
    public Itemset union(Itemset itemset) {
        Itemset union = new Itemset();
        union.getItems().addAll(getItems());
        union.getItems().addAll(itemset.getItems());
        return union;
    }

    /**
     * Add an item to that itemset.
     *
     * @param item an item (Integer)
     */
    public void addItem(Integer item) {
        getItems().add(item);
    }

    /**
     * Set the tidset of this itemset
     *
     * @param tidset a set of Integers
     */
    public void setTidset(Set<Integer> tidset) {
        this.tidset = tidset;
    }

    /**
     * Get the set of transaction IDs.
     *
     * @return a Set of Integer
     */
    public Set<Integer> getTidset() {
        return this.tidset;
    }

}
