package org.layers;

import org.data.Packet;

public class DataLinkLayer implements Layer{
    //true -> 송신, false -> 수신
    private boolean flag;
    private Packet packet;

    public DataLinkLayer(boolean flag, Packet packet) {
        this.flag = flag;
        this.packet = packet;
    }

    @Override
    public Layer capsulize() {
        String header = "DataLinkLayer Header";
        String trailer = "DataLinkLayer Trailer";
        packet.capsulize(header);
        packet.addTrailer(trailer);
        return this;
    }

    @Override
    public Layer decapsulize() {
        if (packet == null) return null;
        packet.decapsulize();
        packet.removeTrailer();
        return this;
    }

    @Override
    public Layer callNextLayer() {
        if (flag) return new PhysicalLayer(flag, packet);
        return new NetworkLayer(flag, packet);
    }

    @Override
    public Packet getPacket() {
        return packet;
    }
}
