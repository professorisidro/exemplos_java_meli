M = int(input())
A = int(input())
B = int(input())
C = M - A - B
if C > A and C > B:
    print(C)
elif B > A and B > C:
    print(B)
else:
    print(A)
