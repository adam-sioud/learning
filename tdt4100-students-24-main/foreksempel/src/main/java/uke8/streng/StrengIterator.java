package uke8.streng;

import java.util.Iterator;

public class StrengIterator implements Iterator<Character>{

    String s;
    int position = 0;

    public StrengIterator(String s) {
        this.s = s;
    }

    @Override
    public boolean hasNext() {
        return position < s.length() -1;
    }

    @Override
    public Character next() {
        position += 1;
        return s.charAt(position);
    }
    
}

