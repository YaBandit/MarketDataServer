package com.evolve.data;

/**
 * Created by Dylan on 17/09/2015.
 */
public interface DataConstruct <E, A> {

    public E getData();

    public E getData(int i);

    public A addData(A a);

}
