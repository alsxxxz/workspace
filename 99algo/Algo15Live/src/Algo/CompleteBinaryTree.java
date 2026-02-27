import java.util.*;
///스택2

public class CompleteBinaryTree<T> {

    private Object[] nodes;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int size){
        SIZE = size;
        nodes = new Object[size+1];
    }

    public boolean isEmpty(){
        return lastIndex == 0;
    }
    public boolean isFull(){
        return lastIndex == SIZE;
    }
    public void add(T e){
        if(isFull()) throw new RuntimeException("포화상태입니다.");

        nodes[++lastIndex] = e;

    }
///큐는 링크드리스트보다 어레이댁쓰는게 유리하다 
    public void bfs(){
        //탐색 대상의 순서를 관리할 큐 생성
        Queue<Integer> queue = new ArrayDeque<Integer>();
        //첫번째로 탐색할 대상 큐에 넣기
        queue.offer(1);
        //탐색 대상이 있으면 반복
        while(!queue.isEmpty()){
             //탐색 대상 알아내기
             int current = queue.poll();
            //탐색
            System.out.println(nodes[current]);
            //탐색대상의 자식 노드 체크해서 후에 탐색이 되도록 큐에 넣기
            if(current*2<=lastIndex) queue.offer(current*2);
            if(current*2+1<=lastIndex) queue.offer(current*2+1);
    }
        }
    public void bfs2(){
        //너비(레벨)도 알 수 있게 

        //탐색 대상의 순서를 관리할 큐 생성
        Queue<int[]> queue = new ArrayDeque<int[]>();

        //첫번째로 탐색할 대상 큐에 넣기
        queue.offer(new int[] {1,0});

        //탐색 대상이 있으면 반복
        while(!queue.isEmpty()){
             //탐색 대상 알아내기
             int info[] = queue.poll();
             int current = info[0];
             int breadth =  info[1];
            //탐색
            System.out.println(nodes[current]+"/"+breadth);
            //탐색대상의 자식 노드 체크해서 후에 탐색이 되도록 큐에 넣기
            if(current*2 <= lastIndex)
            queue.offer(new int[] {current*2, breadth+1});
            if(current*2+1 <= lastIndex)
            queue.offer(new int[] {current*2+1, breadth+1});
    }
        }

    public void bfs3(){
        //너비(레벨)도 알 수 있게 
        if(isEmpty()) return;
        int breadth =  0;
        //탐색 대상의 순서를 관리할 큐 생성
        Queue<Integer> queue = new ArrayDeque<Integer>();
        //첫번째로 탐색할 대상 큐에 넣기
        queue.offer(1);


        //탐색 대상이 있으면 반복
        while(!queue.isEmpty()){
            int size = queue.size(); //queue에서 꺼내기 전에 size check

             //탐색 대상 알아내기
             while(--size>=0){//왜 lenhth말고 size로 할지 생각해보기
                int current = queue.poll();
             
            //탐색
            System.out.println(nodes[current]+"/"+breadth);
            //탐색대상의 자식 노드 체크해서 후에 탐색이 되도록 큐에 넣기
            if(current*2 <= lastIndex)
                queue.offer((current*2));
            if(current*2+1 <= lastIndex)
               queue.offer(current*2+1); //breadth는 어디 -> 밑 ++
            
    }
    ++breadth;
        }
}


public void dfsByPreOrder0(int current) {
if(current>lastIndex) return;

    System.out.println(nodes[current]);
    dfsByPreOrder0(current*2);
    dfsByPreOrder0(current*2+1);
}

//current 노드를 루트로 하는 깊이 우선 트리탐색
public void dfsByPreOrder(int current) {
    //현재 노드 탐색
    System.out.println(nodes[current]);
    //현재 노드의 자식 노드 탐색
    if(current*2<lastIndex) dfsByPreOrder(current*2);
    if(current*2+1<lastIndex) dfsByPreOrder(current*2);
}


// current 4
public void dfsByInOrder(int current) {

if(current*2 <= lastIndex) dfsByInOrder(current*2);

System.out.println(nodes[current]);
if(current*2+1 <= lastIndex) dfsByInOrder(current*2+1);

}

// current 4e
public void dfsByPostOrder(int current) {

if(current*2 <= lastIndex) dfsByPostOrder(current*2);
if(current*2+1 <= lastIndex) dfsByPostOrder(current*2+1);

System.out.println(nodes[current]);

}
}