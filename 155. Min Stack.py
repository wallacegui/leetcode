class MinStack(object):

    data=[]
    min_data=[]
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data=[]
        self.min_data=[]

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.data.append(x)
        top_min = self.min_data[-1] if(len(self.min_data)>=1) else x
        self.min_data.append(min(x,top_min))

    def pop(self):
        """
        :rtype: void
        """
        self.data.pop()
        self.min_data.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_data[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
