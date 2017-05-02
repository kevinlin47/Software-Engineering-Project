all: SWProj wc

SWProj: kitchen.cpp kitchen.h kitchenFunctions.cpp kitchenServer.h
	g++ kitchen.cpp kitchen.h kitchenFunctions.cpp kitchenServer.h -o SWP
	
wc:	waiterClient.c
	gcc waiterClient.c -o WC

