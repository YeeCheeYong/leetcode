public List<List<Integer>> levelOrder(TreeNode root) {
List<List<Integer>> newlist=new ArrayList<>();
Queue<TreeNode>q=new LinkedList<>();
if(root==null)return newlist;
q.offer(root);
while(!q.isEmpty())
{
    int s=q.size();
    List<Integer>templist=new ArrayList<>();
    int i=0;
    while(i<s)
    {
        TreeNode x=q.poll();
        templist.add(x.val);
        if(x.left!=null)
        q.add(x.left);
        if(x.right!=null)
        q.add(x.right);
        i++;
    }
    newlist.add(templist);
}
return newlist;

}
