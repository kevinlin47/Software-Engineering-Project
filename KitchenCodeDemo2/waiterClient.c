#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <string.h>
#include <sys/select.h>
#include <sys/time.h>
#include <unistd.h>
#include <errno.h>
#include <stdint.h>
#include <arpa/inet.h>
#include <signal.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <stdint.h>
#include <inttypes.h>
#include <netdb.h>

#define order_size		30
#define ADD_OPCODE		0
#define REMOVE_OPCODE	1
#define NOTIFY_OPCODE	2

void err_handle(char * arg)
{
	perror(arg);
	_Exit(2);
}

int main(int argc, char *argv[])
{
	if(argc<4){
		printf("Syntax: ./<WC <port number> <option> <dishname>\n");
		_Exit(2);
	}
	int opcode;
	if(strcmp("a",argv[2])==0)
		opcode = ADD_OPCODE;
	else if(strcmp("r",argv[2])==0)
		opcode = REMOVE_OPCODE;
	else{
		printf("Invalid option. Use 'a' or 'r'\n");
		_Exit(2);
	}
	
	uint16_t portno = atoi(argv[1]);

	int sockfd;
	struct sockaddr_in servaddr;
	char msg[order_size+1];
	bzero(&msg,order_size+1);

	// socket:
	if((sockfd=socket(AF_INET,SOCK_STREAM,0)) < 0)
		err_handle("main::socket");

	servaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
	servaddr.sin_family = AF_INET;
	servaddr.sin_port = htons(portno);
	
	// connect:
	if( (connect(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr))) < 0 )
		err_handle("main::bind");

	// send;
	char * DISH1 = "dish1";
	char * ordername = "DISH1";
	sprintf(msg,"%d %s",opcode,argv[3]);
	if( send(sockfd,msg,strlen(msg),0) < 0 )
		err_handle("main::send");
	
	// read:
	int readsize;
	char * cmsg = malloc(order_size+1);
	readsize=recv(sockfd,cmsg,order_size,/*MSG_DONTWAIT*/0);
	if(readsize<0)
		err_handle("main::recv");
	
	strsep(&cmsg," ");
	printf("%s is finished\n",cmsg);
	
	
	return 0;
}
//eof
















