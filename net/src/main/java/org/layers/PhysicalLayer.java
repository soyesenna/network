package org.layers;

import org.data.Packet;

public class PhysicalLayer implements Layer{

    private boolean flag;
    private Packet packet;

    public PhysicalLayer(boolean flag, Packet packet) {
        this.flag = flag;
        this.packet = packet;
    }

    @Override
    public Layer capsulize() {
        return this;
    }

    @Override
    public Layer decapsulize() {
        return this;
    }

    @Override
    public Layer callNextLayer() {
        if (flag) return this;
        return new DataLinkLayer(flag, packet);
    }

    @Override
    public Packet getPacket() {
        return packet;
    }

}
