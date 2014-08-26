import dfs

nodes = {
     1: [4],
     2: [4],
     3: [6],
     4: [7],
     5: [7],
     6: [7],
     7: [8],
     8: [9, 10],
     9: [11, 12],
    10: [],
    11: [],
    12: []
}


for i in range(1,13):
     visited = []
     dfs.visit(i, nodes, (lambda n: visited.append(str(n))))

     print (", ".join(visited))


