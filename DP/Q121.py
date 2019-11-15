class Solution_fail: O(n ~ n^n)
    def insertsort(self,myList):
        for i in range(1,len(myList)):
            key = myList[i]
            j = i - 1
            while j >= 0 and myList[j] > key:
                myList[j+1] = myList[j]
                j -= 1
            myList[j+1] = key
        return myList
    def seek(self,i,j,sortlist):
        if(i==len(sortlist)-1):
            return 0
        li = it.get(sortlist[i])
        hi = it.get(sortlist[j])
        if(li<hi):
            return sortlist[j]-sortlist[i]
        else:
            if(j==i):
                i = i+1
                j = len(sortlist)-1
                return self.seek(i,j,sortlist)
            j = j-1
            return self.seek(i,j,sortlist)
    def maxProfit(self, prices): # mutil zeros
        global it
        if(len(prices)==0 or len(prices)==1):
            return 0
        it = dict()
        isZero = 0
        for index,p in enumerate(prices):
            if(p==0):
                isZero +=1
            it[p] = index
        sl = self.insertsort(prices)
        i = 0
        if(isZero):
            for _ in range(isZero):
                i = i+1
        j = len(sl)-1
        return self.seek(i,j,sl)
    def maxProfit(self, prices): # one zero
        global it
        if(len(prices)==0 or len(prices)==1):
            return 0
        it = dict()
        isZero = False
        for index,p in enumerate(prices):
            if(p==0):
                isZero = True
            it[p] = index
        sl = self.insertsort(prices)
        i = 0
        if(isZero):
            i = 1
        j = len(sl)-1
        return self.seek(i,j,sl)