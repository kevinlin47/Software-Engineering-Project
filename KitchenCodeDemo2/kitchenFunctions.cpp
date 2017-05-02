/*
 *	Function definitions for kitchen.h
 *
 */


#include "kitchen.h"


 // variable used for unit testing:
int unitTester = 0;

			/*************************
			**	general functions	**
			*************************/

// selects the option for unit testing output:
int unitTest()
{
	while (1) {
		cout << "Run with unit testing?(1 for yes, 0 for no): ";
		cin >> unitTester;
		if (unitTester == 1 || unitTester == 0)
			return unitTester;
	}
}


			/*********************
			**	Hub functions	**
			*********************/

// constructor
Hub::Hub(){ return; }

// prints all orders of all stations in Hub.stations[]
void Hub::printOrders()
{
	cout << "\n\n";
	for (int stat_i = 0; stat_i < stations.size(); ++stat_i) {
		cout << stat_i << ".  " << stations[stat_i]->name << ": "
		<< stations[stat_i]->attendant->name << endl;
		for (int comp_i = 0; comp_i < stations[0]->components.size(); ++comp_i) {
			cout << "\t" << comp_i << ".  "
				<< stations[stat_i]->components[comp_i]->name << endl;
		}
	}
	return;
}

// adds a station to hub of name stationName
int Hub::addStation(char* stationName)
{
	Station *station = new Station;
	station->name = stationName;
	stations.push_back(station);

	// test:
	if (unitTester == 1)
		cout << "TEST: station added successfully.\n";
	return 0;
}

// sorts waiting orders, pop top order off waitingOrders, and push_back onto orders
// then sends components to stations
int Hub::pushOrder()
{
	sortWaitingOrders();
	if (orders.size() >= MAX_ORDERS_SIZE)
		return 0;
	Dish *top = waitingOrders.front();
	orders.push_back(top);
	waitingOrders.erase(waitingOrders.begin());
	sendOrders();
	return 0;
}

// sends components to stations
int Hub::sendOrders()
{
	Dish::Component* comp;
	Dish* dish;
	for (int i = 0; i < orders.size(); ++i) { // for each order
		dish = orders[i];
		if (dish->sentToStations == 0){	// if dish was not sent
			dish->sentToStations = 1;
			for (int j = 0; j < dish->components.size(); ++j) { // for each component
				comp = orders[i]->components[j];

				for (int k = 0; k < stations.size(); ++k) {	// find the relevent station
					if (strcmp(orders[i]->components[j]->relevantStation, stations[k]->name) == 0) {
						stations[k]->addComponent(dish, comp);
					}
				}
			}
		}
	}
	// TEST:
	if (unitTester == 1)
		cout << "TEST: orders sent successfully.\n";
	return 0;
}

// notify waiters that dish is done (client-server?)
int Hub::notifyDone(Dish *d)
{
	printf("Notify waiters that %s is complete.\n", d->name);
	kserver_notify(d->name);
	return 0;
}

// adds Dish* order to waitingOrders queue
int Hub::addOrder(Dish *order)
{
	waitingOrders.push_back(order);
	// Test:
	if (unitTester == 1)
		cout << "TEST: Order added to waitingOrders successfully.\n";
	return 0;
}

// marks the component complete
int Hub::completeComponent(int stations_it, int components_it)
{
	stations[stations_it]->components[components_it]->status = 1;
	return 0;
}

// checks if all orders of dish are complete
// components_it is used for dishReference
// returns 1 if dish complete, 0 if not
int Hub::checkOrder(int stations_it, int components_it)
{
	Dish* dish = stations[stations_it]->dishReferences[components_it];
	if (unitTester == 1)
		cout << "TEST: check order: " << dish->name << " ";
	for (int i = 0; i < dish->components.size(); ++i) {
		if (dish->components[i]->status == 0) {
			return 0;
		}
	}

	dish->status = 1;
	if (dish->status == 1 && unitTester == 1)
		cout << "TEST: dish->status changed successfully\n.";
	return 1;
}

// removes all completed orders:Dish from all stations and from orders[]
int Hub::removeOrders()
{
	//remove from all stations:
	Dish::Component* comp;
	Dish* dish;
	for (int i = 0; i < orders.size(); ++i) { // for each order
		dish = orders[i];
		if (dish->status == 1) {	// if dish is complete

			for (int j = 0; j < dish->components.size(); ++j) { // for each component
				comp = orders[i]->components[j];

				for (int k = 0; k < stations.size(); ++k) {	// find the relevent station
					if (strcmp(orders[i]->components[j]->relevantStation, stations[k]->name) == 0) {
						// remove from components[] and dishReferences[]:
						stations[k]->removeComponent(dish, comp);	
						return 0;
					}
				}
			}
		}
	}
	if (unitTester == 1) {
		cout << "TEST: removeOrders: not found!\n";
	}
	return -1;
}

