import copy

def restrict_perm(first, second):
    #print('first', first, 'second', second)
    out_list = []
    for a in range(len(first)):
        if first[a] in second:
            out_list.append(first[a])
    #print(out_list)        
    return out_list

matrix = [ [3, 2, 1, 0], [0, 1, 2, 3], [2, 0, 1, 3] , [3, 1, 0, 2],
               [3, 0, 1, 2], [2, 1, 0, 3], [3, 0, 1, 2] , [2, 1, 0, 3],
               [2, 0, 1, 3], [3, 1, 0, 2], [3, 2, 1, 0] , [0, 1, 2, 3]]

old_matrix = [     [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5],
               [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5],
               [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5],
               [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5],
               [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5], [5, 4, 3, 2, 1, 0], [0, 1, 2, 3, 4, 5]]               

#matrix = [ [0, 1, 2, 3], [3, 2, 1, 0], [0, 1, 2, 3] , [3, 2, 1, 0]]
m = len(matrix[0])
n = len(matrix)

# Set up combination dictionary by visiting all combinations
comb_list = []
restrict_dict = {}
# Knuth's Algorithm L to generate combinations
for t in range(2, m + 1):
    comb = [-1] + [a - 1 for a in range(1, t + 1)] + [m, 0]
    j = t
    count = 0
    while(True):
        #print(comb)
        comb_list.append(tuple(comb[1:-2]))
        count += 1
        #print(count)
        j = 1
        while comb[j] + 1 == comb[j + 1]:
            comb[j] = j - 1
            j += 1
        if j > t:
            break
        comb[j] = comb[j] + 1
#print(comb_dict)    

#Knuth's Algorithm M to generate tuples
tupl = (m + 1) * [0]
j = 0
tupl[0] = -1

while(True):
    # calculate permutation
    value_index_dict = {}
    a_tupl = tupl[1:]
    for a in range(m):
        entry = a_tupl[a]
        if not entry in value_index_dict:
            value_index_dict[entry] = [a]
        else:
            value_index_dict[entry].append(a)

    sorted_tupl = copy.deepcopy(a_tupl)
    sorted_tupl = list(set(sorted_tupl))
    sorted_tupl.sort(reverse = True)
    #print(a_tupl, value_index_dict, sorted_tupl)
    perm_out = []
    for thing in sorted_tupl:
        if len(value_index_dict[thing]) == 1:
            perm_out = perm_out + value_index_dict[thing]
        else:
            #print('The restriction of {} to {} is {}'.format(matrix[thing], value_index_dict[thing], restrict_perm(matrix[thing], value_index_dict[thing])))
            perm_out = perm_out + restrict_perm(matrix[thing], value_index_dict[thing])
    # intersect permutation with all combinations and log
    for comb in comb_list:
        restrict_comb = restrict_perm(perm_out, comb)
        if tuple(restrict_comb) in restrict_dict:
            restrict_dict[tuple(restrict_comb)] += 1
        else:
            restrict_dict[tuple(restrict_comb)] = 0            
    #print(tupl[1:], ' -> ', perm_out)
    j = m
    while tupl[j] == n - 1:
        tupl[j] = 0
        j -= 1
    if j == 0:
        break
    else:
        tupl[j] = tupl[j] + 1
        
print(restrict_dict)