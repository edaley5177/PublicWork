#test program
#(4+5)/2
#store result in t5

	addi 	$t1,$0,4
	addi 	$t2,$0,5
	add	$t3,$t1,$t2
	addi	$t4,$0,2
	div 	$t3,$t4
	mflo	$t5