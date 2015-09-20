package com.evolve.data;

import java.util.Random;

/**
 * Created by Dylan on 17/09/2015.
 */
public interface DataConstruct <P> {

    final Random random = new Random();

    public P getData();

    public P getData(int i);

    public void addData(int entryNum, P data);

    public String[] getColumnHeadings();

}
