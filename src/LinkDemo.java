/**
 * Created by ThinkPad on 2016/3/28.
 */
class Link{
    private class Node{
        private String data;
        private Node next;
        public Node(String data){
            this.data = data;
        }
        public  void addNode(Node newNode){
            if(this.next == null){
                this.next = newNode;
            }else{
                this.next.addNode(newNode);
            }
        }
        //第一次调用（link）this = Link.root
        //第二次调用（Node） this = Link.root.next
        public boolean containsNode(String data){
            if(data.equals(this.data)){                 //当前节点数据为要查询的数据
                return true;
            }else{              //当前节点数据不满足查询的数据
                if(this.next != null){
                    return this.next.containsNode(data);
                }else{          //没有查询结果
                    return  false;
                }
            }
        }
    }

    private  Node root;//需要跟节点
    private int count = 0;
    public void add(String data){
        if(data == null){
            return;
        }
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.count ++;
    }
    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public boolean contains(String data){
        //现在没有要查询的数据，根节点也没有保存数据
        if(data == null || this.root == null){
            return false;           //没有查询结果
        }
        return this.root.containsNode(data);
    }
}
public class LinkDemo {
    public static void main(String[] args){
        Link all = new Link();
        //System.out.println(all.isEmpty());
        all.add("Hello");
        all.add("World");
        /*all.add(null);
        System.out.println(all.size());
        System.out.println(all.isEmpty());*/
        System.out.println("---111--"+all.contains("Hello"));
        System.out.println(all.contains("ayou"));
    }
}
