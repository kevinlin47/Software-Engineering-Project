/*
 *	Main function for kitchen
 *
 */

#include "kitchen.h"
#include "kitchenServer.h"

int main(int argc, char * argv[])
{
	if(argc < 2){
		printf("Syntax:./<programname> <portno>.\n");
		_Exit(2);
	}
	servport = atoi(argv[1]);
	// option for unit testing:
	int uTest = 0;
	uTest = unitTest();
	

	// create a chef:
	char* cname = "John";
	Chef chef1(cname);
	cname = "Jane";
	Chef chef2(cname);


	// create the hub, add stations, give chef to stations:
	Hub hub;
	hub.addStation("FRY");
	hub.addStation("OVEN");
	hub.stations[0]->selectChef(&chef1);
	hub.stations[1]->selectChef(&chef2);
	
	log_chef_to_stations(chef1.name,hub.stations[1]->name);
	log_chef_to_stations(chef2.name,hub.stations[1]->name);
	
	
	
	// start up the server:	
	kserver_start(hub);
	
	// make a few  dummy orders in queue waitingOrders:
	Dish *d;
	d = new Dish("dish1", "compA1", "compB1", DINEIN_COEFF);
	hub.addOrder(d);
	d = new Dish("dish2TO", "compA2TO", "compB2TO", TAKEOUT_COEFF);
	hub.addOrder(d);
	d = new Dish("dish3", "compA3", "compB3", DINEIN_COEFF);
	hub.addOrder(d);
	d = new Dish("dish4", "compA4", "compB4", DINEIN_COEFF);
	hub.addOrder(d);
	d = new Dish("dish5TO", "compA5TO", "compB5TO", TAKEOUT_COEFF);
	hub.addOrder(d);
/*
	d = new Dish("dish6", "compA6", "compB6", DINEIN_COEFF);
	hub.addOrder(d);
*/	
	
	// push orders:
	int breakthewhile=0;
	while (hub.orders.size() < MAX_ORDERS_SIZE) {
		if (hub.orders.size() >= MAX_ORDERS_SIZE)
			break;
		hub.pushOrder();
		++breakthewhile;
		if(breakthewhile>=(MAX_ORDERS_SIZE+5))
			break;
	}


	//test: print list of hub orders (test included):
	cout << "list of ready orders:\n";
	for (int i = 0; i < hub.orders.size(); ++i) {
		cout << "\t" << hub.orders[i]->name;
		if(uTest == 1) // TEST
			cout <<	"\t TEST: pvalue: " << hub.orders[i]->pvalue;
		cout << endl;
	}


	// next part:
	int s = 0;
	int s2 = 0;
	int s3 = 0;
	while (s != -1) {
		cout << "enter (1 to continue, -1 to exit): ";
		cin >> s;
		if (s == -1)
			break;
		
		// get orders from server:
		kserver_get(hub);

		//TEST: print number of orders waiting:
		if (uTest == 1) {
			cout << "TEST: Number of orders waiting: " << hub.waitingOrders.size() << endl;
		}

		// push orders:
		while(hub.orders.size() < MAX_ORDERS_SIZE) {
			if (hub.orders.size() >= MAX_ORDERS_SIZE)
				break;
			hub.pushOrder();
		}

		
		// print station A and B orders:
		hub.printOrders();
		

		while (1) {
			// ask user to mark complete component
			cout << "enter station (-1 repopulate list): ";
			cin >> s2;
			if (s2 == -1)
				break;
			if (s2 >= MAX_ORDERS_SIZE || s2 < 0) {
				cout << "Invalid station.\n";
			}
			cout << "enter component: ";
			cin >> s3;
			if (s2 == -1 || s3== -1)
				break;
			if (s3 >= MAX_ORDERS_SIZE || s3 < 0) {
				cout << "Invalid component.\n";
			}

			// complete components:
			hub.completeComponent(s2, s3);

			// remove completed components and notify that order is done:
			int temp;
			temp = hub.checkOrder(s2, s3);
			if (temp == true) {
				if (uTest == 1) {
					cout << "complete.\n";
				}
				hub.notifyDone(hub.stations[s2]->dishReferences[s3]);
				hub.removeOrder(s3);
			}
			else {
				if (uTest == 1) {
					cout << "incomplete.\n";
				}
			}
			hub.printOrders();
		}
		
	};
	

	return 0;
}
