#Tree traverse
class TreeNode():
    def __init__(self,x):
        self.val = x
        self.left,self.right = None,None

class Solution:
    def __init__(self):
        self.traverse_path = []
    def preorder(self,root):
        #if not root: return []
        if root:
            self.traverse_path.append(root.val)
            self.preorder(root.left)
            self.preorder(root.right)
    def inorder(self,root):
        if root:
            self.inorder(root.left)
            self.traverse_path.append(root.val)
            self.inorder(root.right)
    def postorder(self,root):
        if root:
            self.postorder(root.left)
            self.postorder(root.right)
            self.traverse_path.append(root.val)

if __name__ == '__main__':
    #          5
    #        3   7
    #      1  4 6  9
    a_tree = TreeNode(5)
    a_tree.left = TreeNode(3)
    a_tree.right = TreeNode(7)
    a_tree.left.left = TreeNode(1)
    a_tree.left.right = TreeNode(4)
    a_tree.right.left = TreeNode(6)
    a_tree.right.right = TreeNode(9)

    s = Solution()
    s.postorder(a_tree)
    print(s.traverse_path)