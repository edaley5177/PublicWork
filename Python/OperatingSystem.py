#methods provided in the operating system
import os, sys
#os.open(file,flags,mode(opt))-open file with flags
#flags: os.O_RDONLY, os.O_WRONLY-open with read only permissions, and write only respectively
#os.O_RDWR-open for reading and writing
#os.O_NONBLOCK- do not block on open
#os.O_APPEND- append on each write, start writing at end of file
#os.O_CREAT-create file if it doesn't exist
#os.O_TRUNC-truncate size to 0
#os.O_EXCL-error if create and file exists
#os.O_SHLOCK-automatically obtain shared lock
#os.O_EXLOCK-automatically obtain exclusive lock
#os.O_DIRECT-eliminate or reduce cache effects
#os.O_FSYNC-synchronus writes
#os.O_NOFOLLOW-do not follow symlinks
fd = os.open("f1.txt", os.O_RDWR|os.O_CREAT)
line ="This is a test"
b=str.encode(line)#convert to byte object

#os.write(fd,str)-write the string str to the file descriptor fd. Return the number of bytes actually written
ret =os.write(fd,b)
print "the number of bytes written", ret

#os.close(fd)-close the file descriptor
os.close(fd)

fd =os.open("f1.txt", os.O_RDWR)

#os.read(fd,n)-read atmost n bytes from file descriptor fd. Return a string containing the bytes read. 
red=os.read(fd,ret)
print "this was read", red.decode()

os.close(fd)
#os.chflags(path, flags)-set the flags of path to the numeric flags

#os.chmod(path, mode)-change the mode of path to the numeric mode

#os.chown(path, uid, gid)-change the owner and group id of path to the numeric uid and gid

#os.chroot(path)-change the root directory to the current process path

#os.symlink(src,dest)-create a symbolic link to src named dest





#os.getcwd()-return a string representing the current working directory
print "current directory:", os.getcwd()


#os.mkdir(path, mode(opt))-create a directory named path with nunmeric mode

#os.rmdir(path)-remove the directory path, the directory must be empty

#os.rename(src,dest)-rename the file or directory src to dest
fd = os.open("f1.txt", os.O_RDWR)

os.rename("f1.txt", "other.txt")

print "file has been renamed"

#os.remove(path)-remove the file path
os.remove("other.txt")
print "file has been deleted"

#os.chdir(path)-change the current working directory to path
os.chdir("Strings")

print "after changing to Strings: ", os.getcwd()
#os.listdir(path)-returns a list containg the names of the entries in the directory given by path




