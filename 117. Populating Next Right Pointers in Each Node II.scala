/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/


Input:
{1,2,3,4,5,#,6,7,#,#,#,#,8}
Output:
{1,#,2,3,#,4,5,6,#,7,#}
Expected:
{1,#,2,3,#,4,5,6,#,7,8,#}


        1
       /  \
      2    3
     / \    \
    4   5    6
   /          \
  7            8


    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode nextLevelHead = null ;
        TreeLinkNode preNode = null ;
        TreeLinkNode node = root;
        while(node!=null){//Every Level
            while(node!=null){//this Level
                if(node.left!=null){//dealing with left;
                    if(preNode!=null) preNode.next=node.left;
                    else nextLevelHead = node.left;

                    preNode = node.left;
                }

                if(node.right!=null){//dealing with left;
                    if(preNode!=null) preNode.next=node.right;
                    else nextLevelHead = node.right;

                    preNode = node.right; 
                }
                node = node.next;
            }
            node = nextLevelHead;
            nextLevelHead = null;
            preNode = null;
        }
    }
