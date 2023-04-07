package com.example.oop12.structures;

public class Range {
    private int start;
    private int end;
    public Range(int start, int end){
        this.start=start;
        this.end=end;
    }
    public Range(){
        this.start = 0;
        this.end = 0;
    }
    public boolean contains(int value){
        return (value>=start && value<=end);
    }
}