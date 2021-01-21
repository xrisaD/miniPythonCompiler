def x(a,b):
    return a + b

def y(a,b):
    return x(a,b)

def c(a , b):
    return d(a,b)
def d(a,b):
    return c(a,b)

c = y(a,b) + 1