// finds dish_it for function below and for kitchenServer removal opcode
// returns the dish_it. returns -1 if not found
int Hub::find_and_remove(char * name)
{
	for(int i = 0;i<orders.size();++i){
		if(strcmp(orders[i]->name,name)==0){
			if(unitTester == 1){
				cout << "TEST: find_dish_it(): dish found at " << i <<endl;
			}// end unittester if
			removeOrder(i);
			return i;
		}// end if 1
	}//end for
	cout << "Dish " << name << " not found.\n";
	return -1;
}


int Hub::removeOrder(int dish_it)
{
	for (int i = 0; i < stations.size(); ++i) {
		stations[i]->components.erase(stations[i]->components.begin() + dish_it);
		stations[i]->dishReferences.erase(stations[i]->dishReferences.begin() + dish_it);
	}
	orders.erase(orders.begin() + dish_it);
	if (unitTester == 1) {
		cout << "TEST: Order removed successfully.\n";
	}
	return 0;
}

int Hub::sortWaitingOrders()
{
	Dish* temp;
	for (int i = 0; i < (waitingOrders.size()-1); ++i) {
		for (int j = 1; j < waitingOrders.size(); ++j) {
			if (waitingOrders[i]->pvalue < waitingOrders[j]->pvalue) {
				temp = waitingOrders[i];
				waitingOrders[i] = waitingOrders[j];
				waitingOrders[j] = temp;
			}
		}
	}
	if (unitTester == 1)
		cout << "TEST: waitingOrders sorted successfully.\n";
	return 0;
}


			/*************************
			**	Station functions	**
			*************************/


// constructors
Hub::Station::Station() { ; }
Hub::Station::Station(Chef *att, char *n)
{
	name = n;
	attendant = att;
	return;
}

// removes 1 instance of component* and dish* from components[] and dishReferences[]:
// returns 0 if success, -1 otherwise
int Hub::Station::removeComponent(Dish* dish, Dish::Component* comp)
{
	return 0;
}

// set Chef chef as station's attendant
// takes Chef*, return 0 if success, -1 otherwise
int Hub::Station::selectChef(Chef *chef)
{
	attendant = chef;
	if(chef->name == NULL){
		printf("selectChef: Invalid chef");
		return -1;
	}
	return 0;
}

int Hub::Station::addComponent(Dish* dish, Dish::Component* comp)
{
	components.push_back(comp);
	dishReferences.push_back(dish);
	return 0;
}


			/*********************
			**	Chef functions	**
			*********************/

// create chef with name cname
Chef::Chef(char* cname)
{
	name = cname;
	return;
}

// sets station.attendant to this chef pointer
int Chef::selectStation(Hub::Station *station)
{
	station->attendant = this;
	return 0;
}

// sets the start time or end time for a chef
// 0 sets start time, 1 sets end time to current time
// NOTE: NOT YET IMPLEMENTED
int Chef::punchHours(int selector)
{
	if (selector == 0) {
		// set start time
	}
	else if (selector == 1) {
		// set end time
	}
	else{
		return -1;
	}
	return 0;
}



			/*********************
			**	Dish functions	**
			*********************/


// constructor: Name, componentA, componentB
Dish::Dish(char* dishName, char* compA, char* compB, double coefficient)
{
	sentToStations = 0;
	receiveTime = time(NULL);
	pcoeff = coefficient;
	pvalue = time(NULL)*pcoeff;
	status = 0;

	name = dishName;

	Component *comp = new Component(compA,"FRY");
	components.push_back(comp);
	comp = new Component(compB, "OVEN");
	components.push_back(comp);

	if (unitTester == 1)
		cout << "TEST: Dish created successfully.\n";

	return;
}



			/*************************
			**	Component functions	**
			*************************/

// constructor
Dish::Component::Component(char* str, char* station)
{
	name = str;
	relevantStation = station;
}

			/*************************
			**		misc functions	**
			*************************/

void log_chef_to_stations(char* chefname,char *statname)
{
	time_t now;
    char time_str[50];
	char logstring[100];
	
    /* Get a formatted time string */
    now = time(NULL);
    strftime(time_str, (2*NAMELEN)-1, "%a %d %b %Y %H:%M:%S %Z", localtime(&now));
	
    /* Return the formatted log entry string */
    sprintf(logstring, "%s: %s to %s\n", time_str, chefname, statname);
	
	// write to file:
	FILE* fp;
	if( (fp=fopen("cheflog.txt","a"))==NULL)
		;//err_handle("kitchenFunctions::log_chef_to_stations::fopen");
	if(fwrite(logstring,1,strlen(logstring),fp)<0)
		;//err_handle("kitchenFunctions::log_chef_to_stations::fread");		
	fclose(fp);
	return;
}


