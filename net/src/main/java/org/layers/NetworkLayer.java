package org.layers;

import org.data.Packet;

public class NetworkLayer implements Layer{

    private boolean flag;
    private Packet packet;

    public NetworkLayer(boolean flag, Packet packet) {
        this.flag = flag;
        this.packet = packet;
    }

    @Override
    public Layer capsulize() {
        String header = "NetworkLayer Header";
        if (packet == null) return null;
        packet.capsulize(header);
        return this;
    }

    @Override
    public Layer decapsulize() {
        if (packet == null) return null;
        packet.decapsulize();
        return this;
    }

    @Override
    public Layer callNextLayer() {
        if (flag) return new DataLinkLayer(flag, packet);
        return new TransportLayer(flag, packet);
    }

    @Override
    public Packet getPacket() {
        return packet;
    }
}
