#input an interger and output twice the value
	.text
	addi 	$v0,$0,5
	syscall
	add	$a0,$v0,$v0
	addi	$v0,$0,1
	syscall
	
	