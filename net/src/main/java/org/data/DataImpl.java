package org.data;

public class DataImpl<T> implements Data<T>{

    private T data = null;

    public DataImpl(T data) {
        this.data = data;
    }

    @Override
    public boolean removeData() {
        if (this.data == null) return false;
        this.data = null;
        return true;
    }

    @Override
    public boolean createData(T data) {
        if (data == null) return false;
        if (this.data != null) return false;

        this.data = data;
        return true;
    }

    @Override
    public T getData() {
        return data;
    }


}
