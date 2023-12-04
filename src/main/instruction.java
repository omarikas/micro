package main;

public class instruction {
   optype type;
    String destination;
    String source1;
    String source2;
    int immediate;

    public instruction(optype type, String destination, String source1, String source2, int immediate) {
        this.type = type;
        this.destination = destination;
        this.source1 = source1;
        this.source2 = source2;
        this.immediate = immediate;
    }
}