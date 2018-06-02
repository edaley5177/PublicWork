#input 2 numbers and output the absolute value of the difference
	.text
	#read the first number
	li	$v0,5
	syscall
	move 	$t0,$v0
	#read the second number
	li	$v0,5
	syscall
	#compute the difference
	sub	$a0,$t0,$v0
	#if the difference is negative, make it positive
	bge	$a0,$0,skip
	sub	$a0,$0,$a0
skip:
#print the result to the console
	li	$v0,1
	syscall
	#terminate the program
	li	$v0,10
	syscall
	