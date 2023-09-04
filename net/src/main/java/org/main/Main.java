package org.main;

import org.data.DataImpl;
import org.data.Packet;
import org.data.PacketImpl;
import org.layers.ApplicationLayer;
import org.layers.Layer;
import org.layers.PhysicalLayer;

public class Main {
    public static void main(String[] args) {
        Layer send = new ApplicationLayer(true, new PacketImpl(new DataImpl<String>("mydata")));
        Layer sendResult = send.capsulize()
                                .callNextLayer()
                                .capsulize()    //Presentation Layer
                                .callNextLayer()
                                .capsulize()    //Session Layer
                                .callNextLayer()
                                .capsulize()    //Transport Layer
                                .callNextLayer()
                                .capsulize()    //Network Layer
                                .callNextLayer()
                                .capsulize()    //DataLink Layer
                                .callNextLayer()
                                .capsulize()    //Physical Layer
                                .callNextLayer();

        System.out.println(sendResult.getPacket().getData());
        System.out.println(sendResult.getPacket().getHeader());
        System.out.println(sendResult.getPacket().getTrailer());

        System.out.println();
        System.out.println();

        Layer arrive = new PhysicalLayer(false, sendResult.getPacket());
        Layer arriveResult = arrive.decapsulize()
                                    .callNextLayer()
                                    .decapsulize()  //DataLink Layer
                                    .callNextLayer()
                                    .decapsulize()  //NetWork Layer
                                    .callNextLayer()
                                    .decapsulize()  //Transport Layer
                                    .callNextLayer()
                                    .decapsulize()  //Session Layer
                                    .callNextLayer()
                                    .decapsulize()  //Presentation Layer
                                    .callNextLayer()
                                    .decapsulize()  //Application Layer
                                    .callNextLayer();

        System.out.println(sendResult.getPacket().getData());
        System.out.println(sendResult.getPacket().getHeader());
        System.out.println(sendResult.getPacket().getTrailer());
    }
}
