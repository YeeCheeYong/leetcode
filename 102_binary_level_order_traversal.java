public List<List<Integer>> levelOrder(TreeNode root) {
List<List<Integer>> newlist=new ArrayList<>();    //create newlist to be returned
Queue<TreeNode>q=new LinkedList<>();    
if(root==null)return newlist;
q.offer(root);    //insert root into queue
while(!q.isEmpty())
{
    int s=q.size();    //();//save each row’s queue size into variable; after 1st row (root), size will become subsequent row’s no of nodes by incrementing size by no of childs (null or not)
    List<Integer>templist=new ArrayList<>();    //list to be added into new list
    int i=0;
    while(i<s)
    {
        TreeNode x=q.poll();    //remove item (FIFO)
        templist.add(x.val);    //add removed item from queue into templist
        if(x.left!=null)
        q.add(x.left);    //add removed item’s left child into templist
        if(x.right!=null)
        q.add(x.right);    //add removed item’s right child into templist
        i++;
    }
    newlist.add(templist);    //add templist to newlist
}
return newlist;

}
