/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> que=new LinkedList<>();
        Node clone=new Node(node.val);
        map.put(node,clone);
        que.add(node);
        while(!que.isEmpty()){
            Node curr=que.poll();
            for(Node neigh:curr.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh,new Node(neigh.val));
                    que.add(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }
        return clone;
    }
}