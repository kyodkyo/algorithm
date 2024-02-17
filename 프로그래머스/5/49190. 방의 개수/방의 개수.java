import java.util.*;

class Solution {
    public static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o){
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node) o;
            return (x==node.x && y==node.y);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }
    
    public int solution(int[] arrows) {
        int answer = 0;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        
        Node cur = new Node(0, 0);
        Map<Node, List<Node>> visited = new HashMap<>();
        
        for(int arrow : arrows){
            for(int i=0; i<=1; i++){
                Node next = new Node(cur.x + dx[arrow], cur.y + dy[arrow]);
                
                if (!visited.containsKey(next)){
                    visited.put(next, makeList(cur));
                    
                    if (visited.get(cur) == null)
                        visited.put(cur, makeList(next));
                    else
                        visited.get(cur).add(next);
                }
                else if (!visited.get(next).contains(cur)){
                    visited.get(next).add(cur);
                    visited.get(cur).add(next);
                    answer++;
                }
                cur = next;
            }    
        }
        
        return answer;
    }
    
    public static List<Node> makeList(Node node){
        List<Node> edge = new ArrayList<>();
        edge.add(node);
        return edge;
    }
}