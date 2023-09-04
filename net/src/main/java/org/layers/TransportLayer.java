package org.layers;

import org.data.Packet;

public class TransportLayer implements Layer{

    private boolean flag;
    private Packet packet;

    public TransportLayer(boolean flag, Packet packet) {
        this.flag = flag;
        this.packet = packet;
    }

    @Override
    public Layer capsulize() {
        if (packet == null) return null;
        String header = "TransportLayer Header";
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
        if (flag) return new NetworkLayer(flag, packet);
        return new SessionLayer(flag, packet);
    }

    @Override
    public Packet getPacket() {
        return packet;
    }
}
