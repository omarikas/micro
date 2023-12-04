package main;

public class instruction {
    optype type;
    String destination;
    String source1;
    String source2;
    public int immediate;
    public int issue=0;
    public int writeres=0;
    int[] exec;
    int exectime;

    public instruction(optype type, String destination, String source1, String source2,int exectime) {
        this.type = type;
        this.destination = destination;
        this.source1 = source1;
        this.source2 = source2;
        this.exec=new int[2];
        this.exectime=exectime;
       
    }

    public instruction(optype type, String destination, String source1, int immediate, int exectime) {
        this.type = type;
        this.destination = destination;
        this.source1 = source1;
       this.immediate=immediate;
       this.exec=new int[2];
       this.exectime=exectime;
       
    }
    
}