package org.data;

import java.util.ArrayList;
import java.util.List;

public class PacketImpl implements Packet{

    List<String> headers = new ArrayList<>();
    String trailer = "";
    Data data;

    public PacketImpl(Data data) {
        this.data = data;
    }

    @Override
    public Packet capsulize(String head) {
        if (head.isEmpty()) return null;
        headers.add(head);

        return this;
    }

    @Override
    public Packet createPacket(Data data) {
        if (data == null) return null;
        this.data = data;

        return this;
    }

    @Override
    public Packet decapsulize() {
        headers.remove(headers.size() - 1);
        return this;
    }

    @Override
    public Packet addTrailer(String trailer) {
        if (trailer.isEmpty()) return null;
        this.trailer = trailer;
        return this;
    }

    @Override
    public Object getData() {
        return data.getData();
    }

    @Override
    public List getHeader() {
        return headers;
    }

    @Override
    public String getTrailer() {
        return trailer;
    }

    @Override
    public Packet removeTrailer() {
        trailer = "";
        return this;
    }


}
