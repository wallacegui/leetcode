class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        if path is None :
            return ''
        res = []
        path_splited = path.split('/')
        for p in path_splited:
            if not (p == '' or p =='.'):
                if p == '..':
                    if len(res)>0:
                        del res[-1]
                else :
                    res.append(p)
        return '/' + '/'.join(res)
                
