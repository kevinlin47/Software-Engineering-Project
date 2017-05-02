/*
 *	Header file for kitchen
 *	Contains class and function declarations
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
#include <string>
using namespace std;

#define NAMELEN			15

const int MAX_ORDERS_SIZE = 5;

// coefficients used for order prioiritization:
const double DINEIN_COEFF = .001;
const double TAKEOUT_COEFF = .00099999;

/*****************
**	Definitions	**
*****************/
int unitTest();

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

	// members:
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
	int find_and_remove(char*);

	Hub();
	
	// friends:
	friend class Hub::Station;
	friend class Chef;
	friend class Dish;
	friend class Dish::Component;
};

class Chef {
public:
	// members:
	char *name;
	int ID;

	// functions:
	int selectStation(Hub::Station*);
	int punchHours(int);

	Chef(char*);
	
	// friends:
	friend class Hub::Station;
	friend class Hub;
	friend class Dish;
	friend class Dish::Component;
};

void log_chef_to_stations(char* chefname,char *statname);
void kserver_notify(char*);

#endif
