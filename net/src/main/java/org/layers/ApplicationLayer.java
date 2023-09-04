package org.layers;

import org.data.Packet;

public class ApplicationLayer implements Layer{

    private Packet packet;
    private boolean flag;

    public ApplicationLayer(boolean flag, Packet packet) {
        this.packet = packet;
        this.flag = flag;
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
        if (flag) return new PresentationLayer(flag, packet);
        return this;
    }

    @Override
    public Packet getPacket() {
        return packet;
    }
}
