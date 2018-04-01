/*
 *	Header file for kitchen
 *	Contains class and function definitions
 */


#ifndef KITCHEN_H_
#define KITCHEN_H_


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctime>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>


using namespace std;

const int MAX_ORDERS_SIZE = 5;

// coefficients used for order prioiritization:
const double DINEIN_COEFF = .01;
const double TAKEOUT_COEFF = .0099999;

/*****************
**	Definitions	**
*****************/
class Dish;
class Hub;
class Chef;

class Dish {
public:
	class Component {
	public:
		char* name;
		char* relevantStation;
		int startTime;
		int endTime;
		int status;
		
		Component() { ; }
		Component(char* str, char* station);

		friend class Dish;
		friend class Hub;
	};

	vector<Component*> components;
	char *name;
	int startTime;
	int endTime;
	int receiveTime;
	int status = 0;
	int weight;
	int sentToStations;

	// values for prioritization in waitingOrders queue:
	double pcoeff;
	double pvalue;

public:
	Dish() { ; }
	Dish(char*, char*, char*, double);
	int checkCompStatus();
	int setStart();
	int setEnd();

	// operator overloading: <,>,etc compare item pvalue:
	bool operator<(Dish const other) { return pvalue < other.pvalue; }
	bool operator>(Dish const other) { return pvalue > other.pvalue; }
	bool operator>=(Dish const other) { return pvalue >= other.pvalue; }
	bool operator<=(const Dish other) { return pvalue <= other.pvalue; }


	friend class Hub;
	friend class Dish::Component;
	friend class Chef;
};




class Hub {
public:
	class Station {
	public:
		char* name;
		Chef* attendant;
		vector<Dish::Component*> components;
		vector<Dish*> dishReferences;

		Station();
		Station(Chef*, char*);


		int selectChef(Chef*);
		int checkComponents();
		int addComponent(Dish*, Dish::Component*);
		int removeComponent(Dish*, Dish::Component*);

		friend class Hub;
		friend class Chef;
		friend class Dish;
		friend class Dish::Component;
	};

	vector<Dish*> orders;
	vector<Dish*> waitingOrders;
	vector<Station*> stations;
	vector<Chef*> staff;

	int orderBit;
	int prioritizationBit;

	// functions:
	int addStation(char*);
	int pushOrder();
	int notifyDone(Dish*);
	int addOrder(Dish*);
	int recordTimes(Dish*);
	int sendOrders();
	int completeComponent(int stations_it,int components_it);
	int checkOrder(int stations_it, int components_it);
	int removeOrders();
	void printOrders();
	int removeOrder(int dish_it);
	int sortWaitingOrders();

	Hub();

	friend class Hub::Station;
	friend class Chef;
	friend class Dish;
	friend class Dish::Component;
};

class Chef {
public:
	char *name;
	int ID;

	int selectStation(Hub::Station*);
	int punchHours(int);

	Chef(char*);

	friend class Hub::Station;
	friend class Hub;
	friend class Dish;
	friend class Dish::Component;
};



#endif
