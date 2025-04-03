n = [] # 리스트로 선언

while True : 
    sum = 0
    n = input()
    if n == '0' : 
        break
    sum += len(n) + 1  
    
    for i in range(len(n)) : 
        if n[i] == '1' : 
            sum += 2    
        elif n[i] == '0' : 
            sum += 4
        else :             
            sum += 3
    print(sum) 