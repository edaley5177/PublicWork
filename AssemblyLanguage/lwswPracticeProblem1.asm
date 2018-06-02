  # (a+b)/2 store result in ave
  # ave  = (a+b)/2;
    	.text
# your code here
	lw	$t0,a	
	lw	$t0,b
	
	add 	$t1,$t1,27
	add	$t2,$t2,95
	sw	$t1,a
	sw	$t2,b
	
	add 	$t3,$t1,$t2
	div	$t4,$t3,2
	
	sw	$t4,ave
     .data
a:   .word  27
b:   .word  95
ave: .word  0		# this should become 61
	
	
	
	
	
		