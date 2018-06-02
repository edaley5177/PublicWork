    .text
    li	   $v0,0
    syscall
    move    $s0,$v1
    move	$s1,$s0
    #sub    $s0,$v0,$0
    #add    $s1,$0,$s0
    mul    $s0,$s1
    mflo   $s3
    
    li	   $a0,0
    move	$a0,$s1
    #addi   $a0,$s3,0
    
    li	   $v0,1
    
    #addi   $v0,$0,1
    
    syscall