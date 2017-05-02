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

#include "kitchen.h"

#define order_size		30
#define ADD_OPCODE		0
#define REMOVE_OPCODE	1
#define NOTIFY_OPCODE	2


void err_handle(char * arg)
{
	perror(arg);
	_Exit(2);
}

		/*************
		**	GLBL	**
		*************/
int sockfd, csock, cfd, readsize;
socklen_t socksize;
struct sockaddr_in servaddr, cliaddr;
char cmsg[NAMELEN];
int servport;

void kserver_get(Hub &hub)
{	
	cout << "Getting new orders...\n";
	//sleep(3);
	// accept:
	socksize = sizeof(struct sockaddr_in);
	if( (csock=accept4(sockfd,(struct sockaddr *)&cliaddr,&socksize,SOCK_NONBLOCK))<0 ){
		if( errno == EWOULDBLOCK || errno == EAGAIN ){
			printf("No new orders received.\n");
			return;
		}
		err_handle("main::accept");
	}
	// read:
	readsize=recv(csock,cmsg,order_size,MSG_DONTWAIT);
	if(readsize<0)
		err_handle("main::recv");
		
	// process order:
	//printf("Received: %s\n",cmsg);
	char * temp = (char *)malloc(order_size);
	strcpy(temp,cmsg);
	char *numstr = strsep(&temp," ");
	int opcode = atoi(numstr);
	char * ordername = (char *)malloc(NAMELEN);
	strcpy(ordername,temp);
	
	Dish *d;
	int it;
	
	char *compnameA = (char*)malloc(NAMELEN);
	char *compnameB = (char*)malloc(NAMELEN);
	sprintf(compnameA,"%scompA",ordername);
	sprintf(compnameB,"%scompB",ordername);
	
	switch(opcode){
	case ADD_OPCODE:
		printf("ADDING order %s\n",ordername);
		d = new Dish(ordername, compnameA, compnameB, DINEIN_COEFF);
		hub.addOrder(d);
		break;
	case REMOVE_OPCODE:
		printf("REMOVING order %s\n",ordername);
		if(hub.find_and_remove(ordername)<0)
			printf("Order not found.");
		break;
	}
	return;
}

void kserver_notify(char * dishname)
{
	char * notifymsg = (char*)malloc(30);
	
	sprintf(notifymsg,"%d %s",(NOTIFY_OPCODE),dishname);
	
	if( send(csock,notifymsg,strlen(notifymsg),0) < 0 )
		err_handle("main::send");
	
	return;
}

int kserver_start(Hub &hub)
{
		
	// socket:
	if( (sockfd=socket(AF_INET,SOCK_STREAM | SOCK_NONBLOCK,0)) < 0 )
		err_handle("main::socket");
	
	// bind:
	servaddr.sin_family = AF_INET;
	servaddr.sin_addr.s_addr = INADDR_ANY;
	servaddr.sin_port = htons(servport);
	
	if( bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr)) < 0 )
		err_handle("main::bind");
	
	// listen:
	if(listen(sockfd,10)<0)
		err_handle("main::listen");
	
	
	return 0;	
}

