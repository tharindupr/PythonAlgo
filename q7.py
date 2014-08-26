def compute_prefix_function(p):
    m = len(p)
    pi = [0] * m
    k = 0
    for q in range(1, m):
        while k > 0 and p[k] != p[q]:
            k = pi[k - 1]
        if p[k] == p[q]:
            k = k + 1
        pi[q] = k
    return pi


def knp(text='', pattern=''):
 

    n = len(text)
    m = len(pattern)
    offsets = []
    pi = compute_prefix_function(pattern)
    q = 0
    for i in range(n):
        while q > 0 and pattern[q] != text[i]:
            q = pi[q - 1]
        if pattern[q] == text[i]:
            q = q + 1
        if q == m:
            offsets.append(i - m + 1)
            q = pi[q-1]

    return offsets

patterns=int(input())
pt=[]
for i in range(0,patterns):
     pt.append(input().strip())
text=input().strip()

occur={}
for p in pt:
     occur[p]=(len(knp(text,p)))

maxi=occur[max(occur, key=occur.get)]



print(maxi)


    
ar=[]
for i in occur:
    if(occur[i]==maxi):
        ar.append(i)

for q in pt:
    if q in ar:
        print(q)

    
    
