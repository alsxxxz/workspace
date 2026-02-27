public class CompleteBinaryTreeTest{
    public static void main(String[] args) {
        String[] names =
        {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        CompleteBinaryTree<String> tree = new CompleteBinaryTree<>(names.length);

        for (String n: names){
            tree.add(n);     
        }
        tree.bfs2();

        System.out.println("dfs");
        tree.dfsByPreOrder(1);
    }

}
           
 