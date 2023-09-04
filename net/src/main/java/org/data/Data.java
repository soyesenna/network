package org.data;

public interface Data<T> {

    boolean removeData();
    boolean createData(T data);

    T getData();
}
