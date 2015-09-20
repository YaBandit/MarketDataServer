package com.evolve.data;

import java.util.Random;

/**
 * Created by Dylan on 17/09/2015.
 */
public interface DataConstruct <E> {

    final Random random = new Random();

    public E getData();

    public E getData(int i);

    public void addData(int entryNum, E data);

    public String[] getColumnHeadings();

}
