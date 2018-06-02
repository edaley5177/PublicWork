# b = a+2
		.text
		lw	$t0,a
		addi	$t0,$t0,2
		sw	$t0,b
		.data
a:		.word	29
b:		.word	0
