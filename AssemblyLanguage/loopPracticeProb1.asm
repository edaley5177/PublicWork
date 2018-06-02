#take an input int n and print even numbers up to that including it if it is even

 	.text
 	li $v0,5	#n=input
 	syscall
 	move 	$s0,$v0
 	
 #prepare variables for the loop
 	li	$a0,2	#i=2
 	
 loop:
 	#if i>n,exit loop
 	bgt	$a0,$s0,done
 		#out put current i value
 		
 		li	$v0,1
 		syscall
 		
 		addi	$a0,$a0,2	#i+=2
 	b	loop
 	
 done:
 #end program
 	li	$v0,10
 	syscall
 		