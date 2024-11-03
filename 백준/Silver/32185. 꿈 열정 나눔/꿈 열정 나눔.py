def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    
   
    N, M = map(int, data[0].split())
    
    
    V0, P0, S0 = map(int, data[1].split())
    totalJaewon = V0 + P0 + S0
    
    
    students = []
    for i in range(2, 2 + N):
        V_i, P_i, S_i = map(int, data[i].split())
        total_i = V_i + P_i + S_i
        if total_i <= totalJaewon:
            students.append((total_i, i - 2 + 1))  # (total stats, original index)
    
   
    students.sort(reverse=True, key=lambda x: x[0])
    
  
    team_members = [0]  
    for i in range(min(M - 1, len(students))):
        team_members.append(students[i][1]) 

   
    print(" ".join(map(str, team_members)))

if __name__ == "__main__":
    main()
