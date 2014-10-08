'''
Created on October 7th, 2014

@author: Dickson D'Cunha
@studentid: 0904177

Cis1250 Lab4
'''

#!/usr/bin/python

''' Better version maybe
print("Enter some value(s) to add. Type 'exit' to obtain the total")

num = raw_input()
total = 0
while (number != 'exit'):
    total += int(num)
    num = ""
    num = raw_input()

print "Total = ", total
'''

inp = ""
total = 0;
while (inp != "exit"):
    inp = raw_input()
    if (inp != "exit"):
        total += int(inp)
print "Total = ", total


