# grade-11-computer-science


 PART 1 (6/14/2025)    
Started working thursday night, finished part one on Saturday, plan to work more on Sunday

ArrayList<String> serviceNames - store the names of the services (example "jake and son plumbing")
ArrayList<String> serviceCategories - stores the category for each of the service (plumbing)
ArrayList<Double> hourlyRates - storess the hourly rate for each service (17.85)
boolean running - used to keep the menu to loop until the user picks and exit (set to false and it stops)
scanner input -  add user

in my menu system I used a while loop, it keeps the menu running till the user exits
it prints 
(1. add a service)
(2. exit         )









PART 2 (6/15/2025)
from 6/15 in the morning to 1:20 am (6/16) i finished part 2

added
ArrayList<Boolean> isBooked - each service provider is booked only once a day
ArrayList<String> categories - adds categories for number 2
int categNum - claims the number from the user
String chosenCat - show services in that category
ArrayList<Integer> found - finds services out of each category
int servNum - stores the service's number
int realIndex - converts users choice to the services real index (subtract 1 from users choice)









PART 3
from 6/16 at 8 pm to 10:23 pm, i finished part 3 (adding the cart)
My first half of the code was deleted on accident, I had to rewrite it
Tomorrow is part 4  (checkout)

added
ArrayList<Integer> cart - turns into a functioning online cart
int index - gets the index of the service in the cart










PART 4 - FINAL
from 6/17, 3:34 pm to 11:03 pm. I'm glad to say I've finished the marketplace. if it wasn't for some help from the help of my friend and going back and forth on previous lessons to code, I don't know how I'd do this.

from him I learned
.get - gets whats stored in array
.set - lets you change arrays value, updates the availability
.size - returns the size of the array
.equalsIgnoreCase - does the confirm variable equal to yes (ignoring capitalization)

added
- remove service from cart
- check out
- int removeNum - lets you remove a service by using a number
- int removeIndex - holds the actual index of the service that the user wants to remove from their cart








