package org.data;

import java.util.List;

public interface Packet {

    Packet capsulize(String head);
    Packet createPacket(Data data);
    Packet decapsulize();
    Packet addTrailer(String trailer);
    Object getData();
    List getHeader();
    String getTrailer();
    Packet removeTrailer();
}
