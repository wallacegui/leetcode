class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        while len(version1)>0 and len(version2)>0:
            i,j=0,0
            while i<len(version1) and version1[i]!='.':
                i+=1
            v1 = int(version1[:i]) #if i==len(version1) version1[i]!='.' else int(version1[:i])
            version1 = version1[i+1:]
            while j<len(version2) and version2[j]!='.':
                j+=1
            v2 = int(version2[:j]) #if version2[f]!='.' else int(version2[:j])
            version2 = version2[j+1:]
            if v1<v2:
                return -1
            if v1>v2:
                return 1
        while len(version1)>0:
            i=0
            while i<len(version1) and version1[i]!='.':
                i+=1
            v1 = int(version1[:i])
            version1 = version1[i+1:]
            if v1>0:
                return 1
        while len(version2)>0:
            j=0
            while j<len(version2) and version2[j]!='.':
                j+=1
            v2 = int(version2[:j])
            version2 = version2[j+1:]
            if v2>0:
                return -1
        return 0
            
