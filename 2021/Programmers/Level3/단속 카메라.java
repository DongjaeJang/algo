package boj_self;

import java.io.*;
import java.util.*;

class Programmers {
    public class Position implements Comparable<Position> {
        int a, b;
        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Position o) {
            if (this.b == o.b) return this.a - o.a;
            return this.b - o.b;
        }
    }
    
    public int solution(int[][] routes) {
        int answer = 1;
        
        PriorityQueue<Position> list = new PriorityQueue<>();
        for (int[] route : routes) {
            list.add(new Position(route[0], route[1]));
        }
    
        
        Position prev = list.poll();
        while (list.size() != 0) {
            Position current = list.poll();
            if (prev.b < current.a) {
                prev = current;
                answer++;
            }
        }
        
        return answer;
    }
}