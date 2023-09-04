package org.layers;

import org.data.Packet;

public interface Layer {
    Layer capsulize();
    Layer decapsulize();
    Layer callNextLayer();
    Packet getPacket();
}
