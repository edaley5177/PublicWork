#input a number n and compute 1+2+3+4...n and output the result
	.text
#input n	
	li	$v0,5		#n=input value
	syscall
#initialize loop
#prepare variables

	li	$s0,0	#sum = 0
	li	$t0,1	#i =1
	
#see if i>n so finish the loop
loop:
	bgt 	$t0,$v0,done
	add	$s0,$s0,$t0	#sum +=i
	addi	$t0,$t0,1	#i += 1
	b	loop
	
#output sum
done:
	move	$a0,$s0
	li	$v0,1
	syscall
	
	#exit 
	li	$v0,10
	syscall
	